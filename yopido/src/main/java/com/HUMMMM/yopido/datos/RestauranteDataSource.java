package com.HUMMMM.yopido.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.HUMMMM.yopido.modelo.Usuario;

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
     * @param context el contexto
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
     * @throws SQLException excepcion
     */
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }


    /**
     * Establece la nueva hora
     *
     * @param nuevaHora la nueva hora
     * @return el id
     */
    public long setHora(String nuevaHora) {
        long insertId;
        // Establecemos los valores que se insertaran
        ContentValues values = new ContentValues();

        values.put(MyDBHelper.COLUMNA_HORA, nuevaHora);
        // Insertamos la valoracion
        insertId =
                database.insert(MyDBHelper.TABLA_RESTAURANTE, null, values);
        return insertId;
    }


    /**
     * Establece nuevo numero de personas por mesa
     *
     * @param numeroComensales numero personas
     * @return el id
     */
    public long setNumberOfUsers(int numeroComensales) {

        long insertId;
        // Establecemos los valores que se insertaran
        ContentValues values = new ContentValues();

        values.put(MyDBHelper.COLUMNA_NUM_PERSONAS, numeroComensales);
        // Insertamos la valoracion
        insertId =
                database.insert(MyDBHelper.TABLA_RESTAURANTE, null, values);
        return insertId;
    }

    /**
     * Establece si esta cerrado o no el local
     *
     * @param cerrados si se marca como cerrado el restaurante
     * @return si esta cerrado o no
     */
    public long setNumberOfUsers(boolean cerrados) {
        long insertId;
        // Establecemos los valores que se insertaran
        ContentValues values = new ContentValues();

        if(cerrados)
            values.put(MyDBHelper.COLUMNA_CERRADOS, "SI");
        else
            values.put(MyDBHelper.COLUMNA_CERRADOS, "NO");

        // Insertamos la valoracion
        insertId =
                database.insert(MyDBHelper.TABLA_RESTAURANTE, null, values);
        return insertId;
    }


    // ------------ OBTENEMOS VALORES DE LAS RESTRICCIONES
    /**
     * Obtener la nueva hora
     *
     * @return La hora
     */
    public String getHora() {

        String hora;

        Cursor cursor = database.rawQuery("Select " + MyDBHelper.COLUMNA_HORA +
                " FROM " + MyDBHelper.TABLA_RESTAURANTE +
                " WHERE " + MyDBHelper.TABLA_RESTAURANTE+ "." + MyDBHelper.COLUMNA_ID_USUARIO + " = \"" + 1 + "\"", null);

        cursor.moveToFirst();

        hora = cursor.getString(1);
        cursor.close();
        return hora;
    }

    /**
     * Obtener numero de personas
     *
     * @return La hora
     */
    public String getPersonas() {

        String personas;

        Cursor cursor = database.rawQuery("Select " + MyDBHelper.COLUMNA_NUM_PERSONAS +
                " FROM " + MyDBHelper.TABLA_RESTAURANTE +
                " WHERE " + MyDBHelper.TABLA_RESTAURANTE+ "." + MyDBHelper.COLUMNA_ID_USUARIO + " = \"" + 1 + "\"", null);

        cursor.moveToFirst();

        personas = cursor.getString(2);
        cursor.close();
        return personas;
    }

    /**
     * Obtener si esta cerrado o no el restaurante
     *
     * @return cerrado o no
     */
    public boolean isCerrado() {

        String cerrado;

        Cursor cursor = database.rawQuery("Select " + MyDBHelper.COLUMNA_NUM_PERSONAS +
                " FROM " + MyDBHelper.TABLA_RESTAURANTE +
                " WHERE " + MyDBHelper.TABLA_RESTAURANTE+ "." + MyDBHelper.COLUMNA_ID_USUARIO + " = \"" + 1 + "\"", null);

        cursor.moveToFirst();

        cerrado = cursor.getString(3);
        cursor.close();

        if(cerrado.equals("SI"))
            return true;
        return false;
    }

}
