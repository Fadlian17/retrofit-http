import com.google.gson.Gson;
import http.clients.UserClient;

import http.models.UserModel;
import http.services.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        UserClient.client(
                UserService.class,
                "https://reqres.in/api/users/")
                .getUser(2)
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