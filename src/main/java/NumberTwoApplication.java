import com.google.gson.Gson;
import http.clients.TodoClient;
import http.models.two.TodoModel;
import http.services.TodoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    }
}
