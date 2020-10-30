package com.example.yopido.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.yopido.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDataSource {
    private SQLiteDatabase database;
    /**
     * Referencia al helper que se encarga de crear y actualizar la base de datos.
     */
    private MyDBHelper dbHelper;
    /**
     * Columnas de la tabla
     */
    private final String[] allColumns = {MyDBHelper.COLUMNA_ID_USUARIO, MyDBHelper.COLUMNA_NOMBRE_USUARIO,
            MyDBHelper.COLUMNA_APELLIDOS_USUARIO, MyDBHelper.COLUMNA_EMAIL_USUARIO, MyDBHelper.COLUMNA_CONTRASEÑA_USUARIO,
            MyDBHelper.COLUMNA_POLITICA_DATOS};

    /**
     * Constructor.
     *
     * @param context
     */
    public UsuariosDataSource(Context context) {
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
     * @param usuarioInsert
     * @return
     */
    public long createUsuario(Usuario usuarioInsert) {
        // Establecemos los valores que se insertaran
        ContentValues values = new ContentValues();

        values.put(MyDBHelper.COLUMNA_ID_USUARIO, usuarioInsert.getId());
        values.put(MyDBHelper.COLUMNA_NOMBRE_USUARIO, usuarioInsert.getNombre());
        values.put(MyDBHelper.COLUMNA_APELLIDOS_USUARIO, usuarioInsert.getApellidos());
        values.put(MyDBHelper.COLUMNA_EMAIL_USUARIO, usuarioInsert.getEmail());
        values.put(MyDBHelper.COLUMNA_CONTRASEÑA_USUARIO, usuarioInsert.getContrseña());
        values.put(MyDBHelper.COLUMNA_POLITICA_DATOS, usuarioInsert.isPoliticaDeProteccionDeDatos());
        // Insertamos la valoracion
        long insertId =
                database.insert(MyDBHelper.TABLA_USUARIO, null, values);
        return insertId;
    }

    /**
     * Obtiene todas las valoraciones andadidas por los usuarios.
     *
     * @return Lista de objetos de tipo Pelicula
     */
    public List<Usuario> getAllUsers() {
        // Lista que almacenara el resultado
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        //hacemos una query porque queremos devolver un cursor

        Cursor cursor = database.query(MyDBHelper.TABLA_USUARIO, allColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            final Usuario user = new Usuario();
            user.setId(cursor.getInt(0));
            user.setNombre(cursor.getString(1));
            user.setApellidos(cursor.getString(2));
            user.setEmail(cursor.getString(3));
            user.setContrseña(cursor.getString(4));
            Boolean politica;
            if (cursor.getString(5).equals("SI")) {
                politica = true;
            } else {
                politica = false;
            }
            user.setPoliticaDeProteccionDeDatos(politica);
            usuarioList.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        // Una vez obtenidos todos los datos y cerrado el cursor, devolvemos la
        // lista.

        return usuarioList;
    }


    /**
     * Obtiene todas las valoraciones andadidas por los usuarios con el filtro introducido en el SQL.
     *
     * @return SE SUPONE QUE UN SOLO USUARIO, ES LISTA POR SI LAS MOSCAS
     */
    public List<Usuario> getUserByID(String filtro) {
        // Lista que almacenara el resultado
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        //hacemos una query porque queremos devolver un cursor

        Cursor cursor = database.rawQuery("Select * " +
                " FROM " + MyDBHelper.TABLA_USUARIO +
                " WHERE " + MyDBHelper.TABLA_USUARIO + "." + MyDBHelper.COLUMNA_ID_USUARIO + " = \"" + filtro + "\"", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            final Usuario user = new Usuario();
            user.setId(cursor.getInt(0));
            user.setNombre(cursor.getString(1));
            user.setApellidos(cursor.getString(2));
            user.setEmail(cursor.getString(3));
            user.setContrseña(cursor.getString(4));
            Boolean politica;
            if (cursor.getString(5).equals("SI")) {
                politica = true;
            } else {
                politica = false;
            }
            user.setPoliticaDeProteccionDeDatos(politica);
            usuarioList.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        // Una vez obtenidos todos los datos y cerrado el cursor, devolvemos la
        // lista.
        return usuarioList;
    }

}
