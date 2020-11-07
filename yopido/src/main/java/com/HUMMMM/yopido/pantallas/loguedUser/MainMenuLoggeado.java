package com.HUMMMM.yopido.pantallas.loguedUser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;

public class MainMenuLoggeado extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_loggeado);
        Button btnReservar;
        Button btnAnularReserva;
        Button btnVerMisReservas;
        btnReservar = (Button) findViewById(R.id.btnReservar);
        btnReservar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), ReservarLogueado.class);
            }
        }));
        btnAnularReserva = (Button) findViewById(R.id.btnAnularReserva);
        btnAnularReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla de anular reservas
            }
        }));
        btnVerMisReservas = (Button) findViewById(R.id.btnVerReservas);
        btnVerMisReservas.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla de ver reservas
            }
        }));
    }
}