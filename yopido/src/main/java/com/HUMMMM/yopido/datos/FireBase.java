package com.HUMMMM.yopido.datos;

import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
        datos.put("proteccionDeDatos", true);
        db.collection("usuarios").add(
                datos
        );
    }

    /**
     * Metodo que guarda una reserva
     *
     * @param correo
     * @param nombre
     * @param telefono
     * @param numeroPersonas
     * @param fecha
     * @param hora
     */
    public void guardarReserva(String correo, EditText nombre, String telefono, Spinner numeroPersonas, String fecha, Spinner hora) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("correo", correo);
        datos.put("nombre", nombre.getText().toString());
        datos.put("telefono", telefono);
        datos.put("numeroPersonas", numeroPersonas.getSelectedItem().toString());
        datos.put("fecha", fecha);
        datos.put("hora", hora.getSelectedItem().toString());
        datos.put("proteccionDeDatos", true);
        db.collection("reservas").add(
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



}

