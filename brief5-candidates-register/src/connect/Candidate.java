package connect;

import java.util.Objects;

public class Candidate {
	
	private int id;
	private String email;
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String country;
	private String created_at;
	private String updated_at;
	
	public static String tableName = "candidates";

	
	public Candidate() {
		
	}
	
	
	public Candidate( String email, String first_name, String last_name, String address, String city, String country) {
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.country = country;

	}

	public Candidate(int id, String email, String first_name, String last_name, String address, String city,
			String country, String created_at, String updated_at) {
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.created_at = created_at;
		this.updated_at = updated_at;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String toString() {
		return "Candidate [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", address=" + address + ", city=" + city + ", country=" + country + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}



//	@Override
//	public int hashCode() {
//		return Objects.hash(address, city, country, created_at, email, first_name, id, last_name, updated_at);
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Candidate other = (Candidate) obj;
//		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
//				&& Objects.equals(country, other.country) && Objects.equals(created_at, other.created_at)
//				&& Objects.equals(email, other.email) && Objects.equals(first_name, other.first_name) && id == other.id
//				&& Objects.equals(last_name, other.last_name) && Objects.equals(updated_at, other.updated_at);
//	}

}
