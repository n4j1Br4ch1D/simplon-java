package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "users")
@XmlRootElement
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "role")
	private String role;

	@Column(name = "approved")
	private boolean approved;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@JoinColumn(name = "course_id", nullable = true, columnDefinition = "integer")
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	private Course course;

	@JoinColumn(name = "trainer_id", nullable = true, columnDefinition = "integer")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Course> courses;

	// Dates;

	public User() {
		super();
	}

	public User(String fullName, String role, boolean approved, String email, String password) {
		super();
		this.fullName = fullName;
		this.role = role;
		this.approved = approved;
		this.email = email;
		this.password = password;
	}

	public User(Integer id, String fullName, String role, boolean approved, String email, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.role = role;
		this.approved = approved;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", fullName=" + fullName + ", role=" + role + ", approved=" + approved + ", email="
//				+ email + ", password=" + password + ", course=" + course + ", courses=" + getCourses() + "]";
//	}



}