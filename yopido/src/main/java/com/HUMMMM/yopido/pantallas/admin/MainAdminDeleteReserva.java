package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.modelo.Reserva;
import com.HUMMMM.yopido.pantallas.BaseActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainAdminDeleteReserva extends BaseActivity {

    private TableLayout tabla;
    private int fila, colu = 1;

    int vecesBuscar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_reserva);

        final Button btnBuscar = (Button) findViewById(R.id.btnBuscar);
        final Button btnAceptar =  (Button) findViewById(R.id.btnAceptar);

        btnBuscar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vecesBuscar==0) {
                    rellenarTabla(null, null);
                    vecesBuscar++;
                }
                else
                    refrescarTabla();
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

        tabla = (TableLayout)findViewById(R.id.tablaAdmDelRev);

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
}
