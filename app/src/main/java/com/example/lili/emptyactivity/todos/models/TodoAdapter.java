package com.example.lili.emptyactivity.todos.models;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.lili.emptyactivity.R;

import java.util.ArrayList;



/**
 * Created by lili on 03/11/2017.
 */

public class TodoAdapter extends BaseAdapter {
    private ArrayList<todos> items;
    Context context;
    private int nb=0;


    public TodoAdapter(ArrayList<todos> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override

    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add(todos todo){
        items.add(todo);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearlayout = null;
        if (convertView != null) {
            linearlayout = (LinearLayout) convertView;
        } else {
            linearlayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.userlayout, parent, false);

        }
        final todos currentsTodos = (todos) getItem(position);
        //On recupere les deux TextView de notre template (userlayout-xml)
        TextView textViewTitre = (TextView) linearlayout.findViewById(R.id.txttitle);
        final TextView textViewDescription = (TextView) linearlayout.findViewById(R.id.txtDescription);
        CheckBox state=(CheckBox) linearlayout.findViewById(R.id.chekBox);
        Button btnDelete=(Button)linearlayout.findViewById(R.id.btnDelete);
        textViewTitre.setText(currentsTodos.getNom());

        textViewDescription.setText(currentsTodos.getDescription());
        textViewTitre.setTextColor(currentsTodos.getColor());
        state.setChecked(currentsTodos.isActive());
        state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              //  System.out.println(isChecked);
                LinearLayout l=(LinearLayout)buttonView.getParent();
                if(isChecked==true){
                    currentsTodos.setEtat(todos.Etat.Active);
                    l.setAlpha(1f);
                    textViewDescription.setTextColor(Color.RED);

                }else{
                    currentsTodos.setCompleted();
                    l.setAlpha(0.5f);
            }

            }
        });
        //il faut faire un button pour supprimer
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(currentsTodos);
            }
        });



        return linearlayout;
    }
}


