package com.HUMMMM.yopido.pantallas.loguedUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;

public class ReservarLogueado extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_logueado);

        Button btnAceptar;

        btnAceptar = (Button) findViewById(R.id.buttonAceptar);
        btnAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class);
            }
        }));
    }

}
