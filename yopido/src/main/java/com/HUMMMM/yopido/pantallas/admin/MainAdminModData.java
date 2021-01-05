package com.HUMMMM.yopido.pantallas.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.datos.RestauranteDataSource;
import com.HUMMMM.yopido.pantallas.BaseActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainAdminModData  extends BaseActivity {



    RestauranteDataSource rds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mod_data);

        final Spinner spinnerPersonas = findViewById(R.id.spPersonas_Mod_Data);
        final Spinner spinnerHora = findViewById(R.id.spHora_Mod_Data);
        final CheckBox cerrados = findViewById(R.id.checkBox_cerrados);
        final Button botonAceptar = findViewById(R.id.buttonAceptar_ModData_Admin);


        botonAceptar.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {

                if(cerrados.isSelected())
                    Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.cerrar_restaurante, Snackbar.LENGTH_SHORT).show();
                else
                    //guardarValores(spinnerHora.toString(), spinnerPersonas.toString());
                cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
            }
        });
    }

    private void guardarValores(String hora, String personas)
    {
        rds.setHora(hora);
        rds.setNumberOfUsers(personas);
    }

}