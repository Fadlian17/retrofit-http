import com.google.gson.Gson;
import http.clients.UserClient;

import http.models.one.PostUserModel;
import http.models.one.UserModel;
import http.services.UserService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NumberOneApplication {
    public static void main(String[] args) {

        //get all user
        UserClient.client(
                UserService.class,
                "https://reqres.in/api/")
                .getUser()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        System.out.println("---GET All USER---");
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }


                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        //get user by id
        UserClient.client(
                UserService.class,
                "https://reqres.in/api/")
                .getUserId(2)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        System.out.println("---GET USER BY ID---");
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }


                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        System.out.println("---Post Data User---");
        // post data
        PostUserModel add = new PostUserModel();
        add.setName("Fadlian");
        add.setJob("leader");
        UserClient.client(
                UserService.class,
                "https://reqres.in/api/")
                .addUser(add)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<PostUserModel> call,
                                           Response<PostUserModel> response) {
                        System.out.println("Body Add User");
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostUserModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });





    }
}