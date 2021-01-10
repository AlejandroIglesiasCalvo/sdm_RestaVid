package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.admin.MainActivityAdmin;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLogueado;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainIniciarSesion extends BaseActivity {
    private FireBase fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        FirebaseAnalytics fa = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("InciarSesion", "Iniciar sesion");
        fa.logEvent("InciarSesion", bundle);

        String horaInicio = getIntent().getStringExtra("correo");
        String horaFin = getIntent().getStringExtra("telefono");
        String maxPersonas = getIntent().getStringExtra("h1");

        final EditText correo = (EditText) findViewById(R.id.editTextCorreo);
        final EditText contraseña = findViewById(R.id.editTextTextPassword);
        Button btnIniciarSesionAceptar = (Button) findViewById(R.id.buttonIniciarSesionAceptar);

        btnIniciarSesionAceptar.setOnClickListener(((v) -> {
            if (checks.camposRellenos(correo, contraseña)) {
                fb = new FireBase();
                FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(correo.getText().toString(), contraseña.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    if (correo.getText().toString().equals("admin@restavid.es")) {
                                        cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class, correo.getText().toString(), horaInicio, horaFin, maxPersonas);
                                    } else {
                                        cambiarDeClase.MoverA(v.getContext(), MainMenuLogueado.class, correo.getText().toString(), horaInicio, horaFin, maxPersonas);
                                    }
                                } else {
                                    System.out.println("NO VA");
                                    Snackbar.make(findViewById(R.id.buttonIniciarSesionAceptar), R.string.error_usuario_contra, Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else {
                Snackbar.make(findViewById(R.id.buttonIniciarSesionAceptar), R.string.error_usuario_contra, Snackbar.LENGTH_SHORT).show();
            }
        }));
    }
}