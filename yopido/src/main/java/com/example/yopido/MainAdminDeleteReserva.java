package com.example.yopido;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainAdminDeleteReserva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_reserva);

        // --- activity_admin_delete_reserva
        Button btnAceptarEliminarReserva;
        Button btnCancelarEliminarReserva;
        btnAceptarEliminarReserva = (Button) findViewById(R.id.buttonAceptar_EliminarReserva_Admin);
        btnCancelarEliminarReserva = (Button) findViewById(R.id.buttonCancelar_EliminarReserva_Admin);

        btnAceptarEliminarReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se elimina reserva y se regresa al panel principal del admin

                // Se añade la reserva al usuario si existe el usuario en la BDD.
            }
        }));

        btnCancelarEliminarReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se vuelve a la pantalla principal del admin.
            }
        }));
    }
}
