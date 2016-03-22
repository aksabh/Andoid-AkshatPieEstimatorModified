package com.example.akshatsharma.akshatpieestimatormodified;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by akshatsharma on 2/20/15.
 */
public class MyFragment extends Fragment {


    static interface TaskCallbacks {
        void onPreExecute();

        void onProgressUpdate(int percent);

        void onCancelled();

        void onPostExecute();
    }
    private TaskCallbacks mCallbacks;
    private MainActivity.MyAppThread mTask;
    String st;

    public void onAttach(String activity) {
       // super.onAttach(activity);
        //mCallbacks = (TaskCallbacks) activity;
    st=activity;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retain this fragment across configuration changes.
        setRetainInstance(true);
        MainActivity ob=new MainActivity();
        String st=ob.str2;
        // Create and execute the background task.
        //   mTask = new EstimatePI();
        mTask.onPostExecute(st);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

}
