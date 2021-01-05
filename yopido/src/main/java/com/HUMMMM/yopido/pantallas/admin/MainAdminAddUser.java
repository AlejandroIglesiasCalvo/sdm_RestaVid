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
import com.HUMMMM.yopido.modelo.Usuario;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainAdminAddUser extends BaseActivity {

    UsuariosDataSource uds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_user);

        final EditText correo = findViewById(R.id.editTextCorreo);
        final EditText pass =  findViewById(R.id.editTextTextPassword);
        final EditText nombre =  findViewById(R.id.editTextTextNombre);
        final EditText apellidos = findViewById(R.id.editTextTextApellidos);
        final EditText telf = findViewById(R.id.editTextPhone);



        // --- activity_admin_add_user
        Button btnAddUser;
        btnAddUser = findViewById(R.id.buttonAceptar_AñadirUser_Admin);

        
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checks.camposRellenos(correo,pass,nombre,telf,apellidos)) {
                    Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_admin_addUser, Snackbar.LENGTH_SHORT).show();
                }
                else {
                    // comprbar que están bien y añadirlo a la BDD.
                    if(!checks.existeEmailEnBDD(correo)
                            && checks.isEmailValid(String.valueOf(correo))
                            && checks.isValidPassword(String.valueOf(pass))){


                        addUsuario(correo.toString(), nombre.toString(),apellidos.toString(),telf.toString(),pass.toString());
                    }
                    else
                        Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_admin_addUser, Snackbar.LENGTH_SHORT).show();

                    cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                }
            }
        });

    }

    private void addUsuario(String email, String nombre, String apellidos, String telefono, String contraseña)
    {
        Usuario usuario = new Usuario();

        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setTelefono(telefono);
        usuario.setContraseña(contraseña);
        usuario.setPoliticaDeProteccionDeDatos(true);

        uds.createUsuario(usuario);
    }
}
