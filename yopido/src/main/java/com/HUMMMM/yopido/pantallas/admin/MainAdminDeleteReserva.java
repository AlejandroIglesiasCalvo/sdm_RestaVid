package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;

public class MainAdminDeleteReserva extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_reserva);

        // --- activity_admin_delete_reserva
        Button btnAceptarEliminarReserva;
        btnAceptarEliminarReserva = (Button) findViewById(R.id.btnFin);

        btnAceptarEliminarReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se elimina reserva y se regresa al panel principal del admin

                // Se añade la reserva al usuario si existe el usuario en la BDD.
                cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
            }
        }));
    }
}
