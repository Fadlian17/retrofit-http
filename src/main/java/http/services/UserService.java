package http.services;

//model
import http.models.UserModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PATCH;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

import java.util.List;


public interface UserService {
    @GET("api/users/{id}")
    Call<List<UserModel>> getUser(@Path("id") int id);
}
