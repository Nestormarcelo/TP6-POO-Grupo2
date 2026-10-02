package com.grupo2.poo.estacionamiento;

import java.util.Date;

public class Mensual extends RegistroIngresoSalida {

    private Cliente cliente;

    public Mensual() {
        super();
    }

    public Mensual(Integer id, Date fecha, Date hora, Vehiculo vehiculo, String estado,
            Cliente cliente) {

        super(id, fecha, hora, vehiculo, estado);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Double obtenerImporte() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Mensual [cliente=" + cliente + "]";
    }
}