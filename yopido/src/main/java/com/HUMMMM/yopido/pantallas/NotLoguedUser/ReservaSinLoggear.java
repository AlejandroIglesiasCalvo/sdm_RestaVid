package com.HUMMMM.yopido.pantallas.NotLoguedUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.control.checks;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.HUMMMM.yopido.pantallas.FinalizarPedido;
import com.HUMMMM.yopido.pantallas.MainReservaDirecta;
import com.google.android.material.snackbar.Snackbar;

public class ReservaSinLoggear extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_directa);

        EditText editTextnombre = findViewById(R.id.editTextTextNombre);
        EditText editTextPhone = findViewById(R.id.editTextPhone);

        Button btnReservar;

        btnReservar = (Button) findViewById(R.id.buttonAceptar);
        btnReservar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checks.camposRellenos(editTextnombre,editTextPhone))
                    cambiarDeClase.MoverA(v.getContext(), FinalizarPedido.class);
                else
                    Snackbar.make(findViewById(R.id.buttonAceptar_AñadirUser_Admin), R.string.error_reserva, Snackbar.LENGTH_SHORT).show();
            }
        }));

    }

}
