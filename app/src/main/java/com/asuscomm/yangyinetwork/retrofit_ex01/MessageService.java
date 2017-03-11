package com.asuscomm.yangyinetwork.retrofit_ex01;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by jaeyoung on 2017. 3. 4..
 */

public interface MessageService {
    @GET("api/message/{message_id}")
    Call<Message> getMessage(@Path("message_id") String id);

    @POST("api/message")
    Call<Message> postMessage(
            @Body Message message
    );

    @DELETE("api/message/{message_id}")
    Call<Void> deleteRecord(@Path("message_id") String id);
}

