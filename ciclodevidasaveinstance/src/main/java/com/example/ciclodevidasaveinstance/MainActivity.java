package com.example.ciclodevidasaveinstance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG","onCreate(" + savedInstanceState + ")");
        final Button btn = (Button) findViewById(R.id.button);
        final int[] pulsaciones = {0};

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pulsaciones[0]++;

                Log.i("Contador", "Contador aumentado en 1");
                Log.i("Cuenta",""+pulsaciones[0]);
            }
        });
    }

    protected void onSaveInstanceState(Bundle outInstance) {
        super.onSaveInstanceState(outInstance); Log.i("TAG", "onSaveInstanceState");
    }
}
