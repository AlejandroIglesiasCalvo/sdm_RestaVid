package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;

import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MainAdminDeleteUser extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_user);

        final EditText correoUsuario = findViewById(R.id.editTextCorreoUser);
        final EditText contraAdmin = findViewById(R.id.editTextTextPasswordAdmin);

        // --- activity_admin_delete_user
        Button btnAceptarEliminarUser;
        btnAceptarEliminarUser = (Button) findViewById(R.id.buttonAceptar_EliminarUser_Admin);

        btnAceptarEliminarUser.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se comprueba que todos los campos estén bien y se elimina a la BDD en caso de existir.
                // Si no eiste, se muestra mensaje de que nanai.

                if (checks.isPasswordAdminValid(contraAdmin)) {
                    FirebaseFirestore.getInstance().collection("usuarios")
                            .whereEqualTo("correo", correoUsuario.getText().toString())
                            .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                @Override
                                public void onEvent(@Nullable QuerySnapshot snapshots,
                                                    @Nullable FirebaseFirestoreException e) {
                                    if (e != null) {
                                        System.out.println("Listen failed. " + e);
                                        Snackbar.make(findViewById(R.id.buttonAceptar_EliminarUser_Admin), R.string.error_delete_user, Snackbar.LENGTH_SHORT).show();
                                        return;
                                    }
                                    String correo, contraseña;
                                    List<DocumentSnapshot> docs = snapshots.getDocuments();
                                    for (DocumentSnapshot a : docs) {
                                        DocumentReference df = a.getReference();
                                        correo = a.getString("correo");
                                        contraseña = a.getString("contraseña");
                                        FirebaseFirestore.getInstance().collection("usuarios").document(a.getId()).delete();
                                        FirebaseAuth.getInstance()
                                                .signInWithEmailAndPassword(correo, contraseña)
                                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                        if (task.isSuccessful()) {
                                                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                                            user.delete();
                                                            System.out.println("Successfully deleted user.");
                                                            cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                                                        } else {
                                                            System.out.println("NO VA");
                                                        }
                                                    }
                                                });
                                    }
                                }
                            });
                } else {
                    Snackbar.make(findViewById(R.id.buttonAceptar_EliminarUser_Admin), R.string.error_delete_user, Snackbar.LENGTH_SHORT).show();
                }
            }
        }));
    }
}
