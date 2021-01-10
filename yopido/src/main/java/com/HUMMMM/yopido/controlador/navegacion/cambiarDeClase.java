package com.HUMMMM.yopido.controlador.navegacion;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import javax.annotation.Nullable;

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
    public static void MoverA(Context mContext, Class clase, String correo) {
        Intent intent = new Intent(mContext, clase);
        intent.putExtra("correo",correo);
        mContext.startActivity(intent);
    }
    public static void MoverA(Context mContext, Class clase, String correo, String telefono) {
        Intent intent = new Intent(mContext, clase);
        intent.putExtra("correo",correo);
        intent.putExtra("telefono",telefono);
        mContext.startActivity(intent);
    }

    public static void MoverA(Context mContext, Class clase, String correo, String telefono, String h1) {
        Intent intent = new Intent(mContext, clase);
        intent.putExtra("correo",correo);
        intent.putExtra("telefono",telefono);
        intent.putExtra("h1",h1);
        mContext.startActivity(intent);
    }

    public static void MoverA(Context mContext, Class clase, String correo, String telefono, String h1, String h2) {
        Intent intent = new Intent(mContext, clase);
        intent.putExtra("correo",correo);
        intent.putExtra("telefono",telefono);
        intent.putExtra("h1", h1);
        intent.putExtra("h2", h2);
        mContext.startActivity(intent);
    }

    public static void MoverA(Context mContext, Class clase, String correo, String telefono, String h1, String h2, String mxp) {
        Intent intent = new Intent(mContext, clase);
        intent.putExtra("correo",correo);
        intent.putExtra("telefono",telefono);
        intent.putExtra("h1", h1);
        intent.putExtra("h2", h2);
        intent.putExtra("mxp", mxp);
        mContext.startActivity(intent);
    }

}
