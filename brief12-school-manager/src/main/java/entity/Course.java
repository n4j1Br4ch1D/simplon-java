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
@Table(name = "courses")
@XmlRootElement
public class Course {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "active")
	private boolean active;


    @JoinColumn(name="trainer_id", nullable = true, columnDefinition = "integer")
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	private User trainer;
    

	@JoinColumn(name = "course_id", nullable = true, columnDefinition = "integer")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<User> talents;

	public Course() {
		super();
	}

	public Course(String name, boolean active, User trainer) {
		super();
		this.name = name;
		this.active = active;
		this.trainer = trainer;
//		this.talents = talents;
	}

	public Course(Integer id, String name, boolean active, User trainer) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.trainer = trainer;
//		this.talents = talents;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	public Collection<User> getTalents() {
		return talents;
	}

	public void setTalents(Collection<User> talents) {
		this.talents = talents;
	}

//	@Override
//	public String toString() {
//		return "Course [id=" + id + ", name=" + name + ", active=" + active + ", trainer=" + trainer + ", talents=" + talents + "]";
//	}
}
