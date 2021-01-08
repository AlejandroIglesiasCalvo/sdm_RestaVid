package com.HUMMMM.yopido.pantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.HUMMMM.yopido.R;
import com.HUMMMM.yopido.controlador.navegacion.cambiarDeClase;
import com.HUMMMM.yopido.pantallas.admin.MainActivityAdmin;
import com.HUMMMM.yopido.pantallas.loguedUser.MainMenuLoggeado;

public class FinalizarPedido extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_pedido);
        String correo = getIntent().getStringExtra("correo");
        Button btnAceptar;

        btnAceptar = (Button) findViewById(R.id.btnBuscar);
        btnAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correo.equals("SINCORREO@SINCORREO.COM")) {
                    cambiarDeClase.MoverA(v.getContext(), MainActivity.class);
                }
                else if (correo.equals("admin@restavid.es")){
                    cambiarDeClase.MoverA(v.getContext(), MainActivityAdmin.class);
                }
                else {
                    cambiarDeClase.MoverA(v.getContext(), MainMenuLoggeado.class, correo);
                }
            }
        }));
    }
}
