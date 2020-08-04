package http.models.one;

import com.google.gson.annotations.SerializedName;



public class UserIdModel {
    @SerializedName("ad")
    private Ad ad;

    @SerializedName("data")
    private Data data;

    public Ad getAd(){
        return ad;
    }

    public Data getData(){
        return data;
    }
}
