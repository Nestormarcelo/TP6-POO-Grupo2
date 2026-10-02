package com.grupo2.poo.estacionamiento;

import java.util.Date;

public class PorHora extends RegistroIngresoSalida {

    private Cupon cupon;
    private double valorHora;

    public PorHora() {
        super();
    }

    public PorHora(Integer id, Date fecha, Date hora, Vehiculo vehiculo, String estado,
            Cupon cupon, double valorHora) {

        super(id, fecha, hora, vehiculo, estado);
        this.cupon = cupon;
        this.valorHora = valorHora;
    }

    public Cupon getCupon() {
        return cupon;
    }

    public void setCupon(Cupon cupon) {
        this.cupon = cupon;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public Double obtenerImporte() {

        if (getHora() == null) {
            return 0.0;
        }

        Date horaSalida = new Date();

        long diferencia = horaSalida.getTime() - getHora().getTime();

        double horas = Math.ceil(diferencia / (1000.0 * 60 * 60));

        if (horas < 1) {
            horas = 1;
        }

        double importe = horas * valorHora;

        if (cupon != null) {

            Date fechaActual = new Date();

            if (!fechaActual.after(cupon.getFechaVencimiento())) {

                double descuento = importe * cupon.getPorcentajeDescuento() / 100;

                importe = importe - descuento;
            }
        }

        return importe;
    }

    @Override
    public String toString() {
        return "PorHora [cupon=" + cupon + ", valorHora=" + valorHora + "]";
    }
}