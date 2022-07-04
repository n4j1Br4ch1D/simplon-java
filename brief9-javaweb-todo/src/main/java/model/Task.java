package model;

import java.util.Objects;

public class Task {
	public static String tableName = "tasks";

	private Integer id;
	private String name;
	private String description;
	private String status;
	private String tobefinished_at;
	private String finished_at;
	private String category;
	private Integer category_id;
	private String created_at;
	private String updated_at;
	
	public Task() {
	}

	public Task(String name, String description, String status, String tobefinished_at, String finished_at,
			String category, Integer category_id) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.tobefinished_at = tobefinished_at;
		this.finished_at = finished_at;
		this.category = category;
		this.category_id = category_id;
	}

	public Task(Integer id, String name, String description, String status, String tobefinished_at, String finished_at,
			String category, Integer category_id, String created_at, String updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.tobefinished_at = tobefinished_at;
		this.finished_at = finished_at;
		this.category = category;
		this.category_id = category_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		Task.tableName = tableName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTobefinished_at() {
		return tobefinished_at;
	}

	public void setTobefinished_at(String tobefinished_at) {
		this.tobefinished_at = tobefinished_at;
	}

	public String getFinished_at() {
		return finished_at;
	}

	public void setFinished_at(String finished_at) {
		this.finished_at = finished_at;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
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
		return Objects.hash(category, category_id, created_at, description, finished_at, id, name, status,
				tobefinished_at, updated_at);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(category, other.category) && Objects.equals(category_id, other.category_id)
				&& Objects.equals(created_at, other.created_at) && Objects.equals(description, other.description)
				&& Objects.equals(finished_at, other.finished_at) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(status, other.status)
				&& Objects.equals(tobefinished_at, other.tobefinished_at)
				&& Objects.equals(updated_at, other.updated_at);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", tobefinished_at=" + tobefinished_at + ", finished_at=" + finished_at + ", category=" + category
				+ ", category_id=" + category_id + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	


}
