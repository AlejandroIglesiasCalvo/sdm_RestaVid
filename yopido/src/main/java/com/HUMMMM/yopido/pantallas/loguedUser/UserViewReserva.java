package com.HUMMMM.yopido.pantallas.loguedUser;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.modelo.Reserva;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.type.Date;

import java.util.ArrayList;
import java.util.List;

public class UserViewReserva extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservas);
        String correo = getIntent().getStringExtra("correo");

        FirebaseFirestore.getInstance().collection("reservas")
                .whereEqualTo("correo", correo)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            System.out.println("Listen failed. " + e);
                            return;
                        }
                        List<DocumentSnapshot> docs = snapshots.getDocuments();
                        List<List> reservas = new ArrayList<List>();
                        for (DocumentSnapshot a : docs) {
                           List r =new ArrayList<String>();
                           if(checks.comprobarReservaActual(a.getString("fecha"))) {
                               r.add(a.getString("hora"));
                               r.add(a.getString("nombre"));
                               r.add(a.getString("fecha").toString());
                               r.add(a.getString("telefono"));
                               r.add(Integer.parseInt(a.getString("numeroPersonas")));
                               reservas.add(r);
                           }
                        }
                        rellenarTabla(reservas);
                    }
                });
    }


    private void rellenarTabla(List<List> lista) {
        TableLayout tabla;
        int fila, colu = 1;
        tabla = (TableLayout) findViewById(R.id.tablaAdmDelRev);
        for (int i = 0; i < lista.size(); i++) {
            TableRow f = new TableRow(this);
            f.setId(i + 100);

            TextView col1 = new TextView(this);
            col1.setId(200 + i);
            col1.setText(lista.get(i).get(0) + "  ");


            TextView col2 = new TextView(this);
            col2.setId(300 + i);
            col2.setText(lista.get(i).get(1) + "  ");

            TextView col3 = new TextView(this);
            col3.setId(400 + i);
            col3.setText(lista.get(i).get(2) + "  ");

            TextView col4 = new TextView(this);
            col4.setId(500 + i);
            col4.setText(lista.get(i).get(3) + "  ");

            TextView col5 = new TextView(this);
            col5.setId(600 + i);
            col5.setText(lista.get(i).get(4) + "  ");

            f.addView(col1);
            f.addView(col2);
            f.addView(col3);
            f.addView(col4);
            f.addView(col5);
            tabla.addView(f);
            colu = colu + 5;
        }

    }

}
