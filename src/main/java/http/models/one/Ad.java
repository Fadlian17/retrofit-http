package http.models.one;

import com.google.gson.annotations.SerializedName;

public class Ad{

	@SerializedName("company")
	private String company;

	@SerializedName("text")
	private String text;

	@SerializedName("url")
	private String url;
}