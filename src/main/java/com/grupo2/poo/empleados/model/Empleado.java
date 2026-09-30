package com.grupo2.poo.empleados.model;

import java.time.LocalDate;
import java.time.Period;

public class Empleado {

    private int legajo;
    private String documento;
    private String nombre;
    private LocalDate fechaIngreso;
    private int cantidadHijos;

    public Empleado(int legajo, String documento, String nombre,
            LocalDate fechaIngreso, int cantidadHijos) {
        this.legajo = legajo;
        this.documento = documento;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.cantidadHijos = cantidadHijos;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public int getCantidadHijos() {
        return cantidadHijos;
    }

    public int calcularAntiguedad() {
        return Period.between(fechaIngreso, LocalDate.now()).getYears();
    }

    public double calcularSalarioFamiliar() {
        return cantidadHijos * 15000;
    }

    public double calcularAdicional() {
        return 0;
    }

    public double calcularRemunerativoBonificable() {
        return 400000
                + calcularAdicional()
                + (calcularAntiguedad() * 6500);
    }

    public double calcularDescuento() {
        return calcularRemunerativoBonificable() * 0.18;
    }

    public double calcularSueldoNeto() {
        return calcularRemunerativoBonificable()
                + calcularSalarioFamiliar()
                - calcularDescuento();
    }
}