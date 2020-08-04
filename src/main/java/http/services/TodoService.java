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
    @Headers({"Content-type: application/json"})
    @POST("api/v1/todos")
    Call<DataItem> addTodo(@Body DataItem add);


    @Headers({"Content-type: application/json"})
    @PUT("api/v1/todos/{id}")
    Call<DataItem> updateTodo(@Path("id") int id, @Body DataItem update);

    @DELETE("api/v1/todos/{id}")
    Call<TodoModel> deleteTodo(@Path("id") int id);
}
