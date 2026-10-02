package com.grupo2.poo.enums;

public enum Categoria {
	AUXILIAR("Auxiliar", 30000d),
    VENTAS("Ventas", 45000d),
    GERENCIA("Gerencia", 55000d);

    private final String descripcion;
    private final double adicional;

    Categoria(String descripcion, double adicional) {
        this.descripcion = descripcion;
        this.adicional = adicional;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getAdicional() {
        return adicional;
    }
}
