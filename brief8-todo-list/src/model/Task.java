package model;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {
	public static String tableName = "tasks";

	private Integer id;
	private SimpleStringProperty name;
	private SimpleStringProperty description;
	private SimpleStringProperty status;
	private SimpleStringProperty tobefinished_at;
	private SimpleStringProperty finished_at;
	private SimpleStringProperty category;
	private SimpleIntegerProperty category_id;
	private SimpleStringProperty created_at;
	private SimpleStringProperty updated_at;
	
	
	
	public Task() {
//        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
		this.description = new SimpleStringProperty();
		this.status = new SimpleStringProperty();
		this.tobefinished_at = new SimpleStringProperty();
		this.finished_at = new SimpleStringProperty();
		this.category_id = new SimpleIntegerProperty();
		this.category = new SimpleStringProperty();
		this.created_at = new SimpleStringProperty();
		this.updated_at = new SimpleStringProperty();
	}
	
	public Task(String name, String description,
			String status, String tobefinished_at, String finished_at,
			Integer category_id) {
//        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description);
		this.status = new SimpleStringProperty(status);
		this.tobefinished_at = new SimpleStringProperty(tobefinished_at);
		this.finished_at = new SimpleStringProperty(finished_at);
		this.category_id = new SimpleIntegerProperty(category_id);
		this.category = new SimpleStringProperty();
		this.created_at = new SimpleStringProperty();
		this.updated_at = new SimpleStringProperty();
	}
	
	public Task(Integer id, String name, String description,
			String status, String tobefinished_at, String finished_at,
			Integer category_id, String created_at, String updated_at) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description);
		this.status = new SimpleStringProperty(status);
		this.tobefinished_at = new SimpleStringProperty(tobefinished_at);
		this.finished_at = new SimpleStringProperty(finished_at);
		this.category_id = new SimpleIntegerProperty(category_id);
		this.category = new SimpleStringProperty();
		this.created_at = new SimpleStringProperty(created_at);
		this.updated_at = new SimpleStringProperty(updated_at);
	}
	
	

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		Task.tableName = tableName;
	}

    public IntegerProperty idProperty() {
      return new SimpleIntegerProperty(this.id);
    }

	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	      this.id = id;
	}

    public StringProperty nameProperty() {
        return name;
      }

  	public String getName() {
  	    return name.get();
  	}

  	public void setName(String name) {
  	      this.name.set(name);
  	}
  	
    public StringProperty descriptionProperty() {
        return description;
      }

  	public String getDescription() {
  	    return description.get();
  	}

  	public void setDescription(String description) {
  	      this.description.set(description);
  	}

    public StringProperty statusProperty() {
        return status;
    }

  	public String getStatus() {
  	    return status.get();
  	}

  	public void setStatus(String status) {
  	      this.status.set(status);
  	}
  	
    public StringProperty tobefinished_atProperty() {
        return tobefinished_at;
    }


	public String getTobefinished_at() {
  	    return tobefinished_at.get();

	}

	public void setTobefinished_at(String tobefinished_at) {
	      this.tobefinished_at.set(tobefinished_at);
	}
	
    public StringProperty finished_atProperty() {
        return finished_at;
    }

	public String getFinished_at() {
  	    return tobefinished_at.get();
	}

	public void setFinished_at(String finished_at) {
	      this.finished_at.set(finished_at);
	}
  	
    public IntegerProperty Category_idProperty() {
        return category_id;
      }

  	public Integer getCategory_id() {
  	    return category_id.get();
  	}

  	public void setCategory_id(Integer category_id) {
  	      this.category_id.set(category_id);
  	}

    public StringProperty categoryProperty() {
        return category;
    }

  	public String getCategory() {
  	    return category.get();
  	}

  	public void setCategory(String category) {
  	      this.category.set(category);
  	}
  	
    public StringProperty created_atProperty() {
        return created_at;
    }

	public String getCreated_at() {
  	    return created_at.get();
	}

	public void setCreated_at(String created_at) {
	      this.created_at.set(created_at);
	}
	
    public StringProperty updated_atProperty() {
        return updated_at;
    }

	public String getUpdated_at() {
  	    return updated_at.get();
	}

	public void setUpdated_at(String updated_at) {
	      this.updated_at.set(updated_at);
	
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
