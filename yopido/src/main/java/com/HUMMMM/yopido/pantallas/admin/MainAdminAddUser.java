package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainAdminAddUser extends BaseActivity {
    private FireBase fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_user);
        final EditText correo = findViewById(R.id.editTextCorreo);
        final EditText pass =  findViewById(R.id.editTextTextPassword);
        final EditText nombre =  findViewById(R.id.editTextTextNombre);
        final EditText telefono = findViewById(R.id.editTextPhone);
        fb = new FireBase();

        // --- activity_admin_add_user
        Button btnAddUser;
        btnAddUser = findViewById(R.id.buttonAceptar_AñadirUser_Admin);

        btnAddUser.setOnClickListener(((v) -> {
            if (checks.camposRellenos(correo, pass, nombre, telefono)) {
                fb = new FireBase();
                FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(correo.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    fb.guardardatos(correo, pass, nombre, telefono);

                                    cambiarDeClase.MoverA(v.getContext(), MainMenuLoggeado.class, correo.getText().toString(),telefono.getText().toString());
                                } else {
                                    System.out.println("NO VA");
                                    Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_registro, Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else {
                Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_corrreo_no_valido, Snackbar.LENGTH_SHORT).show();
            }
        }));

        /*
        btnAddUser.setOnClickListener(v -> {
            if(!checks.camposRellenos(correo,pass,nombre,telf)) {
                Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_admin_addUser, Snackbar.LENGTH_SHORT).show();
            }
            else {
                // comprbar que están bien y añadirlo a la BDD.
                if(!checks.existeEmailEnBDD(correo)
                        && checks.isEmailValid(String.valueOf(correo)) && checks.isValidPassword(String.valueOf(pass)))

                {

                }
                else
                    Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_admin_addUser, Snackbar.LENGTH_SHORT).show();

                cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
            }
        });*/

    }
}
