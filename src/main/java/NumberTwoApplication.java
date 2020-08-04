import com.google.gson.Gson;
import http.clients.TodoClient;
import http.clients.UserClient;
import http.models.two.TodoModel;
import http.services.TodoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.FileOutputStream;

public class NumberTwoApplication {
    public static void main(String[] args) {

        //all
        TodoClient.todos(
                TodoService.class,
                "http://online-course-todo.herokuapp.com/")
                .getTodo()
                .enqueue(new Callback<>() {
                    public void onResponse(Call<TodoModel> call,
                                           Response<TodoModel> response) {
                        System.out.println("---GET All USER---");
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<TodoModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        //id
        TodoClient.todos(
                TodoService.class,
                "http://online-course-todo.herokuapp.com/")
                .getTodoId(19)
                .enqueue(new Callback<>() {
                    public void onResponse(Call<TodoModel> call,
                                           Response<TodoModel> response) {
                        System.out.println("---GET USER ID---");
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<TodoModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        //post
//        TodoClient.todos(
//                TodoService.class,
//                "https://online-course-todo.herokuapp.com/")
//                .getTodos()
//                .enqueue(new Callback<>() {
//                    @Override
//                    public void onResponse(Call<TodoModel> call,
//                                           Response<TodoModel> response) {
//                        System.out.println("Get All Todos");
//                        if (response.code() >= 200 & response.code() <= 299) {
//                            System.out.println(new Gson().toJson(response.body()));
//                            try {
//                                var file = new FileOutputStream("src/main/java/http/output/file.json");
//                                file.write(new Gson().toJson(response.body()).getBytes());
//                                file.flush();
//                                file.close();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            System.out.println("Maaf response gagal dengan kode " +
//                                    response.code());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<TodoModel> call, Throwable t) {
//                        System.out.println(t.getMessage());
//                    }
//                });
    }
}
