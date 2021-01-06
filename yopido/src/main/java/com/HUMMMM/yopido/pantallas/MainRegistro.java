package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.material.snackbar.Snackbar;

public class MainRegistro extends BaseActivity {
    private FireBase fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final EditText correo =  findViewById(R.id.editTextCorreo);
        final EditText pass =  findViewById(R.id.editTextTextPassword);
        final EditText nombre =  findViewById(R.id.editTextTextNombre);
        final EditText apellidos =  findViewById(R.id.editTextTextApellidos);
        final EditText telefono =  findViewById(R.id.editTextPhone);

        Button btnRegistroAceptar;
        Button btnRegistroCancelar;
        fb = new FireBase();
        btnRegistroAceptar = (Button) findViewById(R.id.buttonRegistroAceptar);
        btnRegistroAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText correo = (EditText) findViewById(R.id.editTextCorreo);
                EditText contraseña = (EditText) findViewById(R.id.editTextTextPassword);
                EditText nombre = (EditText) findViewById(R.id.editTextTextNombre);
                EditText telefono = (EditText) findViewById(R.id.editTextPhone);
                fb.guardardatos(correo, contraseña, nombre, telefono);
                //Registor con email en la appi de autentificacion
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo.getText().toString(), contraseña.getText().toString());

            if(checks.camposRellenos(correo,pass,nombre,apellidos,telefono))
                cambiarDeClase.MoverA(v.getContext(), MainMenuLoggeado.class);
            else
                Snackbar.make(findViewById(R.id.buttonRegistroAceptar), R.string.error_registro, Snackbar.LENGTH_SHORT).show();
            }
        }));
    }


    }
}