package com.example.actividad4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    EditText textoNombre;
    EditText EdittextFecha;
    int dia, mes, año, mayor;
    String textoFecha;
    String[] cachosFecha;
    Calendar fechaTextbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String datos = getIntent().getStringExtra("dato");
        Toast.makeText(MainActivity.this, datos, Toast.LENGTH_LONG).show();

        Calendar fecha = Calendar.getInstance();
        fecha.add(Calendar.YEAR, -18);
        textoNombre = findViewById(R.id.editTextTextPersonName);
        EdittextFecha = findViewById(R.id.editTextDate);
        CheckBox check = findViewById(R.id.checkBoxMayor);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    textoFecha = ""+EdittextFecha.getText();
                    cachosFecha = textoFecha.split("/");
                    for(int i=0;i<cachosFecha.length;i++){
                        Log.i("cachos",cachosFecha[i]);
                    }
                    dia = Integer.valueOf(cachosFecha[0]);
                    mes = Integer.valueOf(cachosFecha[1])-1;
                    año = Integer.valueOf(cachosFecha[2]);
                    fechaTextbox = new GregorianCalendar(año,mes,dia);
                    mayor = fecha.compareTo(fechaTextbox);
                    if(mayor == -1){
                        Toast.makeText(MainActivity.this, "No eres mayor de edad", Toast.LENGTH_SHORT).show();
                        check.setChecked(false);
                    }
                }
            }
        });
    }

    public void buttonClick(View view) {
        RadioGroup rg = findViewById(R.id.radioGroup);
        int radioButtonID = rg.getCheckedRadioButtonId();
        View radioButton = rg.findViewById(radioButtonID);
        int index = rg.indexOfChild(radioButton);
        RadioButton radio = (RadioButton) rg.getChildAt(index);

        SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("nombre",""+textoNombre.getText());
        editor.putString("fecha", ""+fechaTextbox.toString());
        editor.putString("radio", ""+radio.getText());
        editor.commit();

        Intent intent = new Intent(getApplicationContext(), ActivityDos.class);
        startActivity(intent);
    }


}