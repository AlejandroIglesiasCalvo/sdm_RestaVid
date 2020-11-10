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

public class MainAdminAddUser extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_user);
        final EditText correo = (EditText) findViewById(R.id.editTextCorreo);
        final EditText pass = (EditText) findViewById(R.id.editTextTextPassword);
        final EditText nombre = (EditText) findViewById(R.id.editTextTextNombre);
        final EditText telf = (EditText) findViewById(R.id.editTextPhone);


        // --- activity_admin_add_user
        Button btnAñadirUser;
        btnAñadirUser = (Button) findViewById(R.id.buttonAceptar_AñadirUser_Admin);



        btnAñadirUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checks.camposRellenos(correo,pass,nombre,telf)) {
                    Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_admin_addUser, Snackbar.LENGTH_SHORT).show();
                }
                else {
                    cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                }

            }
        });

    }
}
