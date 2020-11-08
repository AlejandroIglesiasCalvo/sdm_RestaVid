package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;

public class MainAdminAddReserva extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_reserva);

        // --- activity_admin_add_reserva
        Button btnAñadirReserva;

        btnAñadirReserva = (Button) findViewById(R.id.button_Aceptar_Reserva_Admin);


        btnAñadirReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se añade usuario nuevo y la reserva, en caso de no existir en la BDD.

                // Se añade la reserva al usuario si existe el usuario en la BDD.
                cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
            }
        }));



    }
}
