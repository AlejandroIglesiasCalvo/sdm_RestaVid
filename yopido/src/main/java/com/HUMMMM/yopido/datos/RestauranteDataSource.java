package com.HUMMMM.yopido.datos;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RestauranteDataSource {

    private SQLiteDatabase database;
    /**
     * Referencia al helper que se encarga de crear y actualizar la base de datos.
     */
    private MyDBHelper dbHelper;
    /**
     * Columnas de la tabla
     */
    private final String[] allColumns = {
            MyDBHelper.COLUMNA_ID_RESTAURANTE,
            MyDBHelper.COLUMNA_NUM_PERSONAS,
            MyDBHelper.COLUMNA_HORA,
            MyDBHelper.COLUMNA_CERRADOS};

    /**
     * Constructor.
     *
     * @param context
     */
    public RestauranteDataSource(Context context) {
        //el último parámetro es la versión
        dbHelper = new MyDBHelper(context, null, null, 1);
    }

    /**
     * Abre una conexion para escritura con la base de datos.
     * Esto lo hace a traves del helper con la llamada a getWritableDatabase. Si la base de
     * datos no esta creada, el helper se encargara de llamar a onCreate
     *
     * @throws SQLException
     */
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

}
