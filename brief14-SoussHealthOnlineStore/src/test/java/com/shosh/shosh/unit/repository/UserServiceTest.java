package com.shosh.shosh.unit.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import com.shos.shos.ShosApplication;
import com.shos.shos.entity.User;
import com.shos.shos.enums.FilterCond;
import com.shos.shos.repository.UserRepository;
import com.shos.shos.response.UserResponse;
import com.shos.shos.service.UserService;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = ShosApplication.class)
public class UserServiceTest {



//  @MockBean    
    @Mock
    private UserRepository userRepository;

//  @Autowired
    @InjectMocks
    private UserService userService;

    @Autowired
    private User user;
    
    
  
    
    @Test
    public void trytest() {
        User user1 = new User();
        User user2 = new User();

		when(userRepository.findAll()).thenReturn(List.of(user1 , user2));
	
		 

        UserResponse users = userService.getAll(0, 10, "id", "ASC", null, null, null, null);
		Assertions.assertEquals(users.getTotalElements(), 7, "Expected 2 users in the database");
//        verify(userRepository, times(1)).findAll();
//        verifyNoMoreInteractions(userRepository);
    }
    

//    @BeforeEach
//    public void setup(){
        //userRepository = Mockito.mock(UserRepository.class);
        //userService = new UserServiceImpl(userRepository);
//        user = User.builder()
//                .id(1L)
//                .firstName("Ramesh")
//                .lastName("Fadatare")
//                .email("ramesh@gmail.com")
//                .build();
//    }

//    @DisplayName("Test getAll")
//    @Test
//    public void getAll_success() {
//    	User user1 = new User();
//    	User user2 = new User();
//        doReturn(Arrays.asList(user1, user2)).when(userRepository).findAll();
//
//        UserResponse users = userService.getAll(0, 0, null, null, null, null, null, null);
//
//        Assertions.assertEquals(2, users.getTotalElements(), "getAll Should return 2 users.");
//
//    }
//    
//    // JUnit test for getAllUsers method
//    @DisplayName("JUnit test for getAllUsers method")
//    @Test
//    public void givenUsersList_whenGetAllUsers_thenReturnUsersList(){
//        // given - precondition or setup
//
//        User user1 = User.builder()
//                .id(2L)
//                .firstName("Tony")
//                .lastName("Stark")
//                .email("tony@gmail.com")
//                .build();
//
//        given(userRepository.findAll()).willReturn(List.of(user,user1));
//
//        // when -  action or the behaviour that we are going test
//        List<User> userList = userService.getAllUsers();
//
//        // then - verify the output
//        assertThat(userList).isNotNull();
//        assertThat(userList.size()).isEqualTo(2);
//    }

//    // JUnit test for getAllUsers method
//    @DisplayName("JUnit test for getAllUsers method (negative scenario)")
//    @Test
//    public void givenEmptyUsersList_whenGetAllUsers_thenReturnEmptyUsersList(){
//        // given - precondition or setup
//
//        User user1 = User.builder()
//                .id(2L)
//                .firstName("Tony")
//                .lastName("Stark")
//                .email("tony@gmail.com")
//                .build();
//
//        given(userRepository.findAll()).willReturn(Collections.emptyList());
//
//        // when -  action or the behaviour that we are going test
//        List<User> userList = userService.getAllUsers();
//
//        // then - verify the output
//        assertThat(userList).isEmpty();
//        assertThat(userList.size()).isEqualTo(0);
//    }

}
