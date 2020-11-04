package com.example.yopido;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Actions_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_reserva);

        // --- activity_admin_add_reserva
        Button btnAñadirReserva;
        Button btnCancelarReserva;
        btnAñadirReserva = (Button) findViewById(R.id.button_Aceptar_Reserva_Admin);
        btnCancelarReserva = (Button) findViewById(R.id.buttonCancelar_Reserva_Admin);

        // --- activity_admin_delete_reserva
        Button btnAceptarEliminarReserva;
        Button btnCancelarEliminarReserva;
        btnAceptarEliminarReserva = (Button) findViewById(R.id.buttonAceptar_EliminarReserva_Admin);
        btnCancelarEliminarReserva = (Button) findViewById(R.id.buttonCancelar_ EliminarReserva_Admin);

        // --- activity_admin_add_user
        Button btnAñadirUser;
        Button btnCancelarAñadirUser;
        btnAñadirUser = (Button) findViewById(R.id.buttonAceptar_AñadirUser_Admin);
        btnCancelarAñadirUser = (Button) findViewById(R.id.buttonCancelar_AñadirUser_Admin);

        // --- activity_admin_delete_user
        Button btnAceptarEliminarUser;
        Button btnCancelarEliminarUser;
        btnAceptarEliminarUser = (Button) findViewById(R.id.buttonAceptar_EliminarUser_Admin);
        btnCancelarEliminarUser = (Button) findViewById(R.id.buttonCancelar_ EliminarUser_Admin);


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




        btnAñadirUser.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se comprueba que todos los campos estén bien y se añade a la BDD.

                // Se regresa a la pantalla principal del admin
            }
        }));

        btnCancelarAñadirUser.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se vuelve a la pantalla principal del admin.
            }
        }));




        btnAceptarEliminarUser.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se comprueba que todos los campos estén bien y se elimina a la BDD en caso de existir.
                // Si no eiste, se muestra mensaje de que nanai.

                // Se regresa a la pantalla principal del admin
            }
        }));

        btnCancelarEliminarUser.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se vuelve a la pantalla principal del admin.
            }
        }));
    }
}
