package com.HUMMMM.yopido.controlador.navegacion;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class cambiarDeClase extends AppCompatActivity {
    /**
     * Este metodo crea una activity cualquiera desde otra
     *
     * @param mContext esto es el contexto de la app. se puede sacar como:
     *                 mContext = this.getApplicationContext();
     *                 v.getContext();
     * @param clase    el nombre de la clase.class, por ejemplo MainRegistro.class
     */
    public static void MoverA(Context mContext, Class clase) {
        Intent intent = new Intent(mContext, clase);
        mContext.startActivity(intent);
    }

}
