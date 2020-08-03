package http.services;

//model
import http.models.UserModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;


public interface UserService {
//    //list
//    @GET("api/users/{id}")
//    Call<List<UserModel> getUser(@Path("id") int id);

    //single
    @GET("api/users/{id}")
    Call<UserModel> getUser(@Path("id") int id);
}
