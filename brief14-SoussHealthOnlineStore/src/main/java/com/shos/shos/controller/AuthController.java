package com.shos.shos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shos.shos.dto.LoginDto;
import com.shos.shos.dto.LoginRequest;
import com.shos.shos.entity.User;
import com.shos.shos.enums.Role;
import com.shos.shos.repository.UserRepository;
import com.shos.shos.service.AuthService;
import com.shos.shos.utils.JwtTokenUtil;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@Tag(name = "Auth")
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    protected final Log logger = LogFactory.getLog(getClass());

    final UserRepository userRepository;
    final AuthenticationManager authenticationManager;
    final AuthService userDetailsService;
    final JwtTokenUtil jwtTokenUtil;

    public AuthController(UserRepository userRepository, AuthenticationManager authenticationManager,
                                    AuthService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/signin")
   public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginDto) {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken( loginDto.getUsername()
                    , loginDto.getPassword()));
            if (auth.isAuthenticated()) {
                logger.info("Logged In");
                Map<String, Object> authUser = userDetailsService.authUser(loginDto.getUsername());
                UserDetails userDetails = (UserDetails) authUser.get("authUser");
                @SuppressWarnings("unchecked")
				Optional<User> user = (Optional<User>) authUser.get("user");

                
                String token = jwtTokenUtil.generateToken(userDetails);
                responseMap.put("error", false);
                responseMap.put("message", "Logged In");
                responseMap.put("token", token);
                responseMap.put("user", user);

                return ResponseEntity.ok(responseMap);
            } else {
                responseMap.put("error", true);
                responseMap.put("message", "Invalid Credentials");
                return ResponseEntity.status(401).body(responseMap);
            }
        } catch (DisabledException e) {
            e.printStackTrace();
            responseMap.put("error", true);
            responseMap.put("message", "User is disabled");
            return ResponseEntity.status(500).body(responseMap);
        } catch (BadCredentialsException e) {
            responseMap.put("error", true);
            responseMap.put("message", "Invalid Credentials");
            return ResponseEntity.status(401).body(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("error", true);
            responseMap.put("message", "Something went wrong");
            return ResponseEntity.status(500).body(responseMap);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestParam("full_name") String fullName,
                                      @RequestParam("user_name") String userName, @RequestParam("email") String email
            ,  @Schema(type = "string", format = "password") @RequestParam("password") String password) {
        Map<String, Object> responseMap = new HashMap<>();
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setRole(Role.ROLE_CLIENT);
        user.setUserName(userName);
        UserDetails userDetails = userDetailsService.createUserDetails(userName, user.getPassword());
        String token = jwtTokenUtil.generateToken(userDetails);
        userRepository.save(user);
        responseMap.put("error", false);
        responseMap.put("userName", userName);
        responseMap.put("message", "Account created successfully");
        responseMap.put("token", token);
        return ResponseEntity.ok(responseMap);
    }
    
    @PostMapping("/signout")
    public ResponseEntity<?> signOut() {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("error", false);
        responseMap.put("SignedOut", true);
        responseMap.put("message", "Account Signed Out successfully");
        return ResponseEntity.ok(responseMap);
    }
}
