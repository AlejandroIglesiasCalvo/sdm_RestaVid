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

import java.util.Calendar;

public class ReservaSinLoggear extends BaseActivity {


    String fechaseleccionada;
    ReservaDataSource rds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_directa);

        final EditText editTextnombre = findViewById(R.id.editTextTextNombre_directa);
        final EditText editTextPhone = findViewById(R.id.editTextPhone_directa);
        final CalendarView calendario = findViewById(R.id.calendarReserva_directa);

        final Spinner spNumPersonas = findViewById(R.id.spPersonas_directa);
        final Spinner horaReserva = findViewById(R.id.spHora_directa);

        final Button btnReservar = (Button) findViewById(R.id.buttonReservaDirectaAceptar);


        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fechaseleccionada = dayOfMonth + "/" + month + "/" + year + "";
            }
        });



        btnReservar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checks.camposRellenos(editTextnombre, editTextPhone))
                {
                    System.out.println("Campos rellenos");
                    /*
                    if (comprobarFechaCalendario(fechaseleccionada))
                    {
                        if (guardarValores(editTextnombre.toString(),
                                editTextPhone.toString(),
                                Integer.parseInt(spNumPersonas.getSelectedItem().toString()),
                                horaReserva.getSelectedItem().toString()))
                            cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class);
                        else
                            Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_fecha_calendario, Snackbar.LENGTH_SHORT).show();
                    }
                    else
                        Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_fecha_calendario, Snackbar.LENGTH_SHORT).show();
                     */

                }
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
