import com.google.gson.Gson;
import http.clients.UserClient;

import http.models.one.UserModel;
import http.services.UserService;
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

//        System.out.println("---Post Data User---");
//        // post dataa
//        PostUserModel post = new PostUserModel();
//        post.setName("Fadli");
//        post.setJob("Developer");
//        UserClient.client(UserService.class, "https://reqres.in/")
//                .postUser(post);
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        if (response.code() >= 200 & response.code() < 300){
//                            System.out.println(new Gson().toJson(response.body()));
//                        }else {
//                            System.out.println("Error response code " + response.errorBody());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        System.out.println(t.getMessage());
//                    }
//                });

    }
}