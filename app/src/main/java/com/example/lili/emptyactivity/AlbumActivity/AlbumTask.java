package com.example.lili.emptyactivity.AlbumActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lili on 07/11/2017.
 */

public class AlbumTask extends AsyncTask<String,Void , String> {
    AlbumAdapter adapter;
    private static final String TAG = "AlbumTask";
    private Context context;


    public AlbumTask(AlbumAdapter adapter) {
        this.adapter = adapter;
    }

    public AlbumTask(AlbumAdapter adapter, Context context) {
        this.adapter = adapter;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {


        StringBuilder result = null;
        String path = params[0];
        HttpURLConnection connection = null;
        URL url = null;

        try {
            url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestProperty("accepte");
            connection.setRequestMethod("GET");
            connection.connect();
            int codeResuest = connection.getResponseCode();
            result = new StringBuilder();
            Log.d("CODE", "" + codeResuest);
            if (codeResuest >= 200 && codeResuest < 300) {
                String ligne = null;
                InputStreamReader sr = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(sr);

                ligne = br.readLine();
                while (ligne != null) {
                    result.append(ligne);
                    ligne = br.readLine();
                }
                br.close();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        if (result == null) {
            return "";
        }

        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result == null || result.isEmpty()) {
            Log.d(TAG, "Result  is empty...");
            return;
        }
        try {
            Type listType = new TypeToken<ArrayList<Album>>() {}.getType();
            List<Album> list = new Gson().fromJson(result, listType);
            adapter.getAlbums().addAll(list);
            adapter.notifyDataSetChanged();
        }catch(Exception e){
            System.out.println("e " + e);   }



        }
    }

