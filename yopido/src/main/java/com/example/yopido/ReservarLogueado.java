package com.example.yopido;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReservarLogueado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_logueado);

        Button btnAceptar;
        Button btnCancelar;

        btnAceptar = (Button) findViewById(R.id.buttonAceptar);
        btnAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para reservar
                // Asignar datos de la reserva al usuario ya existente
            }
        }));
        btnCancelar = (Button) findViewById(R.id.buttonCancelar);
        btnCancelar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla anterior: activity_main
            }
        }));
    }

}
