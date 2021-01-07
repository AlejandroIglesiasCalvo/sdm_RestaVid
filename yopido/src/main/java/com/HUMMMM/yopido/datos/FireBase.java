package com.HUMMMM.yopido.datos;

import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public boolean checkEmailEnUso(EditText correo, EditText pass){
        final boolean[] sePuede = {false, false};
        AtomicBoolean done = new AtomicBoolean(false);
        try {
            auth.createUserWithEmailAndPassword(correo.getText().toString(), pass.getText().toString()).addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                try {
                                    throw task.getException();
                                }
                                // if user enters wrong email.
                                catch (FirebaseAuthWeakPasswordException weakPassword) {
                                    Log.d(TAG, "onComplete: weak_password");
                                    done.set(true);
                                    sePuede[0] = true;
                                    sePuede[1] = true;
                                }
                                // if user enters wrong password.
                                catch (FirebaseAuthInvalidCredentialsException malformedEmail) {
                                    Log.d(TAG, "onComplete: malformed_email");
                                    done.set(true);
                                    sePuede[0] = true;
                                    sePuede[1] = true;
                                } catch (FirebaseAuthUserCollisionException existEmail) {
                                    Log.d(TAG, "onComplete: exist_email");
                                    done.set(true);
                                    sePuede[0] = true;
                                    sePuede[1] = false;
                                } catch (Exception e) {
                                    Log.d(TAG, "onComplete: " + e.getMessage());
                                }
                            }
                        }
                    });
        }catch (Exception e ) {

        }
        synchronized (done) {
            while (done.get() == false) {
                done.wait(); // wait here until the listener fires
            }
        }
        return sePuede[1];
    }
}

