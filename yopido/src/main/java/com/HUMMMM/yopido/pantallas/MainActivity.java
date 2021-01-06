package com.HUMMMM.yopido.pantallas;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;

public class MainActivity extends BaseActivity {
    private static final String TAG = "prueba";
    Button btnEntar;
    Button btnRegistro;
    Button btnPedirYa;
    App app;
    Realm uiThreadRealm;
    private FirebaseAnalytics mFirebaseAnalytics;
    protected final void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //botones
        btnEntar = (Button) findViewById(R.id.btnEntrar);
        btnEntar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), MainIniciarSesion.class);
            }
        }));
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), MainRegistro.class);
            }
        }));
        btnPedirYa = (Button) findViewById(R.id.btnPideYa);
        btnPedirYa.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), MainReservaDirecta.class);
            }
        }));
        //Inicializo el objeto firebase
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        //lanzamos un evento analitycs
        Bundle bundle = new Bundle();
        bundle.putString("mensaje", "Inicio de la app");
        mFirebaseAnalytics.logEvent("PantallaInicio", bundle);

        //a ver que pasa
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FireBase fb = new FireBase(db);
        Log.d(TAG, "================= Lets goL ===============");
        fb.runAll();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}