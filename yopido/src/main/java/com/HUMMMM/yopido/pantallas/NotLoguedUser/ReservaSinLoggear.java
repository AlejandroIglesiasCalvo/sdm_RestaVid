package com.HUMMMM.yopido.pantallas.NotLoguedUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.ReservaDataSource;
import com.HUMMMM.yopido.modelo.Reserva;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;
import com.google.android.material.snackbar.Snackbar;

public class ReservaSinLoggear extends BaseActivity {

    ReservaDataSource rds;

    String fechaseleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_directa);

        final EditText editTextnombre = findViewById(R.id.editTextTextNombre_directa);
        final EditText editTextPhone = findViewById(R.id.editTextPhone_directa);
        final CalendarView calendario = findViewById(R.id.calendarReserva_directa);

        final Spinner spNumPersonas = findViewById(R.id.spPersonas_directa);
        final Spinner horaReserva = findViewById(R.id.spHora_directa);

        final Button btnReservar = (Button) findViewById(R.id.buttonAceptar);


        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fechaseleccionada = dayOfMonth + "/" + month + "/" + year + "";
                System.out.println(fechaseleccionada);
            }
        });

        btnReservar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checks.camposRellenos(editTextnombre,editTextPhone))
                    if(checks.comprobarFechaCalendario(fechaseleccionada))
                        if(guardarValores(editTextnombre.toString(),
                                editTextPhone.toString(),
                                Integer.parseInt(spNumPersonas.getSelectedItem().toString()),
                                horaReserva.getSelectedItem().toString()))
                                        cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class);

                    else
                        Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_fecha_calendario, Snackbar.LENGTH_SHORT).show();
                else
                    Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_reserva, Snackbar.LENGTH_SHORT).show();
            }
        }));
    }

    private boolean guardarValores(String nombre, String telf, int nPersonas, String horaReserva)
    {
        Reserva r = new Reserva();
        r.setNombreUsuario(nombre);
        r.setTelef(telf);
        r.setNumeroDePersonas(nPersonas);
        r.setHora(horaReserva);
        r.setFecha(fechaseleccionada);

        //rds.createReserva(r);

        return true;
    }

}
