package com.HUMMMM.yopido.controlador.control;

import android.widget.EditText;
import android.widget.TextView;

import com.HUMMMM.yopido.datos.UsuariosDataSource;

import org.jetbrains.annotations.NotNull;

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

        System.out.println("correo: " + correo + ", contra: " + String.valueOf(contra1.getText()));

        if(correo.equals(CORREO_ADMIN) && isPasswordAdminValid(contra1))
            return true;
        else return false;
    }

    /**
     * @param contra
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
     * @param email
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
     * @param textos
     * @return
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
     * @param texto
     * @return
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
     * @param texto
     * @return
     */
    public static boolean isPasswordAdminValid(EditText texto)
    {
        String contra = String.valueOf(texto.getText());

        if(contra.equals(CONTRA_ADMIN))
            return true;
        else
            return false;
    }
}