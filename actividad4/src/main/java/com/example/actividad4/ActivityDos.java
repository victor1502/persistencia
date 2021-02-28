package com.example.actividad4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityDos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        TextView textoNombre = findViewById(R.id.textNombre2);
        TextView textoFecha = findViewById(R.id.textFecha2);
        TextView textoSexo = findViewById(R.id.textSexo2);
        textoNombre.setText(pref.getString("nombre","vacio"));
        textoFecha.setText(pref.getString("fecha", "vacio"));
        textoSexo.setText(pref.getString("sexo","vacio"));
    }

    public void clickCorrecto(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("dato", "Datos Correctos");
        startActivity(intent);
    }

    public void clickIncorrecto(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("dato", "Datos Incorrectos");
        startActivity(intent);
    }
}