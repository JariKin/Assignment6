package com.example.assignment6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/*
En keksinyt toimivia ratkaisuja useiden tuntien tiedon etsimisen
jälkeen.
Liian paljon asiaa kerralla imo tässä tehtävässä
 */

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1Listener, Fragment2.Fragment2Listener {
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_1, fragment1)
                .commit();


    }


    @Override
    public void onInput1Sent(CharSequence input) {
        //ei varmaan toimisi tällä ratkaisulla mitä netistä etsin, että on molemmille
        //napeille täällä fragment listeneri(?)

        if(isNetworkAvailable()) {
            //täällä vain jotain kokeilua
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            requestQueue.add();
        }
        else{
            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onInput2Sent(CharSequence input) {

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
