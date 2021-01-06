package com.HUMMMM.yopido.datos;

import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class FireBase {
    private static final String TAG = "RestaVidBBDD100%RealNOFake";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    boolean existe = false;

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
        db.collection("usuarios")//Buscamos en la coleccion usuarios
                .whereLessThan("correo", correo)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {

                        if (e != null) {
                            Log.w(TAG, "No existe el usuario.", e);
                            setEstado(true);
                            return;
                        }

                        Log.d(TAG, "El usuario ya esta registrado con el nombre: " + snapshots);

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
}

