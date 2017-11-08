package com.example.lili.emptyactivity.Http_Activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lili.emptyactivity.R;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class httpActivity extends AppCompatActivity {
   private EditText UserURL;
    private Button btnGo;
    private TextView txtAfficher;
    private Button btnImage;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        UserURL=(EditText) findViewById(R.id.UserURL);
        btnGo=(Button)findViewById(R.id.btnGo);
        txtAfficher=(TextView)findViewById(R.id.txtAfficher) ;
        btnImage=(Button)findViewById(R.id.btnImage);
        img=(ImageView)findViewById(R.id.img);
        btnGo.setOnClickListener(c);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAfficher.setText("");
                Picasso.with(v.getContext()).invalidate("https://picsum.photos/200/300/?random");
                Picasso.with(v.getContext()).load("https://picsum.photos/200/300/?random").into(img);
            }
        });



    }
    private View.OnClickListener c = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String ValURL= UserURL.getText().toString();

                 new SumAsyncTask().execute(ValURL);
            }
        };
    public class SumAsyncTask extends AsyncTask<String,Void , String> {

        @Override
        protected String doInBackground(String... params) {
            StringBuilder result=null;
            String path=params[0];
            HttpURLConnection connection=null;
            URL url=null;

            try {
                url=new URL(path);
                connection=(HttpURLConnection)url.openConnection();
                //connection.setRequestProperty("accepte");
                connection.setRequestMethod("GET");
                connection.connect();
                int codeResuest=connection.getResponseCode();
                result=new StringBuilder();
                Log.d("CODE", ""+codeResuest);
                if(codeResuest>=200 && codeResuest<300){
                    String ligne=null;
                    InputStreamReader sr=new InputStreamReader(connection.getInputStream());
                    BufferedReader br=new BufferedReader(sr);

                    ligne=br.readLine();
                    while( ligne!=null){
                        result.append(ligne);
                        ligne=br.readLine();
                    }
                    br.close();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(connection !=null) {
                    connection.disconnect();
                }
            }
            if(result==null){
                return "";
            }
            return result.toString() ;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtAfficher.setText(s);
        }
    }
    }



