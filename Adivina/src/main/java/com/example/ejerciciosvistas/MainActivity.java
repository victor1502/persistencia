package com.example.ejerciciosvistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int solucion = 71;
        Button btn =(Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textoSolucion = (TextView) findViewById(R.id.textView);
                EditText numero = (EditText) findViewById(R.id.cajaNumero);
                int guess = Integer.parseInt(numero.getText().toString());
                if (guess == solucion){
                    textoSolucion.setVisibility(View.VISIBLE);
                    textoSolucion.setText("Felicidades has acertado el número");
                }
                else if(guess < solucion){
                    textoSolucion.setVisibility(View.VISIBLE);
                    textoSolucion.setText("El número introducido es menor que el que se busca");
                }
                else{
                    textoSolucion.setVisibility(View.VISIBLE);
                    textoSolucion.setText("El número introducido es mayor que el que se busca");
                }
            }
        });
    }
}