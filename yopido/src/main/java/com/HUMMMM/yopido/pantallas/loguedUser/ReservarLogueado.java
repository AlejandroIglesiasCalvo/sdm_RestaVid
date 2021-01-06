package com.HUMMMM.yopido.pantallas.loguedUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.ReservaDataSource;
import com.HUMMMM.yopido.modelo.Reserva;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;
import com.HUMMMM.yopido.pantallas.admin.MainActivityAdmin;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class ReservarLogueado extends BaseActivity {

    String fechaseleccionada;
    ReservaDataSource rds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_logueado);

        final EditText nombre =  findViewById(R.id.editTextTextNombre);
        final EditText telf =  findViewById(R.id.editTextPhone);
        final Spinner numPersonas = findViewById(R.id.spPersonas);
        final Spinner horaReserva = findViewById(R.id.spHora);
        final CalendarView calendario = findViewById(R.id.calendarReserva);

        Button btnAddReserva;
        btnAddReserva = findViewById(R.id.button_Aceptar_Reserva_Admin);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fechaseleccionada = dayOfMonth + "/" + month + "/" + year + "";
            }
        });


        btnAddReserva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checks.camposRellenos(nombre,telf)) {
                    Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.error_admin_addReserva, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    //Se comprueban los datos.
                    // Se cambia finalmente, si sale bien, de clase
                    if(checks.comprobarFechaCalendario(fechaseleccionada))
                        if(addReserva(nombre.toString(),
                                telf.toString(),
                                Integer.parseInt(numPersonas.getSelectedItem().toString()),
                                horaReserva.toString())
                        ){
                            Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.ok_admin_addReserva, Snackbar.LENGTH_SHORT).show();
                            cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                        }
                        else
                            Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.error_fecha_admin_addReserva, Snackbar.LENGTH_SHORT).show();


                }
            }
        }));
    }

    private boolean addReserva(String nombre, String telf, int nPersonas, String horaReserva)
    {
        Reserva reserva = new Reserva();
        reserva.setNombreUsuario(nombre);
        reserva.setTelef(telf);
        reserva.setNumeroDePersonas(nPersonas);
        reserva.setHora(horaReserva);
        reserva.setFecha(fechaseleccionada);

        //rds.createReserva(reserva);

        return true;
    }

}
