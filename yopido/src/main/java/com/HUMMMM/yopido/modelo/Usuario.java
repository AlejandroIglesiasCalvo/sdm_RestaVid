package com.HUMMMM.yopido.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Usuario implements Parcelable {
    @PrimaryKey
    private int id;
    @Required
    private String email;
    @Required
    private String nombre;
    @Required
    private String apellidos;
    @Required
    private String telefono;
    @Required
    private String contraseña;
    @Required
    private boolean politicaDeProteccionDeDatos = false;

    private List<Integer> reservas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(int id, String email, String nombre, String apellidos, String telefono, String contraseña, boolean politicaDeProteccionDeDatos) {
        this.email = email;
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono=telefono;
        this.contraseña = contraseña;
        this.politicaDeProteccionDeDatos = politicaDeProteccionDeDatos;
    }

    protected Usuario(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        apellidos = in.readString();
        email = in.readString();
        contraseña = in.readString();
        politicaDeProteccionDeDatos = in.readByte() != 0;
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isPoliticaDeProteccionDeDatos() {
        return politicaDeProteccionDeDatos;
    }

    public void setPoliticaDeProteccionDeDatos(boolean politicaDeProteccionDeDatos) {
        this.politicaDeProteccionDeDatos = politicaDeProteccionDeDatos;
    }

    public List<Integer> getReservas() {
        return reservas;
    }

    public void setReservas(List<Integer> reservas) {
        this.reservas = reservas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeString(email);
        dest.writeString(contraseña);
        //TODO arreglar este metodo para la api 24
        //dest.writeBoolean(politicaDeProteccionDeDatos);
    }
}
