package com.example.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yopido.R;

public class MainRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button btnRegistroAceptar;
        Button btnRegistroCancelar;

        btnRegistroAceptar = (Button) findViewById(R.id.buttonRegistroAceptar);
        btnRegistroAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla de entrar en la app cuando el usuario está registrado
            }
        }));

        btnRegistroCancelar = (Button) findViewById(R.id.buttonRegistroCancelar);
        btnRegistroCancelar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a registrarse
            }
        }));

    }
}