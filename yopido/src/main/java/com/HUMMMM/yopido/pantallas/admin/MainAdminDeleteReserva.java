package com.HUMMMM.yopido.pantallas.admin;

import android.icu.util.LocaleData;
import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_reserva);

        // --- activity_admin_delete_reserva
        Button btnBuscar;
        btnBuscar = (Button) findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rellenarTabla(null, null);

                // Se elimina la reserva al usuario si existe el usuario en la BDD.
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
            col3.setText(lista.get(i).getFecha() + "  ");

            TextView col4 = new TextView(this);
            col4.setId(500+i);
            col4.setText(lista.get(i).getTelef() + "  ");

            Button button = new Button(this);
            button.setId(600+i);
            button.setText("Borrar");

            f.addView(col1);
            f.addView(col2);
            f.addView(col3);
            f.addView(col4);
            f.addView(button);
            tabla.addView(f);
            colu = colu + 4;
        }

    }
}
