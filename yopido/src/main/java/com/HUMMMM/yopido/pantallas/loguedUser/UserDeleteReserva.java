package com.HUMMMM.yopido.pantallas.loguedUser;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.modelo.Reserva;
import com.HUMMMM.yopido.pantallas.BaseActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDeleteReserva extends BaseActivity {

    private TableLayout tabla;
    private int fila, colu = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_reserva);

        rellenarTabla(null,null);
        }


    //TODO este método No debería estar aquí pero lo pongo mientras no tenemos BBDD
    private void rellenarTabla(LocalDate fecha, String hora) {
        tabla = (TableLayout) findViewById(R.id.tablaUserDeleteReserva);
        List<Reserva> lista = new ArrayList();
        Reserva r1 = new Reserva("Pablo Suarez", "13:00", "14/11/2020", "676452158");
        Reserva r2 = new Reserva("Pablo Suarez", "14:00", "16/11/2020", "676452158");
        Reserva r3 = new Reserva("Pablo Suarez", "21:00", "9/12/2020", "676452158");
        Reserva r4 = new Reserva("Pablo Suarez", "22:00", "9/02/2021", "676452158");

        lista.add(r1);
        lista.add(r2);
        lista.add(r3);
        lista.add(r4);

        for (int i = 0; i < lista.size(); i++) {
            TableRow f = new TableRow(this);
            f.setId(i + 100);

            TextView col1 = new TextView(this);
            col1.setId(200 + i);
            col1.setText(lista.get(i).getNombreUsuario() + "  ");


            TextView col2 = new TextView(this);
            col2.setId(300 + i);
            col2.setText(lista.get(i).getHora() + "  ");


            f.addView(col1);
            f.addView(col2);
            tabla.addView(f);
            colu = colu + 2;
        }
    }
}