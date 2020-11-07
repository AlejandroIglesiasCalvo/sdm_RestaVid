package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.pantallas.BaseActivity;

public class MainAdminDeleteUser extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_user);

        // --- activity_admin_delete_user
        Button btnAceptarEliminarUser;
        Button btnCancelarEliminarUser;
        btnAceptarEliminarUser = (Button) findViewById(R.id.buttonAceptar_EliminarUser_Admin);
        btnCancelarEliminarUser = (Button) findViewById(R.id.buttonCancelar_EliminarUser_Admin);

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
