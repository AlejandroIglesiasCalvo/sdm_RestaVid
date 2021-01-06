package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.UsuariosDataSource;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;
import com.google.android.material.snackbar.Snackbar;

public class MainAdminDeleteUser extends BaseActivity {

    private static UsuariosDataSource uds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_user);

        final EditText correoUsuario = findViewById(R.id.editTextCorreoUser);

        Button btnAceptarEliminarUser;
        btnAceptarEliminarUser = (Button) findViewById(R.id.buttonAceptar_EliminarUser_Admin);

        btnAceptarEliminarUser.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se comprueba que todos los campos estén bien y se elimina a la BDD en caso de existir.
                // Si no eiste, se muestra mensaje de que nanai.

                    if (checks.camposRellenos(correoUsuario)) {
                            if(!eliminarUsuario(correoUsuario))
                                Snackbar.make(findViewById(R.id.buttonAceptar_EliminarUser_Admin), R.string.error_delete_user, Snackbar.LENGTH_SHORT).show();
                            else {
                                Snackbar.make(findViewById(R.id.buttonAceptar_EliminarUser_Admin), R.string.ok_delete_user, Snackbar.LENGTH_SHORT).show();
                                //cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                            }
                    }
                    else
                        Snackbar.make(findViewById(R.id.buttonAceptar_EliminarUser_Admin), R.string.error_delete_user, Snackbar.LENGTH_SHORT).show();
            }
        }));
    }

    private boolean eliminarUsuario(EditText correo)
    {
        //return uds.deleteUser(correo);
        return true;
    }
}
