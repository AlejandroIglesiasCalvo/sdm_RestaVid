package com.example.yopido.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * MyDHelper
 */
public class MyDBHelper extends SQLiteOpenHelper {

    /**
     * Nombre y version de la base de datos
     */
    private static final String DATABASE_NAME = "YoPido.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * Nombre de la tabla Usuario
     */
    public static final String TABLA_USUARIO = "tabla_usuario";

    public static final String COLUMNA_ID_USUARIO = "id_usuario";
    public static final String COLUMNA_NOMBRE_USUARIO = "nombre_usuario";
    public static final String COLUMNA_APELLIDOS_USUARIO = "apellidos_usuario";
    public static final String COLUMNA_EMAIL_USUARIO = "email_usuario";
    public static final String COLUMNA_CONTRASEÑA_USUARIO = "contraseña_usuario";
    public static final String COLUMNA_POLITICA_DATOS = "politca_usuario";


    /**
     * Nombre de la tabla resevas
     */
    public static final String TABLA_RESERVAS = "tabla_peliculas_reparto";

    public static final String COLUMNA_ID_RESERVA = "id_reserva";
    public static final String COLUMNA_NUMERO_RESERVA = "numero_reserva";
    public static final String COLUMNA_INICIO_RESERVA = "inicio_reserva";
    public static final String COLUMNA_FIN_RESERVA = "fin_reserva";
    public static final String  COLUMNA_ID_USUARIO_RESERVA="id_usuario_reserva";


    /**
     * Script para crear la base datos en SQL
     */
    private static final String CREATE_TABLA_USUARIO = "create table if not exists " + TABLA_USUARIO
            + "( " +
            COLUMNA_ID_USUARIO + " " + "integer primary key, " +
            COLUMNA_NOMBRE_USUARIO + " text not null, " +
            COLUMNA_APELLIDOS_USUARIO + " text not null, " +
            COLUMNA_EMAIL_USUARIO + " text not null, " +
            COLUMNA_CONTRASEÑA_USUARIO + " text not null, " +
            COLUMNA_POLITICA_DATOS + " text not null, " +
            ")" ;

    private static final String CREATE_TABLA_RESERVAS = "create table if not exists " + TABLA_RESERVAS
            + "( " +
            COLUMNA_ID_RESERVA + " " + "integer primary key, " +
            COLUMNA_ID_USUARIO_RESERVA + " " + "integer not null, " +
            COLUMNA_NUMERO_RESERVA + " integer, " +
            COLUMNA_INICIO_RESERVA + " text not null, " +
            COLUMNA_FIN_RESERVA + " text not null, "
            + ")";


    /**
     * Script para borrar la base de datos (SQL)
     */
    private static final String DATABASE_DROP_TABLA_USUARIO = "DROP TABLE IF EXISTS " + TABLA_USUARIO;
    private static final String DATABASE_DROP_TABLA_RESERVAS = "DROP TABLE IF EXISTS " + TABLA_RESERVAS;


    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //invocamos execSQL pq no devuelve ningún tipo de dataset
        db.execSQL(CREATE_TABLA_USUARIO);
        db.execSQL(CREATE_TABLA_RESERVAS);
        Log.i("ONCREATE", "EJECUTO CREACION");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DATABASE_DROP_TABLA_USUARIO);
        db.execSQL(DATABASE_DROP_TABLA_RESERVAS);
        this.onCreate(db);
    }
}
