package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainRegistro extends BaseActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button btnRegistroAceptar;
        Button btnRegistroCancelar;

        btnRegistroAceptar = (Button) findViewById(R.id.buttonRegistroAceptar);
        btnRegistroAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText correo = (EditText) findViewById(R.id.editTextCorreo);
                EditText contraseña = (EditText) findViewById(R.id.editTextTextPassword);
                EditText nombre = (EditText) findViewById(R.id.editTextTextNombre);
                EditText telefono = (EditText) findViewById(R.id.editTextPhone);
                guardardatos(correo,contraseña, nombre, telefono);
                //Registor con email
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo.getText().toString(), contraseña.getText().toString());
                cambiarDeClase.MoverA(v.getContext(), MainMenuLoggeado.class);
            }
        }));


    }

    private void guardardatos(EditText correo,EditText contraseña, EditText nombre, EditText telefono) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("correo", correo.getText().toString());
        datos.put("contraseña", contraseña.getText().toString());
        datos.put("nombre", nombre.getText().toString());
        datos.put("telefono", telefono.getText().toString());

        db.collection("usuarios").add(
                datos
        );
    }
}