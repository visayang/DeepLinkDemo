package com.example.deeplinktest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class DeepLinkActivity extends AppCompatActivity {
    TextView tv_data;

    String scheme;
    String host;
    List<String> params;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv_data = (TextView) findViewById(R.id.tv_data);
        getDataFromBrowser();
    }

    /**
     * 从deep link中获取数据
     */
    private void getDataFromBrowser() {
        Uri uri = getIntent().getData();
        if(uri!=null){
            try {
                scheme = uri.getScheme(); // "will"
                host = uri.getHost(); // "share"
//                params = uri.getPathSegments();
//                String testId = params.get(0); // "uuid"

                String action = uri.getQueryParameter("action");

                String result = URLEncodeing.toURLDecoder(action);

                tv_data.setText(result);
//                tv_data.setText("Scheme: " + scheme + "\n" + "host: " + host /*+ "\n" + "params: " + testId*/+ "\n" + "action: " + action);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
