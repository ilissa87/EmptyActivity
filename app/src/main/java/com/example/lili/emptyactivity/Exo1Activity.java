package com.example.lili.emptyactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class Exo1Activity extends AppCompatActivity {
      private String tag="debug";
    private int compteur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo1);
        System.out.println(" onCreate ");
        if(savedInstanceState !=  null){
            compteur = compteur = (int) savedInstanceState.get("key");
            Toast.makeText(this, "Valeur récurérer " + compteur , Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(" onStart  ");
        Log.d(tag, "onStart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(" onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }
     /*
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(tag, "onSaveInstanceState");
        compteur++;
        savedInstanceState.putInt("key", compteur);


    }

}
