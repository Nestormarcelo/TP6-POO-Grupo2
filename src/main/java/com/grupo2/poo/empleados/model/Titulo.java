package com.grupo2.poo.empleados.model;

public class Titulo {

    private int anio;
    private String nombreCarrera;
    private String nivel;

    public Titulo(int anio, String nombreCarrera, String nivel) {
        this.anio = anio;
        this.nombreCarrera = nombreCarrera;
        this.nivel = nivel;
    }

    public int getAnio() {
        return anio;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public String getNivel() {
        return nivel;
    }
    
    @Override
    public String toString() {
        return nombreCarrera + " (" + nivel + ", " + anio + ")";
    }
}