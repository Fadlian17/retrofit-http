import com.google.gson.Gson;
import http.clients.JsonClient;
import http.models.three.PostModel;
import http.models.three.UserModel;
import http.services.JsonService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class NumberThreeApplication {
    public static void main(String[] args) {
        JsonClient.json(
                JsonService.class,
                "http://jsonplaceholder.typicode.com/")
                .getPosts()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<List<PostModel>> call,
                                           Response<List<PostModel>> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PostModel>> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        JsonClient.json(
                JsonService.class,
                "http://jsonplaceholder.typicode.com/")
                .getUsers()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<List<UserModel>> call,
                                           Response<List<UserModel>> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserModel>> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
    }
}
