package com.grupo2.poo.empleados.model;

import java.time.LocalDate;

import com.grupo2.poo.enums.Categoria;

public class Administrativo extends Empleado {
	
	private Categoria categoria;

	public Administrativo(String legajo, String documento, String nombre, LocalDate fechaIngreso, int cantidadHijos,Categoria categoria) {
		super(legajo, documento, nombre, fechaIngreso, cantidadHijos);
		this.categoria = categoria;
	}

	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public double calcularAdicional() {
		if (categoria == null) {
			return 0.0;

		}
		return categoria.getAdicional();

	}



	@Override
	public String toString() {
	    return super.toString() + " | Categoría: " + categoria.getDescripcion();
	}
	
	

}
