package com.asuscomm.yangyinetwork.retrofit_ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    DefaultRestClient<MessageService> ddDefaultRestClient;
    MessageService mMessageService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        //get("1");
        post("1","sungsik is pool?");
        //delete("1");
    }

    private void init(){
        ddDefaultRestClient = new DefaultRestClient<>();
        mMessageService = ddDefaultRestClient.getClient(MessageService.class);

        Log.d("jyp","init");
    }

    Message mMessage;
    private void get(String id){
        Call<Message> call = mMessageService.getMessage(id);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "get success");
                    mMessage = response.body();
                    Log.d("jyp", mMessage.getMessage());
                } else {
                    Log.d("jyp", "get fail");
                    Log.d("jyp", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("jyp", "get fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp","get");
    }

    private void post(String id, String message){
        Call<Message> call = mMessageService.postMessage(new Message(id, message));
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "post success");
                    mMessage = response.body();
                    Log.d("jyp", mMessage.getMessage());
                } else {
                    Log.d("jyp", "post fail");
                    Log.d("jyp", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("jyp", "post fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp","post");
    }

    private void delete(String id){
        Call<Void> call = mMessageService.deleteRecord(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "delete success");
                    Log.d("jyp", response.toString());
                } else {
                    Log.d("jyp", "delete fail");
                    Log.d("jyp", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("jyp", "delete fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp","delete");
    }
}
