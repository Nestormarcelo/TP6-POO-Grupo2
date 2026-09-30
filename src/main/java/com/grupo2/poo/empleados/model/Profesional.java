package com.grupo2.poo.empleados.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesional extends Empleado {

    private ArrayList<Titulo> titulos;

    public Profesional(int legajo, String documento, String nombre,
            LocalDate fechaIngreso, int cantidadHijos) {

        super(legajo, documento, nombre, fechaIngreso, cantidadHijos);
        titulos = new ArrayList<Titulo>();
    }

    public ArrayList<Titulo> getTitulos() {
        return titulos;
    }

    public void agregarTitulo(Titulo titulo) {
        titulos.add(titulo);
    }

    @Override
    public double calcularAdicional() {
        return titulos.size() * 30000;
    }
}