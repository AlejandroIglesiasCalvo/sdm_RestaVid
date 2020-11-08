package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;

public class MainAdminAddUser extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_user);

        // --- activity_admin_add_user
        Button btnAñadirUser;
        btnAñadirUser = (Button) findViewById(R.id.buttonAceptar_AñadirUser_Admin);



        btnAñadirUser.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se comprueba que todos los campos estén bien y se elimina a la BDD en caso de existir.
                // Si no eiste, se muestra mensaje de que nanai.

                // Se regresa a la pantalla principal del admin
                cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
            }
        }));

    }
}
