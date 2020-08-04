package http.models.one;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("id")
	private int id;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;
}