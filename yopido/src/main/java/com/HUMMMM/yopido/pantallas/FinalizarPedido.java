package com.HUMMMM.yopido.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.HUMMMM.yopido.R;

public class FinalizarPedido extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_pedido);

        Button btnAceptar;

        btnAceptar = (Button) findViewById(R.id.btnBuscar);
        btnAceptar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }));
    }
}
