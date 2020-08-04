package http.services;

import http.models.three.PostModel;
import http.models.three.UserModel;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface JsonService {
    @GET("posts")
    Call<List<PostModel>> getPosts();

    @GET("users")
    Call<List<UserModel>> getUsers();
}
