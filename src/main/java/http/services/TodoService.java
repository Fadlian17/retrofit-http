package http.services;

//model

import  http.models.two.TodoModel;
import http.models.two.DataItem;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface TodoService {


    //all
    @GET("api/v1/todos")
    Call<TodoModel> getTodo();

    //single
    @GET("api/v1/todos/{id}")
    Call<TodoModel> getTodoId(@Path("id") int id);

    //post user
    @FormUrlEncoded
    @POST("todos")
    Call<ResponseBody> postTodo(@Field("task") String task);

    @FormUrlEncoded
    @PUT("todos/{id}")
    Call<TodoModel> updateTodo(@Path("id") int id, @Field("task") String task, @Field("status") String status);

    @FormUrlEncoded
    @PATCH("todos/{id}")
    Call<TodoModel> patchTodo(@Path("id") int id, @Field("task") String task, @Field("status") String status);

    @DELETE("todos/{id}")
    Call<TodoModel> deleteTodo(@Path("id") int id);
}
