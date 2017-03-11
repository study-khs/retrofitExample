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
        post("2","second test");
    }

    private void init() {
        ddDefaultRestClient = new DefaultRestClient<>();
        mMessageService = ddDefaultRestClient.getClient(MessageService.class);
    }

//    private void get(String id) {
//
//        Call<Message> call = mMessageService.getMessage("1");
//        call.enqueue(new Callback<Message>() {
//            @Override
//            public void onResponse(Call<Message> call, Response<Message> response) {
//                if (response.isSuccessful()) {
//                    Log.d("jyp", "success");
//                    Message test = response.body();
//                    Log.d("jyp", test.getMessage());
//                } else {
//                    Log.d("jyp", "fail");
//                    Log.d("jyp", response.errorBody().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Message> call, Throwable t) {
//                Log.d("jyp", "fail2");
//                t.printStackTrace();
//            }
//        });
//
//        Log.d("jyp", "init");
//    }
  private void post(String id,String message) {

        Call<Message> call = mMessageService.postMessage(new Message(id, message));
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "success");
                    Message test = response.body();
                    Log.d("jyp", test.getMessage());
                } else {
                    Log.d("jyp", "fail");
                    Log.d("jyp", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("jyp", "fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp", "init");
    }



    private void send(){
        Log.d("jyp","send");
    }
}
