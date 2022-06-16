package model;

import java.util.Objects;

import javafx.beans.property.StringProperty;

public class Product0 {
	public static String tableName = "products";

	private Integer id;
	private String name;
	private String img;
	private String description;
	private float price;
	private String unit;
	private String city;
	private String category;
	private int category_id;
	private String created_at;
	private String updated_at;
	
	
	public Product0() {
	}

	public Product0(String name, String img, String description, float price, String unit, String city,
			int category_id) {
		this.name = name;
		this.img = img;
		this.description = description;
		this.price = price;
		this.unit = unit;
		this.city = city;
		this.category_id = category_id;
	}

	public Product0(int id, String name, String img, String description, float price, String unit, String city,
			int category_id, String created_at, String updated_at) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.description = description;
		this.price = price;
		this.unit = unit;
		this.city = city;
		this.category_id = category_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		Product0.tableName = tableName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

//    public StringProperty firstNameProperty() {
//      return name;
//    }
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
		return Objects.hash(category, category_id, city, created_at, description, id, img, name, price, unit,
				updated_at);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product0 other = (Product0) obj;
		return Objects.equals(category, other.category) && category_id == other.category_id
				&& Objects.equals(city, other.city) && Objects.equals(created_at, other.created_at)
				&& Objects.equals(description, other.description) && id == other.id && Objects.equals(img, other.img)
				&& Objects.equals(name, other.name) && Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(unit, other.unit) && Objects.equals(updated_at, other.updated_at);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", img=" + img + ", description=" + description + ", price="
				+ price + ", unit=" + unit + ", city=" + city + ", category=" + category + ", category_id="
				+ category_id + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}


	
}
