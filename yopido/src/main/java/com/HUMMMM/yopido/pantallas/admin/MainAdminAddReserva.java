package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainAdminAddReserva extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_reserva);

        final EditText nombre =  findViewById(R.id.editTextTextNombre);
        final EditText telf =  findViewById(R.id.editTextPhone);
        // --- activity_admin_add_reserva
        Button btnAddReserva;

        btnAddReserva = findViewById(R.id.button_Aceptar_Reserva_Admin);


        btnAddReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checks.camposRellenos(nombre,telf)) {
                    Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.error_add_Reserva, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    //Se comprueban los datos.
                    // Se añade la reserva al usuario si existe el usuario en la BDD.

                    // Se cambia finalmente, si todo sale bien, de clase
                    cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                }
            }
        }));



    }
}
