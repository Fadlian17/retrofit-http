package http.models.two;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TodoModel{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;
}