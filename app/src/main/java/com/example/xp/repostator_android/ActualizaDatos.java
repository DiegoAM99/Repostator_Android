package com.example.xp.repostator_android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

public class ActualizaDatos extends Activity {
    //variable que guarda la fila que ha pulsado el usuario
    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_repostaje);
    }

    //lee los datos desde el SharedPreferences
    private void leeDatos (int indice){
        EditText editPrecio = (EditText) findViewById(R.id.precio);
        EditText editKilometros = (EditText) findViewById(R.id.kilometros);
        EditText editLitros = (EditText) findViewById(R.id.litros);
        DatePicker editFecha = (DatePicker) findViewById(R.id.fecha);

        SharedPreferences sp = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String precio = sp.getString("precio_" + indice, null);
        String kilometros = sp.getString("kilometros_" + indice, null);
        String litros = sp.getString("litros_" + indice, null);
        int dia = sp.getInt("dia_" + indice, 0);
        int mes = sp.getInt("mes_" + indice, 0);
        int anyo = sp.getInt("anyo_" + indice, 0);

        editPrecio.setText(precio);
        editKilometros.setText(kilometros);
        editLitros.setText(litros);
        editFecha.updateDate(anyo, mes, dia);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle parametros = getIntent().getExtras();
        if(parametros != null){
            posicion = parametros.getInt("posicion");
            posicion++;
            leeDatos(posicion);
        }
    }
}
