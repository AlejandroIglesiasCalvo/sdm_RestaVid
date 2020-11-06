package com.example.yopido.pantallas.NotLoguedUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yopido.R;

public class ReservaSinLoggear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_directa);

        Button btnReservar;
        Button btnCancelar;

        btnReservar = (Button) findViewById(R.id.buttonAceptar);
        btnReservar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para reservar
                // Meter datos del nuevo usuari y la reserva.
            }
        }));
        btnCancelar = (Button) findViewById(R.id.buttonCancelar);
        btnCancelar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla anterior (Menu principal)
            }
        }));
    }

}
