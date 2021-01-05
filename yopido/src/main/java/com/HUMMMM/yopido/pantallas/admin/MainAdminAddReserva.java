package com.HUMMMM.yopido.pantallas.admin;

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
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public class MainAdminAddReserva extends BaseActivity {

    final EditText nombre =  findViewById(R.id.editTextTextNombre);
    final EditText telf =  findViewById(R.id.editTextPhone);
    final Spinner numPersonas = findViewById(R.id.spPersonas);
    final Spinner horaReserva = findViewById(R.id.spHora);

    final CalendarView calendario = findViewById(R.id.calendarReserva);
    Long date = calendario.getDate();

    String diaSeleccionado;

    String fechaseleccionada;
    
    ReservaDataSource rds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_reserva);


        Button btnAddReserva;

        btnAddReserva = findViewById(R.id.button_Aceptar_Reserva_Admin);


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
                    addReserva();
                    Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.ok_admin_addReserva, Snackbar.LENGTH_SHORT).show();
                    cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                }
            }
        }));
    }

    private void addReserva()
    {
        Reserva reserva = new Reserva();
        reserva.setNombreUsuario(nombre.toString());
        reserva.setTelef(telf.toString());
        reserva.setNumeroDePersonas(Integer.parseInt(numPersonas.getSelectedItem().toString()));
        reserva.setHora(horaReserva.toString());

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                if(calendario.getDate() != date){
                    date = calendario.getDate();
                    diaSeleccionado = dayOfMonth + "/" + month + "/" + year + "";
                }
            }
        });
        reserva.setFecha(fechaseleccionada);
        
        rds.createReserva(reserva);
    }
}
