package com.example.ivanradosavljevic.doubledouble;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import util.Post;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    String restUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textview);
        restUrl = "http://www.doubledouble.rs/json-page/";
        new Parser().execute(restUrl);
    }

    private class Parser extends AsyncTask<String, List<Post>, List<Post> > {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {

            progressDialog.setTitle("Please wait");
            progressDialog.show();
        }

        @Override
        protected List<Post> doInBackground(String... strings) {
            List<Post> jsonList = null;
            StringBuilder sb = new StringBuilder();
            String text = "";
            try {
                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((text = in.readLine()) != null) {
                   sb.append(text);
                }
                jsonList = GsonParser.getInstance().getFromJson(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jsonList;
        }

        @Override
        protected void onPostExecute(List<Post> posts) {
            //tv.setText(Html.fromHtml(posts));
            progressDialog.dismiss();
        }
    }
}
