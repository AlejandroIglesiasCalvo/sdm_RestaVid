package com.HUMMMM.yopido.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Reserva implements Parcelable {
    private int id;
    private int id_usuario;
    private int NumeroDePersonas;
    private int Inicio;
    private  int Fin;
public Reserva (){}
    public Reserva(int id, int id_usuario, int numeroDePersonas, int inicio, int fin) {
        this.id = id;
        this.id_usuario=id_usuario;
        NumeroDePersonas = numeroDePersonas;
        Inicio = inicio;
        Fin = fin;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    protected Reserva(Parcel in) {
        id = in.readInt();
        NumeroDePersonas = in.readInt();
        Inicio = in.readInt();
        Fin = in.readInt();
        id_usuario=in.readInt();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(NumeroDePersonas);
        dest.writeInt(Inicio);
        dest.writeInt(Fin);
        dest.writeInt(id_usuario);
    }
}
