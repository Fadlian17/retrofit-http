package http.models.two;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("task")
	private String task;

	@SerializedName("id")
	private int id;

	@SerializedName("status")
	private boolean status;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setId(int id) {
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getTask(){
		return task;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}