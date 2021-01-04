package com.HUMMMM.yopido.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Reserva extends RealmObject implements Parcelable {
    @PrimaryKey
    private int _id;
    private int id_usuario;
    private String nombreUsuario;
    private String telef;
    private int NumeroDePersonas;
    //TODO poner fecha como LocalDate
    private String fecha;
    private String hora;
    private int Inicio;
    private  int Fin;

public Reserva (){}

    public Reserva(int _id, int id_usuario, int numeroDePersonas, int inicio, int fin) {
        this._id = _id;
        this.id_usuario=id_usuario;
        NumeroDePersonas = numeroDePersonas;
        Inicio = inicio;
        Fin = fin;
    }

    public Reserva(String nombreUsuario, String hora, String fecha, String telef) {
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.hora = hora;
        this.telef = telef;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    protected Reserva(Parcel in) {
        _id = in.readInt();
        NumeroDePersonas = in.readInt();
        Inicio = in.readInt();
        Fin = in.readInt();
        id_usuario=in.readInt();
        nombreUsuario=in.readString();
        fecha=in.readString();
        hora = in.readString();
        telef = in.readString();
    }

    public static final Creator<Reserva> CREATOR = new Creator<Reserva>() {
        @Override
        public Reserva createFromParcel(Parcel in) {
            return new Reserva(in);
        }

        @Override
        public Reserva[] newArray(int size) {
            return new Reserva[size];
        }
    };

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getNumeroDePersonas() {
        return NumeroDePersonas;
    }

    public void setNumeroDePersonas(int numeroDePersonas) {
        NumeroDePersonas = numeroDePersonas;
    }

    public int getInicio() {
        return Inicio;
    }

    public void setInicio(int inicio) {
        Inicio = inicio;
    }

    public int getFin() {
        return Fin;
    }

    public void setFin(int fin) {
        Fin = fin;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeInt(NumeroDePersonas);
        dest.writeInt(Inicio);
        dest.writeInt(Fin);
        dest.writeInt(id_usuario);
    }
}
