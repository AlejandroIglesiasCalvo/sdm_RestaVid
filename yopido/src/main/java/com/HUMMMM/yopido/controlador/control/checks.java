package com.HUMMMM.yopido.controlador.control;

import android.content.Context;
import android.icu.util.Calendar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.HUMMMM.yopido.datos.FireBase;
import com.HUMMMM.yopido.datos.UsuariosDataSource;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
     *Busca en google firebase el correo que pretende registrarse
     * @param texto
     * @return si existe si, y si no, no
     */
    public static boolean existeEmailEnBDD(EditText texto)
    {
        String email = String.valueOf(texto.getText());
        FireBase fb = new FireBase();
        fb.buscarUsuario(email);
        return fb.getEstado();
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

    public static void llenarSpinnerHoras(Spinner sp, String horaInicio, String horaFin, Context c){
        String[] inicio = horaInicio.split(":");
        int hi = Integer.valueOf(inicio[0]);
        String[] fin = horaFin.split(":");
        int hf = Integer.valueOf(fin[0]);
        List<String> horario = new ArrayList<>();
        for(int i = hi; i<=hf; i++){
            horario.add(String.valueOf(i) + ":00");
        }
        SpinnerAdapter comboAdapterSql = new ArrayAdapter<>(c, android.R.layout.simple_spinner_dropdown_item, horario);
        sp.setAdapter(comboAdapterSql);
    }

    public static void llenarSpinnerMaxPersonas(Spinner sp, String maxPersonas, Context c){
        int mxp = Integer.valueOf(maxPersonas);
        List<String> personas = new ArrayList<>();
        for(int i = 1; i <= mxp; i++){
           personas.add(String.valueOf(i));
        }
        SpinnerAdapter comboAdapterSql2 = new ArrayAdapter<>(c, android.R.layout.simple_spinner_dropdown_item, personas);
        sp.setAdapter(comboAdapterSql2);
    }

    public static boolean comprobarReservaActual(String fechaseleccionada) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH)+1;
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        String[] fechaAComprobar = fechaseleccionada.split("/");
        int compDia = Integer.parseInt(fechaAComprobar[0]);
        int compMes = Integer.parseInt(fechaAComprobar[1]);
        int compAnio = Integer.parseInt(fechaAComprobar[2]);

        if (compAnio < mYear) {
            return false;
        } else if (compAnio > mYear) {
            return true;
        } else {
            if (compMes < mMonth) {
                return false;
            } else if (compMes > mMonth) {
                return true;
            } else {
                if (compDia < mDay) {
                    return false;
                } else if (compDia >= mDay) {
                    return true;
                }
            }
        }
        return true;
    }
}