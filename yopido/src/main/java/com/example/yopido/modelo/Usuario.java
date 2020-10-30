package com.example.yopido.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private int id;
    private String Nombre;
    private String Apellidos;
    private String Email;
    private String contrseña;
    private boolean politicaDeProteccionDeDatos = false;

    public Usuario(int id, String nombre, String apellidos, String email, String contrseña, boolean politicaDeProteccionDeDatos) {
        this.id = id;
        Nombre = nombre;
        Apellidos = apellidos;
        Email = email;
        this.contrseña = contrseña;
        this.politicaDeProteccionDeDatos = politicaDeProteccionDeDatos;
    }

    protected Usuario(Parcel in) {
        id = in.readInt();
        Nombre = in.readString();
        Apellidos = in.readString();
        Email = in.readString();
        contrseña = in.readString();
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContrseña() {
        return contrseña;
    }

    public void setContrseña(String contrseña) {
        this.contrseña = contrseña;
    }

    public boolean isPoliticaDeProteccionDeDatos() {
        return politicaDeProteccionDeDatos;
    }

    public void setPoliticaDeProteccionDeDatos(boolean politicaDeProteccionDeDatos) {
        this.politicaDeProteccionDeDatos = politicaDeProteccionDeDatos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(Nombre);
        dest.writeString(Apellidos);
        dest.writeString(Email);
        dest.writeString(contrseña);
        dest.writeBoolean(politicaDeProteccionDeDatos);
    }
}
