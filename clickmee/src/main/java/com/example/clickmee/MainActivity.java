package com.example.clickmee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final static String STATE_NUM_VECES = "numVeces";
    final int[] pulsaciones = {0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = (Button) findViewById(R.id.button);
        if(savedInstanceState != null){
            pulsaciones[0] = savedInstanceState.getInt(STATE_NUM_VECES);
            if(pulsaciones[0] != 0){
                btn.setText(getEtiquetaBoton());
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pulsaciones[0]++;
                btn.setText(""+pulsaciones[0]);

                Log.i("Contador", "Contador aumentado en 1");
                Log.i("Cuenta", ""+pulsaciones[0]);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outSate) {
        super.onSaveInstanceState(outSate);
        outSate.putInt(STATE_NUM_VECES,pulsaciones[0]);
    }

    private String getEtiquetaBoton(){
        Resources res = getResources();
        String numPulsados;
        numPulsados = null; //res.getQuantityString(R.plurals.numPulsaciones,pulsaciones[0]);
        return numPulsados;
    }
}
