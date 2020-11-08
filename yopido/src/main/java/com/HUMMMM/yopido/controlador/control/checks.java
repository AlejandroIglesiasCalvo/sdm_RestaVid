package com.HUMMMM.yopido.controlador.control;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checks {

    public static boolean comprobarIniciarSesion(String correo, String contra) {
        if (!isEmailValid(correo) || !isValidPassword(contra)) {
            return false;
        }
        else
            return true;
    }

    public static boolean isAdmin(String correo) {
        if(correo.equals("admin@restavid.es") )return true;
        else return false;
    }

    /**
     * @param contra
     * @return true si esta correcto, false si no existe o esta mal escrita
     */
    private static boolean isValidPassword(String contra) {
        //TODO: Aqui deberiamos comprobar que existe en el modelo
        return true;
    }

    /**
     * method is used for checking valid email id format.
     *
     * @param email
     * @return boolean true for valid false for invalid
     */
    private static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
