package com.HUMMMM.yopido.modelo;

import android.widget.Button;

public class ElementoTabla {

    Reserva s;
    Button b;
    int fila;

    public ElementoTabla(Reserva s, Button b, int fila)
    {
        this.s=s;
        this.b=b;
        this.fila=fila;
    }

    public Button getBoton()
    {
        return b;
    }
}
