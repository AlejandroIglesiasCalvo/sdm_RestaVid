package com.HUMMMM.yopido.controlador.control;

import org.jetbrains.annotations.NotNull;

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
        if(contra.isEmpty() || contra.length() < 6 || contra.length() > 16){
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

        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);

        //Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})$");
        //Matcher mEmail = patronEmail.matcher(email.toLowerCase());

        if (matcher.matches()){
            valido = true;
        }
        return valido;
    }


}