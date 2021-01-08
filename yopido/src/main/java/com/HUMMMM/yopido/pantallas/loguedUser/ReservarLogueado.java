package com.HUMMMM.yopido.pantallas.loguedUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;
import com.google.firebase.analytics.FirebaseAnalytics;

public class ReservarLogueado extends BaseActivity {
    private FireBase fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_logueado);
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");
        //Analytics
        FirebaseAnalytics fa = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("Mensaje", "Quiere reservar");
        fa.logEvent("Reserva", bundle);
        fb = new FireBase();
        Button btnAceptar;
        EditText nombre = findViewById(R.id.editTextTextNombre);
        btnAceptar = (Button) findViewById(R.id.buttonAceptar);
        Spinner spnPersonas= (Spinner)findViewById(R.id.spPersonas);
        Spinner spnHoras= (Spinner)findViewById(R.id.spHora);
        CalendarView calendar=(CalendarView) findViewById(R.id.calendarReserva);
        btnAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO validar campos y otra reserva
                fb.guardarReserva(correo,nombre,telefono,spnPersonas,calendar,spnHoras);
                cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class);
            }
        }));
    }

}
