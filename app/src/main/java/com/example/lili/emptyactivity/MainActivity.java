package com.example.lili.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lili.emptyactivity.findTheNumber.Game.java.FindTheNumber;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGoEvent;
    Button btnGoExo1;
    Button btnGoFindTheNumber;
    EditText EntreNom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoExo1 = (Button) findViewById(R.id.btnGoExo1);
        EntreNom=(EditText)findViewById(R.id.EntreNom);
        btnGoFindTheNumber = (Button) findViewById(R.id.btnGoFindTheNumber);

        btnGoExo1.setOnClickListener(submite2);
        btnGoFindTheNumber.setOnClickListener(submite3);
    }


    private View.OnClickListener submite2 = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            Intent i= new Intent(v.getContext(), Exo1Activity.class);
            startActivity(i);

        }
    };
    private View.OnClickListener submite3 = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            Intent i= new Intent(v.getContext(), FindTheNumber.class);
            i.putExtra("Bonjour", EntreNom.getText().toString());
            startActivityForResult(i, 99);

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("Result", "Retour");
    }

    @Override
    public void onClick(View v) {

    }
}


