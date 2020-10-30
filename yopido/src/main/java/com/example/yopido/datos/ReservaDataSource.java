package com.example.yopido.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.yopido.modelo.Reserva;
import com.example.yopido.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ReservaDataSource {
    private SQLiteDatabase database;
    /**
     * Referencia al helper que se encarga de crear y actualizar la base de datos.
     */
    private MyDBHelper dbHelper;
    /**
     * Columnas de la tabla
     */
    private final String[] allColumns = {MyDBHelper.COLUMNA_ID_RESERVA, MyDBHelper.COLUMNA_NUMERO_RESERVA,
            MyDBHelper.COLUMNA_INICIO_RESERVA, MyDBHelper.COLUMNA_FIN_RESERVA};

    /**
     * Constructor.
     *
     * @param context
     */
    public ReservaDataSource(Context context) {
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

    /**
     * Cierra la conexion con la base de datos
     */
    public void close() {
        dbHelper.close();
    }

    /**
     * Recibe la película y crea el registro en la base de datos.
     *
     * @param reservaInsert
     * @return
     */
    public long createReserva(Reserva reservaInsert) {
        // Establecemos los valores que se insertaran
        ContentValues values = new ContentValues();

        values.put(MyDBHelper.COLUMNA_ID_RESERVA, reservaInsert.getId());
        values.put(MyDBHelper.COLUMNA_NUMERO_RESERVA, reservaInsert.getNumeroDePersonas());
        values.put(MyDBHelper.COLUMNA_INICIO_RESERVA, reservaInsert.getInicio());
        values.put(MyDBHelper.COLUMNA_FIN_RESERVA, reservaInsert.getFin());

        // Insertamos la valoracion
        long insertId =
                database.insert(MyDBHelper.TABLA_RESERVAS, null, values);
        return insertId;
    }

    /**
     * Obtiene todas las valoraciones andadidas por los usuarios.
     *
     * @return Lista de objetos de tipo Pelicula
     */
    public List<Reserva> getAllReservas() {
        // Lista que almacenara el resultado
        List<Reserva> reservasList = new ArrayList<Reserva>();
        //hacemos una query porque queremos devolver un cursor

        Cursor cursor = database.query(MyDBHelper.TABLA_USUARIO, allColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            final Reserva reserva = new Reserva();
            reserva.setId(cursor.getInt(0));
            reserva.setNumeroDePersonas(cursor.getInt(1));
            reserva.setInicio(cursor.getInt(2));
            reserva.setFin(cursor.getInt(3));
            reservasList.add(reserva);
            cursor.moveToNext();
        }
        cursor.close();
        // Una vez obtenidos todos los datos y cerrado el cursor, devolvemos la
        // lista.

        return reservasList;
    }


    /**
     * Obtiene todas las valoraciones andadidas por los usuarios con el filtro introducido en el SQL.
     *
     * @return SE SUPONE QUE UN SOLO USUARIO, ES LISTA POR SI LAS MOSCAS
     */
    public List<Reserva> getReservaByID(String filtro) {
        // Lista que almacenara el resultado
        List<Reserva> reservaList = new ArrayList<Reserva>();
        //hacemos una query porque queremos devolver un cursor

        Cursor cursor = database.rawQuery("Select * " +
                " FROM " + MyDBHelper.TABLA_RESERVAS +
                " WHERE " + MyDBHelper.TABLA_RESERVAS + "." + MyDBHelper.COLUMNA_ID_RESERVA + " = \"" + filtro + "\"", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            final Reserva reserva = new Reserva();
            reserva.setId(cursor.getInt(0));
            reserva.setNumeroDePersonas(cursor.getInt(1));
            reserva.setInicio(cursor.getInt(2));
            reserva.setFin(cursor.getInt(3));
            reservaList.add(reserva);
            cursor.moveToNext();
        }
        cursor.close();
        // Una vez obtenidos todos los datos y cerrado el cursor, devolvemos la
        // lista.
        return reservaList;
    }
}
