package com.example.omarali.thecookbook.util;

import com.example.omarali.thecookbook.model.Comment;
import com.example.omarali.thecookbook.model.Recipe;
import com.example.omarali.thecookbook.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by omarali on 12/14/15.
 */
public interface PublicApiRoutes {

    @GET("/recipes")
    void getRecipes(Callback<List<Recipe>> callback);

    @GET("/recipes/{recipe_id}")
    void getRecipe(@Path("recipe_id") int recipe_id, Callback<Recipe> callback);

    @GET("/recipes/{recipe_id}/comments")
    void getRecipeComments(@Path("recipe_id") int recipe_id, Callback<List<Comment>> callback);

    @GET("/users/{user_id}/friends")
    void getFriendships(@Path("user_id") int user_id, Callback<List<User>> callback);

    @GET("/users/{user_id}/timeline")
    void getTimeLine(@Path("user_id") int user_id, Callback<List<Recipe>> callback);

    @GET("/users/{user_id}/posts")
    void getUserPost(@Path("user_id") int user_id, Callback<List<Recipe>> callback);

    @GET("/users/{user_id}/friend_requests")
    void getFriendRequests(@Path("user_id") int user_id, Callback<List<User>> callback);

    @GET("/users/{user_id}/pending_friends")
    void getPendingFriends(@Path("user_id") int user_id, Callback<List<User>> callback);

    @GET("/users/{user_id}")
    void getUserProfile(@Path("user_id") int user_id, Callback<User> callback);

    @POST("/recipes/{recipe_id}/comment")
    @FormUrlEncoded
    void setRecipeComment(@Path("recipe_id") int recipe_id, @Field("comment[body]") String body ,Callback<Comment> callback);

    @POST("/sessions")
    @FormUrlEncoded
    void setUser(@Field("session[username]") String username, @Field("session[token]") String token, Callback<User> callback);


}
