package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;

public class MainReservaDirecta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_directa);
        Button buttonReservaDirectaAceptar;
        Button buttonReservaDirectaCancelar;


        buttonReservaDirectaAceptar = (Button) findViewById(R.id.buttonReservaDirectaAceptar);
        buttonReservaDirectaAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla de entrar en la app cuando el usuario está registrado
            }
        }));
        buttonReservaDirectaCancelar = (Button) findViewById(R.id.buttonReservaDirectaCancelar);
        buttonReservaDirectaCancelar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a registrarse
            }
        }));

    }
}