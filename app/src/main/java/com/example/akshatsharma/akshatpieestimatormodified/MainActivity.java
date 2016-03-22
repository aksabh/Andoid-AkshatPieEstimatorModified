package com.example.akshatsharma.akshatpieestimatormodified;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements MyFragment.TaskCallbacks {
    EditText cycles;
    static TextView eachEstimate,finalEstimate;
    int c,u=0;
    static String str="",str2="";
    Button gen;
   static double[] a;
    private static final String TAG_TASK_FRAGMENT = "task_fragment";
    private MyFragment mTaskFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();

        mTaskFragment = (MyFragment) fm.findFragmentByTag(TAG_TASK_FRAGMENT);

       if (mTaskFragment == null) {
           // add the fragment
           mTaskFragment = new MyFragment();
           //fm.beginTransaction().add(mTaskFragment, “ ”).commit();
           // load the data from the web
           mTaskFragment.onAttach(str2);
       }
        cycles=(EditText)findViewById(R.id.editText);
        eachEstimate=(TextView)findViewById(R.id.textView4);
        finalEstimate=(TextView)findViewById(R.id.textView6);
        gen = (Button)findViewById(R.id.button);


        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((cycles.getText()+"")=="")
                    Toast.makeText(getApplicationContext(), "Please Enter the value for cycles", Toast.LENGTH_LONG).show();
                else
                    c=Integer.parseInt(cycles.getText()+"");
                MyAppThread obj[]=new MyAppThread[c];
                for(int i = 0; i < c; i++) {
                    obj[i]=new MyAppThread();
                    obj[i].execute(cycles.getText() + "",String.valueOf(i));
                }

            }

        });

    }

    public void onClear(View view){
        c=0;
        str="";
        str2="";
        eachEstimate.setText("");
        finalEstimate.setText("");
        cycles.setText("");
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onProgressUpdate(int percent) {

    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onPostExecute() {

    }


    public static class MyAppThread extends AsyncTask<String, Void, String> {

        public int points=1000;
        private int radius=1;
        int r;
        private int cycles;
        public double[] myThreadArray;


        @Override
        protected String doInBackground(String... params) {
            cycles=Integer.parseInt(params[0]);
            r=Integer.parseInt(params[1]);
            double myEstimation=0;
            boolean[] myCount=null;
            points=1000;
            myThreadArray = new double[cycles];
                    int h = 0;
                    for (double a : myThreadArray) {
                        myCount = putPoints(radius, points);
                        myEstimation = myEstimator(myCount, points);
                        myThreadArray[h] = myEstimation;
                        h++;
                    }
                    a=myThreadArray;
            try {


                    str =  "Cycle Number " + (r + 1) + " :   " + a[r] + "\n";
                str2=str2+str;
                    Thread.sleep(2000);





                } catch (InterruptedException e) {
                    Thread.interrupted();
                }


            return str;
        }

        @Override
        protected void onPostExecute(String result) {
            eachEstimate.setText(str2);
           // str="      "+a[myThreadArray.length-1]+"";
           // finalEstimate.setText(str);

                finalEstimate.setText("   "+a[r]);
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}

        public static boolean [] putPoints(int r, int d){
            double xCoord=0;
            double yCoord=0;
            boolean [] myArray2 = new boolean[d];
            for(int i = 0; i < d; i++){
                xCoord = Math.random() * r;
                yCoord = Math.random() * r;
                if(((xCoord*xCoord) + (yCoord*yCoord)) <= 1){
                    myArray2[i] = true;
                }
                else{
                    myArray2 [i] = false;
                }
            }
            return myArray2;
        }

        public static double myEstimator(boolean [] h, int d){
            int myCounter = 0;
            for(int i = 0; i < h.length; i++){
                if(h[i] == true){
                    myCounter++;
                }
            }
            return 4 * ((double)myCounter / d);
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
