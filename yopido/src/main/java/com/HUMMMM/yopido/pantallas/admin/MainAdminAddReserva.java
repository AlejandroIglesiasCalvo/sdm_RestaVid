package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainAdminAddReserva extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_reserva);

        final EditText nombre = (EditText) findViewById(R.id.editTextTextNombre);
        final EditText telf = (EditText) findViewById(R.id.editTextPhone);
        // --- activity_admin_add_reserva
        Button btnAñadirReserva;

        btnAñadirReserva = (Button) findViewById(R.id.button_Aceptar_Reserva_Admin);


        btnAñadirReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((String.valueOf(nombre.getText()).length() == 0)
                        || (String.valueOf(telf.getText()).length() == 0)) {
                    Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.error_admin_addReserva, Snackbar.LENGTH_SHORT).show();
                }
                // Se añade usuario nuevo y la reserva, en caso de no existir en la BDD.
                else
                // Se añade la reserva al usuario si existe el usuario en la BDD.
                {
                    cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                }
            }
        }));



    }
}
