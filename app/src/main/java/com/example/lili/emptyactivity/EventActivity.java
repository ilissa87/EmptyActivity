package com.example.lili.emptyactivity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.util.Log;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
     Button btn1;
     Button  btn2;
     Button btn3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        btn1=(Button)findViewById(R.id.Boutton1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        RelativeLayout p = (RelativeLayout)findViewById(R.id.RL);
        Log.d("Click1", "Valeur = " +btn1.getText().toString());
        Log.d("Click2", "Valeur = " +btn2.getText().toString());
        Log.d("Click3", "Valeur = "+ btn3.getText().toString());
        btn1.setOnClickListener(this);
        p.setOnTouchListener(new View.OnTouchListener() {

                                 @Override
                                 public boolean onTouch(View v, MotionEvent event) {
                                 System.out.println("Evenement sur x = "+event.getX()+ "Evenement sur y = "+event.getY());
                                     return true;
                                 }
                             }
        );

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // ici v <=> butoon 2
                // this != EventActivity
                Toast.makeText(v.getContext(), "Click2",Toast.LENGTH_SHORT ).show();
            }
        });





    }

    public void onClickB4(View v){
        Toast.makeText(this, "Click3", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(v.getContext(), "Click1", Toast.LENGTH_SHORT).show();
    }
}
