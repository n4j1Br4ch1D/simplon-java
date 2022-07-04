package model;

import java.util.Objects;

public class Category {
	public static String tableName = "categories";

	private Integer id;
	private String name;
	private String img;
	private String created_at;
	private String updated_at;
	public Category() {
	}
	public Category(String name, String img) {
		this.name = name;
		this.img = img;
	}
	public Category(int id, String name, String img, String created_at, String updated_at) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public static String getTableName() {
		return tableName;
	}
	public static void setTableName(String tableName) {
		Category.tableName = tableName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		return Objects.hash(created_at, id, img, name, updated_at);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(created_at, other.created_at) && id == other.id && Objects.equals(img, other.img)
				&& Objects.equals(name, other.name) && Objects.equals(updated_at, other.updated_at);
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", img=" + img + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}

}
