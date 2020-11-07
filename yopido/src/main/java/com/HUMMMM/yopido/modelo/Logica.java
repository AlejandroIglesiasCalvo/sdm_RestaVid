package com.HUMMMM.yopido.modelo;

import com.HUMMMM.yopido.datos.ReservaDataSource;
import com.HUMMMM.yopido.datos.UsuariosDataSource;

import java.util.List;

public class Logica {
    private UsuariosDataSource uds;
    private ReservaDataSource rds;
    private Usuario u;
    private Reserva r;

    public Logica() {
    }

    public void addReserva(Reserva reserva) {
        rds.createReserva(reserva);
    }

    public List<Reserva> getTodasLAsReservasDeUnUsuario(Integer id) {
        List<Reserva> reservas = rds.getReservaByIDUsuario(id);
        return reservas;
    }


}
