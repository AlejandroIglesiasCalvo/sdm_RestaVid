package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;
import com.google.firebase.auth.FirebaseAuth;

public class MainRegistro extends BaseActivity {
    private FireBase fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
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
                cambiarDeClase.MoverA(v.getContext(), MainMenuLoggeado.class);
            }
        }));
    }


}