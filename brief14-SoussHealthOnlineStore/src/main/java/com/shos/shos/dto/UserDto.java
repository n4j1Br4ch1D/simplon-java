package com.shos.shos.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.shos.shos.entity.Permission;
import com.shos.shos.enums.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	    @NotNull
	 	private Long id;
		@NotEmpty
	    @Schema(description="FirstName should not be blank",required = true,example = "Suresh")
		@Column(unique=true)
	    private String userName;
		@NotNull
	    private String fullName;
		@NotNull
		private boolean isMale;
		@NotEmpty
		@Column(unique=true)
		private String email;
		@NotEmpty
//		@JsonIgnore
		private String password;
		@NotEmpty
		private String tel;
		@Enumerated(EnumType.STRING)
		private Role role;
		@NotNull
	    private boolean enabled;
	    private Collection<Permission> permissions;
	    
		public void setPassword(String password) {
			this.password = new BCryptPasswordEncoder().encode(password);
	        //user.setPassword(new BCryptPasswordEncoder().encode(password));

		}

	    
//
//	    // title should not be null  or empty
//	    // title should have at least 2 characters
//	    @ApiModelProperty(value = "Blog post title")
//	    @NotEmpty
//	    @Size(min = 2, message = "Post title should have at least 2 characters")
//	    private String title;
//
//	    // post description should be not null or empty
//	    // post description should have at least 10 characters
//	    @ApiModelProperty(value = "Blog post description")
//	    @NotEmpty
//	    @Size(min = 10, message = "Post description should have at least 10 characters")
//	    private String description;
//
//	    // post content should not be null or empty
//	    @ApiModelProperty(value = "Blog post conent")
//	    @NotEmpty
//	    private String content;
//
//	    @ApiModelProperty(value = "Blog post comments")
//	    private Set<CommentDto> comments; 
}
