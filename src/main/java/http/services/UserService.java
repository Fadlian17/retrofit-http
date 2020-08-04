package http.services;

//model

import http.models.one.PostUserModel;
import http.models.one.UpdateUserModel;
import http.models.one.UserIdModel;
import http.models.one.UserModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;


public interface UserService {

    //all
    @GET("users")
    Call<UserModel> getUser();


    //single
    @GET("users/{id}")
    Call<UserIdModel> getUserId(@Path("id") int id);

    //post user
    @Headers({"Content-type: application/json"})
    @POST("users")
    Call<PostUserModel> PostUser(@Body PostUserModel post);


    @Headers({"Content-type: application/json"})
    @PUT("users/{id}")
    Call<UpdateUserModel> updateUser(@Path("id") int id, @Body UpdateUserModel update);

    @FormUrlEncoded
    @PATCH("users/{id}")
    Call<UserModel> patchUser(@Path("id") int id, @Field("name") String name, @Field("job") String job);

    @DELETE("users/{id}")
    Call<UserModel> deleteUser(@Path("id") int id);

}
