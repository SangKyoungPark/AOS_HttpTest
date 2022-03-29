package com.example.httptest;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;

// api/login 응답 데이터
public class ResLoginData {

    @Expose
    String token;

    @NonNull
    @Override
    public String toString() {
        return "[ResLoginData] token=" + token;
    }
}