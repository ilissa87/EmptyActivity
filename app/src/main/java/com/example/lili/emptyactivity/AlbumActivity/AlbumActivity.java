package com.example.lili.emptyactivity.AlbumActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lili.emptyactivity.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {
    private ArrayList<Album>mlist;
    AlbumAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        mlist=new ArrayList<Album>();
           /*
            String URL1="www.google.com";
            String URL2="www.google.com";
            mlist.add(new Album(URL1,"tt" ));
            mlist.add(new Album(URL2, "ff"));
            */
            adapter= new AlbumAdapter(mlist, this);
            ListView listView=(ListView)findViewById(R.id.listView);
            listView.setAdapter(adapter);
            AlbumTask albumTask=new AlbumTask(adapter,this);
            albumTask.execute("https://jsonplaceholder.typicode.com/photos");





    }
}
