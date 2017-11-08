package com.example.lili.emptyactivity.Album;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lili.emptyactivity.R;


public class ThreadsActivity extends AppCompatActivity {

    private TextView txtStatus;
    private ProgressBar progress;
    private Button btnGo;
    private EditText numbre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);

        txtStatus = (TextView) findViewById(R.id.txtStatus);
        progress = (ProgressBar) findViewById(R.id.progressBarCircle);
        btnGo = (Button) findViewById(R.id.btnGo);
        numbre = (EditText) findViewById(R.id.numbre);

        btnGo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progress.setVisibility(View.VISIBLE);
                String UserString = numbre.getText().toString();
                new SumAsyncTask().execute(Integer.parseInt(UserString));

                numbre.setText("");
            }
        });

    }

    //entree, progress, result
    public class SumAsyncTask extends AsyncTask<Integer, Float, Integer> {
        private static final String TAG = "Test";
        //private String UserString = numbre.getText().toString();
        //private int UserNumbre = Integer.parseInt(UserString);

        @Override
        protected void onPreExecute() { // UI Thread
            super.onPreExecute();
            txtStatus.setText("Loading");
            
          //  progress.setProgress(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(Integer... params) { // Exécuté dans un autre thread
            // params [1, 2, 3, 4]
            int result=0;
            /*
            for( int i = 0; i < params.length;  i++ ){
                result += params[i];
                publishProgress((float)i/params.length);
                */
                result = fibonacci(params[0]);

                publishProgress((float) 1.0);
                return result;


        }

        @Override
        protected void onProgressUpdate(Float... values) { // Exécuté dans le UIThread
            super.onProgressUpdate(values);
            Log.i(TAG, "Progress " + values[0]);
            progress.setProgress(Math.round(values[0] * 100));
        }

        @Override
        protected void onPostExecute(Integer s) { // Exécuté dans le UIThread
            Log.i(TAG, "Result " + s);
            txtStatus.setText("Finish, result = " + s);
            progress.setVisibility(View.INVISIBLE);
        }

        public int fibonacci(int n) {
            if (n <= 1) return n;
            else return fibonacci(n - 1) + fibonacci(n - 2);

        }


    }


}
