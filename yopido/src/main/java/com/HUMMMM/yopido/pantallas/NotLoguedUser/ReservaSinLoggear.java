package com.HUMMMM.yopido.pantallas.NotLoguedUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;
import com.HUMMMM.yopido.pantallas.MainReservaDirecta;

public class ReservaSinLoggear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_directa);

        Button btnReservar;

        btnReservar = (Button) findViewById(R.id.buttonAceptar);
        btnReservar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class);
            }
        }));
    }

}
