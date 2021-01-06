package com.HUMMMM.yopido.pantallas.admin;

import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.modelo.Reserva;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainAdminDeleteReserva extends BaseActivity {

    private TableLayout tabla;
    private int fila, colu = 1;
    String fechaseleccionada;

    int vecesBuscar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_reserva);

        final CalendarView calendario = findViewById(R.id.calendarioAdminEliminarReserva);
        final Button btnBuscar = (Button) findViewById(R.id.btnBuscar);
        final Button btnAceptar =  (Button) findViewById(R.id.btnAceptar);
        tabla = (TableLayout)findViewById(R.id.tablaAdmDelRev);

        inicializarFechaDefecto();

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fechaseleccionada = dayOfMonth + "/" + month + "/" + year + "";
            }
        });

        btnBuscar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comprobarFechaCalendario(fechaseleccionada))
                {
                    if(vecesBuscar == 0) {
                        rellenarTabla(null, null);
                        vecesBuscar++;
                    }
                    else {
                        refrescarTabla();
                    }
                }
                else
                    Snackbar.make(findViewById(R.id.btnBuscar), R.string.error_fecha_calendario, Snackbar.LENGTH_SHORT).show();
            }
        }));

        btnAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
            }
        }));
    }

    //TODO este método No debería estar aquí pero lo pongo mientras no tenemos BBDD (:
    private void rellenarTabla(LocalDate fecha, String hora){

        List<Reserva> lista = new ArrayList();
        Reserva r1 = new Reserva("Pablo Suarez", "13:00", "9/11/2020", "676452158");
        Reserva r2 = new Reserva("Pedro Lopez", "14:00", "9/11/2020", "676454155");
        Reserva r3 = new Reserva("Juan García", "21:00", "9/11/2020", "618452151");
        Reserva r4 = new Reserva("Luis Brasas", "22:00", "9/11/2020", "677499157");

        lista.add(r1);
        lista.add(r2);
        lista.add(r3);
        lista.add(r4);

        for(int i = 0; i<lista.size(); i++){
            final int fila = i;

            TableRow f = new TableRow(this);
            f.setId(i+100);

            TextView col1 = new TextView(this);
            col1.setId(200+i);
            col1.setText(lista.get(i).getNombreUsuario() + "  ");

            TextView col2 = new TextView(this);
            col2.setId(300+i);
            col2.setText(lista.get(i).getHora() + "  ");

            TextView col3 = new TextView(this);
            col3.setId(400+i);
            col3.setText(lista.get(i).getTelef() + "  ");

            Button button = new Button(this);
            button.setId(500+i);
            button.setText("Borrar");

            f.addView(col1);
            f.addView(col2);
            f.addView(col3);
            f.addView(button);

            button.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Eliminar la fila correspondiente.
                    int usuario = lista.get(fila).getId_usuario();


                    System.out.println(usuario);
                    //Aquí es cuando se haría el método para eliminar la BDD.
                    //Se coge como dato lo que se desee y se elimina de la BDD.


                    //y se actualizaría la tabla rellenandola de nuevo.
                    refrescarTabla();
                }
            }));


            tabla.addView(f);
            colu = colu + 4;
        }
    }

    private void refrescarTabla()
    {
        int count = tabla.getChildCount();
        for (int i = 1; i < count; i++) {
            View child = tabla.getChildAt(i);
            if (child instanceof TableRow) ((ViewGroup) child).removeAllViews();
        }
        rellenarTabla(null,null);
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

    private void inicializarFechaDefecto()
    {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        fechaseleccionada = mDay + "/" + mMonth + "/" + mYear + "";
    }
}
