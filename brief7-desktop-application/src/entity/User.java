package entity;

import java.util.Objects;

public class User {
	
	public static String tableName = "users";

	private int id;
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	private boolean approved;
	private String created_at; // date
	private String updated_at; // date
	
	public User() {
	}
	
	public User(String email, String password, String first_name, String last_name, boolean approved) {
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.approved = approved;
	}
	
	public User(int id, String email, String password, String first_name, String last_name, boolean approved,
			String created_at, String updated_at) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.approved = approved;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		User.tableName = tableName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public int hashCode() {
		return Objects.hash(approved, created_at, email, first_name, id, last_name, password, updated_at);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return approved == other.approved && Objects.equals(created_at, other.created_at)
				&& Objects.equals(email, other.email) && Objects.equals(first_name, other.first_name) && id == other.id
				&& Objects.equals(last_name, other.last_name) && Objects.equals(password, other.password)
				&& Objects.equals(updated_at, other.updated_at);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", approved=" + approved + "]";
	}
	
}
	
	

