package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;

public class MainActivityAdmin extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");
        Button btnAddUsuario;
        Button btnEliminarUsuario;
        Button btnAddReserva;
        Button btnEliminarReserva;

        btnAddUsuario = (Button) findViewById(R.id.btnAñadirUsuarios);
        btnEliminarUsuario = (Button) findViewById(R.id.btnEliminarUsuarios);
        btnAddReserva = (Button) findViewById(R.id.btnAñadirReservas);
        btnEliminarReserva = (Button) findViewById(R.id.btnEliminarReservas);

        btnAddUsuario.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a pantalla para añadir usuarios
                cambiarDeClase.MoverA(v.getContext(), MainAdminAddUser.class);
            }
        }));

        btnEliminarUsuario.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a pantalla para eliminar usuarios
                cambiarDeClase.MoverA(v.getContext(), MainAdminDeleteUser.class);
            }
        }));

        btnAddReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a pantalla para añadir reservas
                cambiarDeClase.MoverA(v.getContext(), MainAdminAddReserva.class);
            }
        }));

        btnEliminarReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a pantalla para eliminar reservas
                cambiarDeClase.MoverA(v.getContext(), MainAdminDeleteReserva.class);
            }
        }));

    }
}