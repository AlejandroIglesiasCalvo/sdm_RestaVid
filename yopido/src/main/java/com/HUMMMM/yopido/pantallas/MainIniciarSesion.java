package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.admin.MainActivityAdmin;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;
import com.google.android.material.snackbar.Snackbar;

public class MainIniciarSesion extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        Button btnIniciarSesionAceptar;

        final EditText correo = (EditText) findViewById(R.id.editTextCorreo);
        final EditText contraseña = findViewById(R.id.editTextTextPassword);
        btnIniciarSesionAceptar = (Button) findViewById(R.id.buttonIniciarSesionAceptar);

        btnIniciarSesionAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checks.comprobarIniciarSesion(correo, contraseña)) {
                    if (!checks.isAdmin(correo,contraseña))
                        cambiarDeClase.MoverA(v.getContext(), MainMenuLoggeado.class);
                    else
                        cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                } else
                    Snackbar.make(findViewById(R.id.buttonIniciarSesionAceptar), R.string.error_usuario_contra, Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}