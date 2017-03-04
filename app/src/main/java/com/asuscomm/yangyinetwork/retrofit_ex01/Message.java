package com.asuscomm.yangyinetwork.retrofit_ex01;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jaeyoung on 2017. 3. 4..
 */

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements Serializable {
    @SerializedName("response")
    private String response;
    @SerializedName("message")
    private String message;
    @SerializedName("id")
    private String id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
    }
}
