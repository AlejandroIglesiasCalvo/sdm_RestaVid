package com.HUMMMM.yopido.pantallas.loguedUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;

public class MainMenuLoggeado extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_loggeado);
        Button btnReservar;
        Button btnAnularReserva;
        Button btnVerMisReservas;
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");
        btnReservar = (Button) findViewById(R.id.btnReservar);
        btnReservar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), ReservarLogueado.class,correo, telefono);
            }
        }));
        btnAnularReserva = (Button) findViewById(R.id.btnAnularReserva);
        btnAnularReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla de anular reservas
                cambiarDeClase.MoverA(v.getContext(), UserDeleteReserva.class);
            }
        }));
        btnVerMisReservas = (Button) findViewById(R.id.btnVerReservas);
        btnVerMisReservas.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla de ver reservas
                cambiarDeClase.MoverA(v.getContext(), UserViewReserva.class, correo, telefono);
            }
        }));
    }
}