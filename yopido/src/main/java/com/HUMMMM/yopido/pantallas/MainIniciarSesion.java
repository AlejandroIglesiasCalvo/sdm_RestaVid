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
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;

public class MainIniciarSesion extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        Button btnIniciarSesionAceptar;
        Button btnIniciarSesionCancelar;
        final EditText correo = (EditText) findViewById(R.id.editTextCorreo);
        final TextView contraseña = (TextView) findViewById(R.id.editTextTextPassword);
        btnIniciarSesionAceptar = (Button) findViewById(R.id.buttonIniciarSesionAceptar);
        btnIniciarSesionAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para ir a pantalla de entrar en la app cuando el usuario está registrado
                //String m = correo.getText().toString();
                //String c = contraseña.getText().toString();
                //if (checks.comprobarIniciarSesion(m, c)) {
                    cambiarDeClase.MoverA(v.getContext(), MainMenuLoggeado.class);
                //}
            }
        });


    }
}