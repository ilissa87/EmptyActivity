package com.example.lili.emptyactivity.findTheNumber.Game.java;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lili.emptyactivity.R;

import static java.lang.Integer.parseInt;

public class FindTheNumber extends AppCompatActivity  {
    EditText saisirNumber;


    TextView massageAfficher;
    Button btnClick;
    TextView TxtHistorique;
    ProgressBar prograsseBar;
    private int score;
    private int numMax=8;

    private int findValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_find_the_number);
        saisirNumber=(EditText)findViewById(R.id.SaisirNumber);
        massageAfficher=(TextView)findViewById(R.id.messageAfficher);
        btnClick=(Button)findViewById(R.id.btnClick);
        prograsseBar=(ProgressBar)findViewById(R.id.progressBar);
        TxtHistorique=(TextView)findViewById(R.id.txHistorique);

        btnClick.setOnClickListener(ClickSubmit);
        iniGame();
    }
     private void iniGame(){
         //il recupere le string qui est dans la classe mere
         Intent i=getIntent();
         String s=i.getStringExtra("Bonjour");
         System.out.println(s);
        massageAfficher.setText("");
         //il affiche le message dans l'application
        TxtHistorique.setText("Bonjour "+ s);
        score=0;
        saisirNumber.setText("");
        prograsseBar.setProgress(0);
         findValue=1+(int)(Math.random()*99);
    }
    private View.OnClickListener ClickSubmit=new  View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String UserText = saisirNumber.getText().toString();
        /*
           if(saisirNumber.getText().toString().equals("")){
               massageAfficher.setText("Saisir Un Numbre");
               return;

            }
            */
            int userValue;
            try {
                userValue = Integer.parseInt(UserText);
            } catch (NumberFormatException e) {
                Log.e("Error", e.getMessage());
                massageAfficher.setText("Saisir Un Numbre");
               // Victory();
                return;
            }
            prograsseBar.incrementProgressBy(1);
            score++;
            TxtHistorique.setText(UserText+ " \n" +TxtHistorique.getText().toString());
            if (score > numMax) {
                massageAfficher.setText(" Vous avez Perdu");
                return;
            }
            if (userValue == findValue) {
                Victory();
                return;//sortir de la methode OnClick
            }
            if (userValue < findValue) {
                    massageAfficher.setText("Trop petit");
                } else {
                    massageAfficher.setText("Trop Gros");
                }
               saisirNumber.setText("");
            }
    };
        private void Victory(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.alertMssageWin) ;
            builder.setTitle(R.string.alertTitreWin);
// Add the buttons
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
       public void onClick(DialogInterface dialog, int id) {
           restratGame();
       }
        });

            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
           // User cancelled the dialog
              endGame();
           }
            });

            AlertDialog dialog=builder.create();
            dialog.show();

        }

        private void restratGame(){
            iniGame();
        }
        private void endGame(){
           Intent i =new Intent();
            
            finish();
        }










    }



