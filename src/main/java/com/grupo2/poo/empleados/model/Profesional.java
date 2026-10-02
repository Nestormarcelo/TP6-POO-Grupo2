package com.grupo2.poo.empleados.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Profesional extends Empleado {

    private List<Titulo> titulos;

    public Profesional(String legajo, String documento, String nombre,
            LocalDate fechaIngreso, int cantidadHijos) {

        super(legajo, documento, nombre, fechaIngreso, cantidadHijos);
        titulos = new ArrayList<>();
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void agregarTitulo(String legajo,Titulo titulo) {
        titulos.add(titulo);
    }

    @Override
    public double calcularAdicional() {
        return titulos.size() * 30000d;
    }

    @Override
    public String toString() {
        return super.toString() + " | Títulos: " + titulos;
    }

	
    
    
}