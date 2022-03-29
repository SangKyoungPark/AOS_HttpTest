package com.example.httptest;
// api/login 요청 데이터
public class ReqLoginData {

    String email;
    String password;

    public ReqLoginData( String email, String password ) {
        this.email = email;
        this.password = password;
    }
}