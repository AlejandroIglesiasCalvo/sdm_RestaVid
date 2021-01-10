package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainAdminDeleteReserva extends BaseActivity {

    private TableLayout tabla;
    private int fila, colu = 1;
    private String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_reserva);

        // --- activity_admin_delete_reserva
        Button btnBuscar;
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        EditText telefono = (EditText) findViewById((R.id.editTextTelefono));
        CalendarView calendar = (CalendarView) findViewById(R.id.calendarioAdminEliminarReserva);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fecha = dayOfMonth + "/" + (month + 1) + "/" + year + "";
            }
        });


        btnBuscar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vaciamos la tabla
                FirebaseFirestore.getInstance().collection("reservas")
                        .whereEqualTo("telefono", telefono.getText().toString()).whereEqualTo("fecha", fecha)
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
                                    List r = new ArrayList<String>();
                                    if (checks.comprobarReservaActual(a.getString("fecha"))) {
                                        r.add(a.getString("hora"));
                                        r.add(a.getString("nombre"));
                                        r.add(a.getString("fecha").toString());
                                        r.add(a.getString("telefono"));
                                        r.add(Integer.parseInt(a.getString("numeroPersonas")));
                                        reservas.add(r);
                                    }
                                }
                                rellenarTabla(reservas, telefono.getText().toString());
                            }
                        });
            }
        }));
    }

    //TODO este método No debería estar aquí pero lo pongo mientras no tenemos BBDD (:
    private void rellenarTabla(List<List> lista, String telefono) {
        TableLayout tabla;
        int fila, colu = 1;
        tabla = (TableLayout) findViewById(R.id.tablaAdmDelRev);

        for (int i = 0; i < lista.size(); i++) {
            TableRow f = new TableRow(this);
            f.setId(i + 100);

            TextView col1 = new TextView(this);
            col1.setId(200 + i);
            String hora = lista.get(i).get(0).toString();
            col1.setText(lista.get(i).get(0) + "        ");


            TextView col2 = new TextView(this);
            col2.setId(300 + i);
            col2.setText(lista.get(i).get(1) + "     ");

            TextView col3 = new TextView(this);
            col3.setId(400 + i);
            String fecha = lista.get(i).get(2).toString();
            col3.setText(lista.get(i).get(2) + "    ");

            Button col4 = new Button(this);
            col4.setId(600 + i);
            col4.setText("Eliminar");
            col4.setOnClickListener((v -> {
                FirebaseFirestore.getInstance().collection("reservas")
                        .whereEqualTo("telefono", telefono).whereEqualTo("hora", hora)
                        .whereEqualTo("fecha", fecha)
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot snapshots,
                                                @Nullable FirebaseFirestoreException e) {
                                if (e != null) {
                                    System.out.println("Listen failed. " + e);
                                    return;
                                }
                                //TODO: la lista de documentos sale vacía y debería encontrar mínimo 1
                                List<DocumentSnapshot> docs = snapshots.getDocuments();
                                System.out.println(telefono + col1.getText().toString() + col3.getText().toString());
                                for (DocumentSnapshot a : docs) {
                                    DocumentReference df = a.getReference();
                                    System.out.println("ID: " + a.getId() + "Reference: " + df);
                                    FirebaseFirestore.getInstance().collection("reservas").document(a.getId()).delete();
                                }
                                TableLayout tabla = (TableLayout) findViewById(R.id.tablaAdmDelRev);
                                tabla.removeAllViews();
                            }
                        });
            }));

            f.addView(col1);
            f.addView(col2);
            f.addView(col3);
            f.addView(col4);

            tabla.addView(f);
            colu = colu + 4;
        }

    }
}
