import com.google.gson.Gson;
import http.clients.TodoClient;
import http.clients.UserClient;
import http.models.one.UserModel;
import http.models.two.DataItem;
import http.models.two.TodoModel;
import http.services.TodoService;
import http.services.UserService;
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
                            try {
                                var file = new FileOutputStream("src/main/java/http/output/file.json");
                                file.write(new Gson().toJson(response.body()).getBytes());
                                file.flush();
                                System.out.println("Write File Successfully");
                                file.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
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
        DataItem add = new DataItem();
        add.setTask("Develop Mobile Apps");
        add.setStatus(true);
        TodoClient.todos(
                TodoService.class,
                "https://online-course-todo.herokuapp.com/")
                .addTodo(add)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<DataItem> call,
                                           Response<DataItem> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println("Body Add Todo : "+new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<DataItem> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        //update

        DataItem updateTodo = new DataItem();
        updateTodo.setTask("Develop Mobile Apps");
        updateTodo.setStatus(true);
        TodoClient.todos(
                TodoService.class,
                "https://online-course-todo.herokuapp.com/")
                .updateTodo(27,updateTodo)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<DataItem> call,
                                           Response<DataItem> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println("---Update Todo BY ID---"+new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<DataItem> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });


        //delete
        var idTodo = 2;
        TodoClient.todos(
                TodoService.class,
                "http://online-course-todo.herokuapp.com/")
                .getTodo()
                .enqueue(new Callback<>() {
                    public void onResponse(Call<TodoModel> call,
                                           Response<TodoModel> response) {
                        System.out.println("---GET All USER---");
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println("user dengan id "+idTodo+"telah terhapus");
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


    }
}
