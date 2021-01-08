package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainRegistro extends BaseActivity {
    private FireBase fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Analytics
        setContentView(R.layout.activity_registro);
        FirebaseAnalytics fa = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("Mensaje", "Integracion de firebase completa");
        fa.logEvent("InitScreen", bundle);

        final EditText correo = findViewById(R.id.editTextCorreo);
        final EditText pass = findViewById(R.id.editTextTextPassword);
        final EditText nombre = findViewById(R.id.editTextTextNombre);
        final EditText telefono = findViewById(R.id.editTextPhone);

        Button btnRegistroAceptar;

        btnRegistroAceptar = (Button) findViewById(R.id.buttonRegistroAceptar);
        btnRegistroAceptar.setOnClickListener(((v) -> {
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
                                    Snackbar.make(findViewById(R.id.buttonRegistroAceptar), R.string.error_registro, Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else {
                Snackbar.make(findViewById(R.id.buttonRegistroAceptar), R.string.error_registro, Snackbar.LENGTH_SHORT).show();
            }
        }));

    }
}
