package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;

public class MainReservaDirecta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_directa);
        Button buttonReservaDirectaAceptar;
        Button buttonReservaDirectaCancelar;


        buttonReservaDirectaAceptar = (Button) findViewById(R.id.buttonReservaDirectaAceptar);
        buttonReservaDirectaAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class);
            }
        }));


    }
}