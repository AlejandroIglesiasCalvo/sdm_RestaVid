package com.example.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yopido.R;

public class MainIniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        Button btnIniciarSesionAceptar;
        Button btnIniciarSesionCancelar;

        btnIniciarSesionAceptar = (Button) findViewById(R.id.buttonIniciarSesionAceptar);
        btnIniciarSesionAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla de entrar en la app cuando el usuario está registrado
            }
        }));

        btnIniciarSesionCancelar = (Button) findViewById(R.id.buttonIniciarSesionCancelar);
        btnIniciarSesionCancelar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a registrarse
            }
        }));

    }
}