package com.example.yopido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainMenuLoggeado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_loggeado);
        Button btnReservar;
        Button btnAnularReserva;
        Button btnVerMisReservas;
        btnReservar = (Button) findViewById(R.id.btnEntrar);
        btnReservar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.MainActivityLayaut), R.string.msg_Aun_NO_TOLAIIIIIIIII,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }));
        btnAnularReserva = (Button) findViewById(R.id.btnRegistro);
        btnAnularReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.MainActivityLayaut), R.string.msg_Aun_NO_TOLAIIIIIIIII,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }));
        btnVerMisReservas = (Button) findViewById(R.id.btnPideYa);
        btnVerMisReservas.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.MainActivityLayaut), R.string.msg_Aun_NO_TOLAIIIIIIIII,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }));
    }
}