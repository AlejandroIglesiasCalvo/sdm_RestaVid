package com.HUMMMM.yopido.pantallas;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = "prueba";
    Button btnEntar;
    Button btnRegistro;
    Button btnPedirYa;


    private FirebaseAnalytics mFirebaseAnalytics;
    private FireBase fb;

    protected final void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fb = new FireBase();
        //botones
        btnEntar = (Button) findViewById(R.id.btnEntrar);
        btnEntar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore.getInstance().collection("horas")
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot snapshots,
                                                @Nullable FirebaseFirestoreException e) {
                                if (e != null) {
                                    System.out.println("Listen failed. " + e);
                                    return;
                                }
                                List<DocumentSnapshot> docs = snapshots.getDocuments();
                                for (DocumentSnapshot a : docs) {
                                    String horaInicio = a.getString("horaInicio");
                                    String horaFin = a.getString("horaFin");
                                    String maxPersonas = a.getString("numeroMaxPersonas");
                                    cambiarDeClase.MoverA(v.getContext(), MainIniciarSesion.class, horaInicio, horaFin, maxPersonas);
                                }
                            }
                        });
            }
        }));


        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore.getInstance().collection("horas")
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot snapshots,
                                                @Nullable FirebaseFirestoreException e) {
                                if (e != null) {
                                    System.out.println("Listen failed. " + e);
                                    return;
                                }
                                List<DocumentSnapshot> docs = snapshots.getDocuments();
                                for (DocumentSnapshot a : docs) {
                                    String horaInicio = a.getString("horaInicio");
                                    String horaFin = a.getString("horaFin");
                                    String maxPersonas = a.getString("numeroMaxPersonas");
                                    cambiarDeClase.MoverA(v.getContext(), MainRegistro.class, horaInicio, horaFin, maxPersonas);
                                }
                            }
                        });
            }
        }));

        btnPedirYa = (Button) findViewById(R.id.btnPideYa);
        btnPedirYa.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore.getInstance().collection("horas")
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot snapshots,
                                                @Nullable FirebaseFirestoreException e) {
                                if (e != null) {
                                    System.out.println("Listen failed. " + e);
                                    return;
                                }
                                List<DocumentSnapshot> docs = snapshots.getDocuments();
                                for (DocumentSnapshot a : docs) {
                                    String horaInicio = a.getString("horaInicio");
                                    String horaFin = a.getString("horaFin");
                                    String maxPersonas = a.getString("numeroMaxPersonas");
                                    cambiarDeClase.MoverA(v.getContext(), MainReservaDirecta.class, horaInicio, horaFin, maxPersonas);
                                }
                            }
                        });
            }
        }));
        //Inicializo el objeto firebase
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        //lanzamos un evento analitycs
        Bundle bundle = new Bundle();
        bundle.putString("mensaje", "Inicio de la app");
        mFirebaseAnalytics.logEvent("PantallaInicio", bundle);
        mFirebaseAnalytics.resetAnalyticsData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}