package com.HUMMMM.yopido.pantallas.admin;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.annotation.Nullable;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainAdminAddReserva extends BaseActivity {
    private FireBase fb;
    private String fechaseleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_reserva);

        String horaInicio = getIntent().getStringExtra("correo");
        String horaFin = getIntent().getStringExtra("telefono");
        String maxPersonas = getIntent().getStringExtra("h1");


        EditText nombre = (EditText) findViewById(R.id.editTextTextNombre);
        EditText telefono = (EditText) findViewById(R.id.editTextPhone);
        CalendarView calendar = (CalendarView) findViewById(R.id.calendarReserva);
        Button btnAddReserva = (Button) findViewById(R.id.button_Aceptar_Reserva_Admin);
        Spinner spnPersonas= (Spinner) findViewById(R.id.spPersonas);
        checks.llenarSpinnerMaxPersonas(spnPersonas, maxPersonas, this);
        Spinner spnHoras= (Spinner) findViewById(R.id.spHora);
        checks.llenarSpinnerHoras(spnHoras, horaInicio, horaFin, this);


        inicializarFechaDefecto();
        fb = new FireBase();

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fechaseleccionada = dayOfMonth + "/" + (month+1) + "/" + year + "";
            }
        });

        btnAddReserva.setOnClickListener((v -> {
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
                                Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.error_hora_ya_reservada, Snackbar.LENGTH_SHORT).show();
                            } else {
                                if (checks.camposRellenos(nombre, telefono)) {
                                    if (comprobarFechaCalendario(fechaseleccionada)) {
                                        fb.guardarReserva("SINCORREO@SINCORREO.COM", nombre, telefono.getText().toString(), spnPersonas, fechaseleccionada, spnHoras);
                                        cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class, "admin@restavid.es", horaInicio, horaFin, maxPersonas);
                                    } else
                                        Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.error_fecha_calendario, Snackbar.LENGTH_SHORT).show();
                                } else {
                                    Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.error_add_Reserva, Snackbar.LENGTH_SHORT).show();
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
        int mMonth = c.get(Calendar.MONTH)+1;
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        String[] fechaAComprobar = fechaseleccionada.split("/");
        int compDia = Integer.parseInt(fechaAComprobar[0]);
        int compMes = Integer.parseInt(fechaAComprobar[1]);
        int compAnio = Integer.parseInt(fechaAComprobar[2]);


        if (compAnio < mYear) {
            return false;
        } else if (compAnio > mYear) {
            return true;
        } else {
            if (compMes < mMonth) {
                return false;
            } else if (compMes > mMonth) {
                return true;
            } else {
                if (compDia <= mDay) {
                    return false;
                } else if (compDia > mDay) {
                    return true;
                }
            }
        }
        return true;
    }



}
