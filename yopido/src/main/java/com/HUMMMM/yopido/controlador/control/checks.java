package com.HUMMMM.yopido.controlador.control;

import android.widget.EditText;
import android.widget.TextView;

import com.HUMMMM.yopido.datos.UsuariosDataSource;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checks {

    private static UsuariosDataSource uds;

    private final static String CORREO_ADMIN = "admin@restavid.es";
    private final static String CONTRA_ADMIN = "adminrestavid";
    private final static String PATRON_CONTRA = "^.+@.+\\..+$";
    private final static int MIN_LENGTH_CONTRA = 6;
    private final static int MAX_LENGTH_CONTRA = 16;

    public static boolean comprobarIniciarSesion(EditText c, EditText con) {

        String correo = String.valueOf(c.getText());
        String contra = String.valueOf(con.getText());

        if (!isEmailValid(correo) || !isValidPassword(contra)) {
            return false;
        }
        else
            return true;
    }

    public static boolean isAdmin(EditText texto, EditText contra1) {
        String correo = String.valueOf(texto.getText());

        if(correo.equals(CORREO_ADMIN) && isPasswordAdminValid(contra1))
            return true;
        else return false;
    }

    /**
     * @param contra contraseña
     * @return true si essta correcto, false si no existe o esta mal escrita
     */
    public static boolean isValidPassword(String contra) {
        //TODO: Aqui deberiamos comprobar que existe en el modelo
        if(contra.isEmpty() || contra.length() < MIN_LENGTH_CONTRA || contra.length() > MAX_LENGTH_CONTRA){
            return false;
        }
        else
            return true;
    }

    /**
     * method is used for checking valid email id format.
     *
     * @param email email
     * @return boolean true for valid false for invalid
     */
    public static boolean isEmailValid(String email) {
        boolean valido = false;

        Pattern pattern = Pattern.compile(PATRON_CONTRA);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()){
            valido = true;
        }
        return valido;
    }

    /**
     *
     * @param textos cosas a comprobar
     * @return true o false
     */
    public static boolean camposRellenos(EditText... textos)
    {
        for(EditText et : textos)
        if(String.valueOf(et.getText()).length() ==0)
            return false;
        return true;
    }

    /**
     *
     * @param texto editText
     * @return true o false
     */
    public static boolean existeEmailEnBDD(EditText texto)
    {
        String email = String.valueOf(texto.getText());

        if(uds.existeEnBDD(email))
            return true;
        else
            return false;
    }

    /**
     *
     * @param texto editText
     * @return true o false
     */
    public static boolean isPasswordAdminValid(EditText texto)
    {
        String contra = String.valueOf(texto.getText());

        if(contra.equals(CONTRA_ADMIN))
            return true;
        else
            return false;
    }

    public static boolean comprobarFechaCalendario(String fechaseleccionada) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        String[] fechaAComprobar = fechaseleccionada.split("/");
        int compDia = Integer.parseInt(fechaAComprobar[0]);
        int compMes = Integer.parseInt(fechaAComprobar[1]);
        int compAnio = Integer.parseInt(fechaAComprobar[2]);


        if (compDia <= mDay || compMes < mMonth || compAnio < mYear) {
            return false;
        }

        return true;
    }
}