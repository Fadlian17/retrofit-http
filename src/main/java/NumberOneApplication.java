import com.google.gson.Gson;
import http.clients.UserClient;

import http.models.one.PostUserModel;
import http.models.one.UpdateUserModel;
import http.models.one.UserIdModel;
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
                        System.out.println("---GET All USER---\n");
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
                    public void onResponse(Call<UserIdModel> call, Response<UserIdModel> response) {
                        System.out.println("---GET USER BY ID---\n");
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }


                    @Override
                    public void onFailure(Call<UserIdModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        // post data
        PostUserModel post = new PostUserModel();
        post.setName("Fadlian");
        post.setJob("leader");
        PostUserModel add = new PostUserModel();
        UserClient.client(
                UserService.class,
                "https://reqres.in/api/")
                .PostUser(add)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<PostUserModel> call,
                                           Response<PostUserModel> response) {
                        System.out.println("---Post User---\n");
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


        //update users

        UpdateUserModel update = new UpdateUserModel();
        update.setName("Fadlian Alfansyah");
        update.setJob("Developer Android");
        UserClient.client(
                UserService.class,
                "https://reqres.in/api/")
                .updateUser(1,update)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<UpdateUserModel> call,
                                           Response<UpdateUserModel> response) {
                        System.out.println("---Update USER BY ID---");
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateUserModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        //delete users
        var idUser = 1;
        UserClient.client(
                UserService.class,
                "https://reqres.in/api/")
                .deleteUser(idUser)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        System.out.println("---Delete USER BY ID---\n");
                        if (response.code() >= 200 & response.code() <= 299) {
//                            System.out.println(new Gson().toJson(response.body()));
                            System.out.println("user dengan id "+idUser+"telah terhapus");
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

    }
}