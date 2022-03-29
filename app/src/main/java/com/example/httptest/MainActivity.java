package com.example.httptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    ApiInterface api;

    // ui
    Button btnGet;
    Button btnPost;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGet = (Button)findViewById( R.id.btnGet );
        btnGet.setOnClickListener( this::onClick);
        btnPost = (Button)findViewById( R.id.btnPost );
        btnPost.setOnClickListener( this::onClick);
        txtResult = (TextView)findViewById( R.id.txtResult );

        api = HttpClient.getRetrofit().create( ApiInterface.class );
    }

    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.btnPost:
                txtResult.setText("");
                requestPost();
                break;

            case R.id.btnGet:
                txtResult.setText("");
                requestGet();
                break;
        }
    }

    // POST 통신요청
    public void requestPost() {
        ReqLoginData reqLoginData = new ReqLoginData( "eve.holt@reqres.in" , "cityslicka" );
        Call<ResLoginData> call = api.requestPostLogin( reqLoginData );

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<ResLoginData>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<ResLoginData> call, Response<ResLoginData> response) {
                txtResult.setText( response.body().toString() );    // body() - API 결과값을 객체에 맵핑
            }

            @Override
            public void onFailure(Call<ResLoginData> call, Throwable t) {
                txtResult.setText( "onFailure" );
            }
        } );
    }

    // GET 통신요청
    public void requestGet() {
        Call<ResUsersData> call = api.requestGetUsersDetail( "2" );

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue(new Callback<ResUsersData>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<ResUsersData> call, Response<ResUsersData> response) {
                txtResult.setText( response.body().toString() );
            }

            // 통신실패
            @Override
            public void onFailure(Call<ResUsersData> call, Throwable t) {
                txtResult.setText( "onFailure" );
            }
        });
    }
}
