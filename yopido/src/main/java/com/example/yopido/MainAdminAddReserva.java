package com.example.yopido;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainAdminAddReserva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_reserva);

        // --- activity_admin_add_reserva
        Button btnAñadirReserva;
        Button btnCancelarReserva;
        btnAñadirReserva = (Button) findViewById(R.id.button_Aceptar_Reserva_Admin);
        btnCancelarReserva = (Button) findViewById(R.id.buttonCancelar_Reserva_Admin);

        btnAñadirReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se añade usuario nuevo y la reserva, en caso de no existir en la BDD.

                // Se añade la reserva al usuario si existe el usuario en la BDD.
            }
        }));

        btnCancelarReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se vuelve a la pantalla principal del admin.
            }
        }));

    }
}
