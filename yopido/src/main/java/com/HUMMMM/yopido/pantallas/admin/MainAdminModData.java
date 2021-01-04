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

    final Spinner spinnerPersonas = findViewById(R.id.spPersonas_Mod_Data);
    final Spinner spinnerHora = findViewById(R.id.spHora_Mod_Data);
    final CheckBox cerrados = findViewById(R.id.checkBox_cerrados);
    final Button botonAceptar = findViewById(R.id.buttonAceptar_ModData_Admin);

    RestauranteDataSource rds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mod_data);


        botonAceptar.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {

                if(cerrados.isSelected())
                    Snackbar.make(findViewById(R.id.button_Aceptar_Reserva_Admin), R.string.cerrar_restaurante, Snackbar.LENGTH_SHORT).show();
                else
                    guardarValores();
                cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
            }
        });
    }

    private void guardarValores()
    {
        rds.setHora(spinnerHora.getSelectedItem().toString());
        rds.setNumberOfUsers(spinnerPersonas.getSelectedItem().toString());
    }

}