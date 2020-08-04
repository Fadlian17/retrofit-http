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
}