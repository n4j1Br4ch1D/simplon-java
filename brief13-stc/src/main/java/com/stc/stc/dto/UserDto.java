package com.stc.stc.dto;

public class UserDto {
		private Long id;
	    private String userName;
	    private String fullName;
		private boolean isMale;
		private String email;
		private String password;
		private String tel;
		private String role;
	    private boolean enabled;
	    
	    
	    
		public UserDto() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public boolean isMale() {
			return isMale;
		}
		public void setMale(boolean isMale) {
			this.isMale = isMale;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
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
