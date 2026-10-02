package com.grupo2.poo.estacionamiento.manager;

import com.grupo2.poo.estacionamiento.model.RegistroIngresoSalida;
import com.grupo2.poo.estacionamiento.model.PorHora;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Manager {

    public static final int HORA_APERTURA = 8;
    public static final int HORA_CIERRE  = 22;
    public static final double VALOR_HORA = 1000.0;

    private final List<RegistroIngresoSalida> registros = new ArrayList<>();
    private int nextId = 1;

    public boolean validarPatente(String patente) {
        for (RegistroIngresoSalida r : registros) {
            if (r.getVehiculo().getPatente().equalsIgnoreCase(patente)
                    && "INGRESADO".equalsIgnoreCase(r.getEstado())) {
                return false;
            }
        }
        return true;
    }

    public void registrarIngreso(RegistroIngresoSalida registro) throws Exception {
        if (registro == null) {
            throw new Exception("Registro nulo.");
        }
        if (!validarPatente(registro.getVehiculo().getPatente())) {
            throw new Exception("El vehículo " + registro.getVehiculo().getPatente()
                    + " ya está ingresado.");
        }
        if (registro instanceof PorHora) {
            int horaActual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            if (horaActual < HORA_APERTURA || horaActual >= HORA_CIERRE) {
                throw new Exception("Fuera de horario de atención ("
                        + HORA_APERTURA + ":00 a " + HORA_CIERRE + ":00).");
            }
        }
        registro.setId(nextId++);
        registro.setEstado("INGRESADO");
        registros.add(registro);
    }

    public Double registrarSalida(RegistroIngresoSalida registro) throws Exception {
        if (registro == null) {
            throw new Exception("Registro nulo.");
        }
        RegistroIngresoSalida r = obtenerRegistro(registro.getId());
        if (r == null) {
            throw new Exception("No existe el registro ID " + registro.getId());
        }
        if (!"INGRESADO".equalsIgnoreCase(r.getEstado())) {
            throw new Exception("El registro no está activo (estado: " + r.getEstado() + ").");
        }
        Double importe = r.obtenerImporte();
        r.cambiarEstado("AFUERA");
        return importe;
    }

    public RegistroIngresoSalida obtenerRegistro(Integer id) {
        for (RegistroIngresoSalida r : registros) {
            if (r.getId() != null && r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public List<RegistroIngresoSalida> getRegistros() {
        return registros;
    }
}