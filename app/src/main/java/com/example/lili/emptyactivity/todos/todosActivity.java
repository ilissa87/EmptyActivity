package com.example.lili.emptyactivity.todos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lili.emptyactivity.R;
import com.example.lili.emptyactivity.todos.models.TodoAdapter;
import com.example.lili.emptyactivity.todos.models.todos;

import java.util.ArrayList;

public class todosActivity extends AppCompatActivity {
   ArrayList<todos>mlist;
   private  Button btnCreeTodos;
   private  EditText userText;
    private TodoAdapter adapter;
    private EditText txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos2);
        mlist=new ArrayList<todos>();
        btnCreeTodos=(Button)findViewById(R.id.btnCreeTodos);

       btnCreeTodos.setOnClickListener(clickSubmit);

        mlist.add(new todos("acheter des Tomates", "en Kilo"));
        mlist.add(new todos("acheter des Tomates", "en Kilo"));
        mlist.add(new todos("acheter des Tomates", "en Kilo"));
        mlist.add(new todos("acheter des Tomates", "en Kilo"));
        mlist.add(new todos("acheter des Tomates", "en Kilo"));
        /*
        Methode1
        un adaptateur fourni par l'android
        adapter=new ArrayAdapter<todos>(this, android.R.layout.simple_list_item_1, mlist);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        */
        /*
        //Methode 2
        adapter=new ArrayAdapter<todos>(this, R.layout.userlayout,R.id.txttitle, mlist);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
     */
        //Methode3
        adapter= new  TodoAdapter(mlist, this);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    private View.OnClickListener clickSubmit=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userText = (EditText) findViewById(R.id.userText);
            txtDesc = (EditText) findViewById((R.id.txtDesc));

            String creeString = userText.getText().toString();
            String s = txtDesc.getText().toString();
            if (creeString.equals("") || s.equals("")) {
                return;
            } else {
                adapter.add(new todos(creeString, s));
                userText.setText("");
                txtDesc.setText("");

            }
        }

    };




}

