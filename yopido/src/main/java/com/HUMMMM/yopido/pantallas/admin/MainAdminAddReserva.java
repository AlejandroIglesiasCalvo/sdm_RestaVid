package com.HUMMMM.yopido.pantallas.admin;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;
import com.google.android.material.snackbar.Snackbar;

public class MainAdminAddReserva extends BaseActivity {

    private String fechaseleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_reserva);

        final EditText nombre =  findViewById(R.id.editTextTextNombre);
        final EditText telf =  findViewById(R.id.editTextPhone);
        CalendarView calendar = (CalendarView) findViewById(R.id.calendarReserva);
        // --- activity_admin_add_reserva
        Button btnAddReserva;

        btnAddReserva = findViewById(R.id.button_Aceptar_Reserva_Admin);

        inicializarFechaDefecto();

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fechaseleccionada = dayOfMonth + "/" + month + "/" + year + "";
            }
        });

        btnAddReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checks.camposRellenos(nombre,telf)) {
                    Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.error_add_Reserva, Snackbar.LENGTH_SHORT).show();
                }
                else
                {if (checks.camposRellenos(nombre)) {
                    if (comprobarFechaCalendario(fechaseleccionada)) {

                        cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                    } else
                        Snackbar.make(findViewById(R.id.buttonIniciarSesionAceptar), R.string.error_fecha_calendario, Snackbar.LENGTH_SHORT).show();
                } else
                    Snackbar.make(findViewById(R.id.buttonIniciarSesionAceptar), R.string.error_add_Reserva, Snackbar.LENGTH_SHORT).show();
                }
            }
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
