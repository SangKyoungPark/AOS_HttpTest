package com.example.httptest;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

// api/users 응답 데이터
public class ResUsersData {

    @Expose
    int page;
    @Expose
    @SerializedName("per_page")
    int perPage;
    @Expose
    int total;
    @Expose
    @SerializedName("total_pages")
    int totalPages;
    @Expose
    List<Data> data;
    @Expose
    Ad ad;


    public class Data {
        int id;
        String email;
        @SerializedName("first_name")
        String firstName;
        @SerializedName("last_name")
        String lastName;
        String avatar;

        @NonNull
        @Override
        public String toString() {
            return "{id=" + id + " , email=" + email + " , firstName=" + firstName + " , lastName=" + lastName + " , avatar}";
        }
    }

    public class Ad {
        String company;
        String url;
        String text;

        @NonNull
        @Override
        public String toString() {
            return "{company=" + company + " , url=" + url + " , text=" + text + "}";
        }
    }

    @Override
    public String toString() {
        String str = "[ResUsersData] page=" + page + " , perPage=" + perPage + " , total=" + total + " , totalPages=" + totalPages + " , data= [";
        for( int i=0; i<data.size(); i++ ) {
            str = str.toString() + data.get(i).toString();
            if( i < data.size()-1 ) {
                str += ",";
            }
        }
        str = str.toString() + "]";
        //str = str.toString() + " , ad=" + ad.toString();

        return str.toString();
    }
}