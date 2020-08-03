package http.models;

import com.google.gson.annotations.SerializedName;

public class UserModel{

	@SerializedName("ad")
	private Ad ad;

	@SerializedName("data")
	private Data data;

}