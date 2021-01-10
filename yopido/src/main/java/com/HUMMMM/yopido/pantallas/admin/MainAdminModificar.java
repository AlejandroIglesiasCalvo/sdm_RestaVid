package com.HUMMMM.yopido.pantallas.admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.MainActivity;
import com.HUMMMM.yopido.pantallas.MainIniciarSesion;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MainAdminModificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_modificar);
        String correo = getIntent().getStringExtra("correo");
        String horaInicio = getIntent().getStringExtra("telefono");
        String horaFin = getIntent().getStringExtra("h1");
        String maxPersonas = getIntent().getStringExtra("h2");

        EditText numPersonas = (EditText) findViewById(R.id.numeroPersonas);
        EditText hI = (EditText) findViewById(R.id.horaInicio);
        EditText hF = (EditText) findViewById(R.id.horaFin);
        Button btnAceptar = (Button) findViewById(R.id.btnModificarAdmon);

        btnAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference horario = FirebaseFirestore.getInstance().collection("horas").document("horario");
                if (numPersonas.length() != 0 && hI.length() != 0 && hF.length() != 0) {
                    // Cambiamos la hora de apertura
                    horario
                            .update("horaInicio", hI.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "DocumentSnapshot successfully updated!");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("TAG", "Error updating document", e);
                                }
                            });
                    // Cambiamos la hora de cierre
                    horario
                            .update("horaFin", hF.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "DocumentSnapshot successfully updated!");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("TAG", "Error updating document", e);
                                }
                            });
                    // Cambiamos el numero de comensales
                    horario
                            .update("numeroMaxPersonas", numPersonas.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "DocumentSnapshot successfully updated!");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("TAG", "Error updating document", e);
                                }
                            });
                    cambiarDeClase.MoverA(v.getContext(), MainIniciarSesion.class, correo,
                            hI.getText().toString(), hF.getText().toString(), numPersonas.getText().toString());
                }
            }
        }));

    }

}