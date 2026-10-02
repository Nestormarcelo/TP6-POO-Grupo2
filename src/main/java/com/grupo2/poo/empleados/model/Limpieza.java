package com.grupo2.poo.empleados.model;

import java.time.LocalDate;

public class Limpieza extends Empleado{

	private double adicionalInsalubridad;
	
	public Limpieza(String legajo, String documento, String nombre, LocalDate fechaIngreso, int cantidadHijos) {
		super(legajo, documento, nombre, fechaIngreso, cantidadHijos);
		this.adicionalInsalubridad = 25000d;
	}

	public double getAdicionalInsalubridad() {
		return adicionalInsalubridad;
	}

	public void setAdicionalInsalubridad(double adicionalInsalubridad) {
		this.adicionalInsalubridad = adicionalInsalubridad;
	}

	@Override
	public double calcularAdicional() {
		return adicionalInsalubridad;
	}

	@Override
	public String toString() {
	    return super.toString() + " | Adicional Insalubridad: $" + adicionalInsalubridad;
	}
	
	
	
}
