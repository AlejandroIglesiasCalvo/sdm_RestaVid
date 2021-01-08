package com.HUMMMM.yopido.pantallas.loguedUser;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ReservarLogueado extends BaseActivity {
    private FireBase fb;
    private String fechaseleccionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_logueado);
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");
        //Analytics
        FirebaseAnalytics fa = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("Mensaje", "Quiere reservar");
        fa.logEvent("Reserva", bundle);
        fb = new FireBase();


        Button btnAceptar;
        EditText nombre = findViewById(R.id.editTextTextNombre);
        btnAceptar = (Button) findViewById(R.id.buttonAceptar);
        Spinner spnPersonas = (Spinner) findViewById(R.id.spPersonas);
        Spinner spnHoras = (Spinner) findViewById(R.id.spHora);
        CalendarView calendar = (CalendarView) findViewById(R.id.calendarReserva);

        inicializarFechaDefecto();

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fechaseleccionada = dayOfMonth + "/" + (month + 1) + "/" + year + "";
            }
        });


        btnAceptar.setOnClickListener((v -> {
            //Buscar las reservas en ese dia
            // [START get_all_users]
            FirebaseFirestore.getInstance().collection("reservas")
                    .whereEqualTo("fecha", fechaseleccionada)
                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot snapshots,
                                            @Nullable FirebaseFirestoreException e) {
                            if (e != null) {
                                System.out.println("Listen failed. " + e);
                                return;
                            }
                            List<DocumentSnapshot> docs = snapshots.getDocuments();
                            List<String> ocupadas = new ArrayList<String>();
                            for (DocumentSnapshot a : docs) {
                                ocupadas.add(a.getString("hora"));
                            }
                            if (ocupadas.contains(spnHoras.getSelectedItem().toString())) {
                                Snackbar.make(findViewById(R.id.buttonAceptar), R.string.error_hora_ya_reservada, Snackbar.LENGTH_SHORT).show();
                            } else {
                                if (checks.camposRellenos(nombre)) {
                                    if (comprobarFechaCalendario(fechaseleccionada)) {
                                        fb.guardarReserva(correo, nombre, telefono, spnPersonas, fechaseleccionada, spnHoras);
                                        cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class,correo);
                                    } else
                                        Snackbar.make(findViewById(R.id.buttonAceptar), R.string.error_fecha_calendario, Snackbar.LENGTH_SHORT).show();
                                } else {
                                    Snackbar.make(findViewById(R.id.buttonAceptar), R.string.error_add_Reserva, Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        }));
    }

    private void inicializarFechaDefecto() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        fechaseleccionada = mDay + "/" + mMonth + "/" + mYear + "";
    }


    public boolean comprobarFechaCalendario(String fechaseleccionada) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        String[] fechaAComprobar = fechaseleccionada.split("/");
        int compDia = Integer.parseInt(fechaAComprobar[0]);
        int compMes = Integer.parseInt(fechaAComprobar[1]);
        int compAnio = Integer.parseInt(fechaAComprobar[2]);

        if (compDia <= mDay || compMes < mMonth || compAnio < mYear) {
            return false;
        }
        return true;
    }

}
