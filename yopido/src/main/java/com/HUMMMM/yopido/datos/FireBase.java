package com.HUMMMM.yopido.datos;

import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"unused", "Convert2Lambda"})
public class FireBase {
    private static final String TAG = "RestaVidBBDD100%RealNOFake";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    boolean existe = false;
    public boolean semaforo = false;

    public FireBase() {

    }

    /**
     * Metodo que guarda los datos de un nuevo usuatio en firebase
     *
     * @param correo
     * @param contraseña
     * @param nombre
     * @param telefono
     */
    public void guardardatos(EditText correo, EditText contraseña, EditText nombre, EditText telefono) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("correo", correo.getText().toString());
        datos.put("contraseña", contraseña.getText().toString());
        datos.put("nombre", nombre.getText().toString());
        datos.put("telefono", telefono.getText().toString());

        db.collection("usuarios").add(
                datos
        );
    }

    /**
     * Busca un usuario por su correo electronico en la coleccion, se guarda el resultado en la variable global existe
     *
     * @param correo
     */
    public void buscarUsuario(String correo) {
        existe = false;
        semaforo = false;
        List me = new ArrayList();
        db.collection("usuarios")//Buscamos en la coleccion usuarios
                .whereEqualTo("correo", correo)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {
                        me.add(snapshots.getDocuments());
                        if (e != null) {
                            Log.w(TAG, "Listen failed.", e);
                            return;
                        }

                        Log.d(TAG, "Current users born before 1900: " + snapshots);

                        semaforo = true;
                        setEstado(true);


                    }
                });
    }

    private void setEstado(Boolean estado) {
        existe = estado;
    }

    /**
     * LLamar primero a BUSCARUSUARIO
     *
     * @return si existe o no
     */
    public boolean getEstado() {
        return existe;
    }


    public void buscarUsuario(String correo, String contraseña) {
        auth.createUserWithEmailAndPassword(correo, contraseña)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                        }

                        // ...
                    }
                });

    }


    public void getAllUsers() {
        // [START get_all_users]
        db.collection("pedo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
        // [END get_all_users]
    }

}

