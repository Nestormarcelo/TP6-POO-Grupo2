package com.grupo2.poo.estacionamiento.model;

import java.util.Date;

public abstract class RegistroIngresoSalida {

    private Integer id;
    private Date fecha;
    private Date hora;
    private Vehiculo vehiculo;
    private String estado;

    public RegistroIngresoSalida() {
    }

    public RegistroIngresoSalida(Integer id, Date fecha, Date hora, Vehiculo vehiculo, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.vehiculo = vehiculo;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract Double obtenerImporte();

    public void cambiarEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "RegistroIngresoSalida [id=" + id + ", fecha=" + fecha + ", hora=" + hora
                + ", vehiculo=" + vehiculo + ", estado=" + estado + "]";
    }
}