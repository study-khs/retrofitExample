package com.asuscomm.yangyinetwork.retrofit_ex01;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jaeyoung on 2017. 3. 18..
 */

public class MessageDto<T> implements Serializable {
    @SerializedName("page")
    private int page;
    @SerializedName("size")
    private int size;
    @SerializedName("hasNext")
    private boolean hasNext;
    @SerializedName("content")
    private List<T> content;

    public MessageDto(int page, int size, boolean hasNext, List<T> content) {
        this.page = page;
        this.size = size;
        this.hasNext = hasNext;
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}