package http.models.one;

import com.google.gson.annotations.SerializedName;

public class PostUserModel{

    @SerializedName("createdAt")
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("job")
    private String job;

    @Override
    public String toString(){
        return
                "{" +
                        " \"createdAt\" = '\"" + createdAt + '\"' +
                        ", \"name\" = '\"" + name + '\"' +
                        ", \"id\" = '\"" + id + '\"' +
                        ", \"job\" = '\"" + job + '\"' +
                        "}";
    }
}