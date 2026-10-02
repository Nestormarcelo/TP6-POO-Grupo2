package com.grupo2.poo.empleados.model;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {

    private String legajo;
    private String documento;
    private String nombre;
    private LocalDate fechaIngreso;
    private int cantidadHijos;
    private double sueldoBasico;

    public Empleado(String legajo, String documento, String nombre,
            LocalDate fechaIngreso, int cantidadHijos) {
        this.legajo = legajo;
        this.documento = documento;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.cantidadHijos = cantidadHijos;
        this.sueldoBasico = 400000d;
    }

    public String getLegajo() {
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

    public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
    
    public abstract double calcularAdicional();
    
    public double calcularSueldoNeto() {
        return calcularRemunerativoBonificable()+ calcularSalarioFamiliar()- calcularDescuento();
    }
    
    public int calcularAntiguedad() {
        return Period.between(fechaIngreso, LocalDate.now()).getYears();
    }

    public double calcularSalarioFamiliar() {
        return cantidadHijos * 15000d;
    } 

    public double calcularDescuento() {
        return calcularRemunerativoBonificable() * 0.18d;
    }
    
    public double calcularRemunerativoBonificable() {
        return 400000d + calcularAdicional()+ (calcularAntiguedad() * 6500d);
    }

	
    @Override
    public String toString() {
        return String.format("Legajo: %s | Nombre: %s | DNI: %s | Sueldo Neto: $%.2f",
                legajo, nombre, documento, calcularSueldoNeto());
    }
   

   
}