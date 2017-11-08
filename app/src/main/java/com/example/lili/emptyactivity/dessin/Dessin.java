package com.example.lili.emptyactivity.dessin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;


import com.example.lili.emptyactivity.R;

import java.util.ArrayList;

public class Dessin extends AppCompatActivity {
    Frome[] frome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this,frome));


    }
    public static void main(String[]args) {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(1, 5);
        Point p3 = new Point(5, 8);
        Point p4 = new Point(0, 7);
        Cercle c1 = new Cercle(3, 2, 5);
        Segment s = new Segment(p1, p2);
        Segment s1 = new Segment(p3, p4);
        Frome[] frome = new Frome[4];
        frome[0]=c1;
        frome[1]=s;
        frome[2]=new Cercle(p2, 4);
        frome[3]=new Cercle(s1);



        //for(Frome f: forme){
        //System.out.println(f.centre());
        //f.afficher();
        //}
    }
}


