package com.example.lili.emptyactivity.AlbumActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.net.URL;


import com.example.lili.emptyactivity.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lili on 07/11/2017.
 */

public class AlbumAdapter extends BaseAdapter{
    private ArrayList<Album> album;
    Context context;

    public AlbumAdapter(ArrayList album, Context context) {
        this.album = album;
        this.context = context;
    }

    @Override
    public int getCount() {
        return album.size();
    }

    @Override
    public Object getItem(int position) {
        return album.get(position);
    }
    public ArrayList<Album> getAlbums(){
        return this.album;

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout=null;
       if(linearLayout !=null){
           linearLayout=(LinearLayout)convertView;
       }else{
           linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.album_raw, parent, false);
       }
         Album currentsAlbum = (Album)getItem(position);
        TextView textViewURL = (TextView) linearLayout.findViewById(R.id.idURL);
        TextView textViewTitre = (TextView) linearLayout.findViewById(R.id.idTITRE);
        ImageView imgPicasso=(ImageView) linearLayout.findViewById(R.id.imgPicasso);
        textViewURL.setText(currentsAlbum.getUrl());
        textViewTitre.setText(currentsAlbum.getTitre());
        //Picasso.with(context).invalidate("https://picsum.photos/200/300/?random");
        Picasso.with(context).load(currentsAlbum.getThumbnailUrl()).into(imgPicasso);


        return linearLayout;
    }
}
