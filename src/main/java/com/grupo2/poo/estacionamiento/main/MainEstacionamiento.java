package com.grupo2.poo.estacionamiento.main;

import com.grupo2.poo.estacionamiento.manager.Manager;
import com.grupo2.poo.estacionamiento.model.Cliente;
import com.grupo2.poo.estacionamiento.model.Cupon;
import com.grupo2.poo.estacionamiento.model.Mensual;
import com.grupo2.poo.estacionamiento.model.PorHora;
import com.grupo2.poo.estacionamiento.model.RegistroIngresoSalida;
import com.grupo2.poo.estacionamiento.model.Vehiculo;
import java.util.Date;
import java.util.Scanner;

public class MainEstacionamiento {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n--- ESTACIONAMIENTO ---");
            System.out.println("1. Ingresar vehículo por hora");
            System.out.println("2. Ingresar vehículo mensual");
            System.out.println("3. Buscar registro por ID");
            System.out.println("4. Registrar salida por ID");
            System.out.println("5. Listar todos los registros");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1: {
                        System.out.print("Patente: "); String pat = sc.nextLine();
                        System.out.print("Marca: ");   String mar = sc.nextLine();
                        System.out.print("Color: ");   String col = sc.nextLine();
                        Vehiculo v = new Vehiculo(pat, mar, col);

                        System.out.print("¿Tiene cupón? (s/n): ");
                        Cupon cupon = null;
                        if (sc.nextLine().equalsIgnoreCase("s")) {
                            System.out.print("Código: ");        String cod = sc.nextLine();
                            System.out.print("Descuento (%): "); double pct = Double.parseDouble(sc.nextLine());
                            System.out.print("¿Vencido? (s/n): ");
                            boolean vencido = sc.nextLine().equalsIgnoreCase("s");
                            long off = vencido ? -30L * 24 * 60 * 60 * 1000
                                               :  30L * 24 * 60 * 60 * 1000;
                            Date venc = new Date(System.currentTimeMillis() + off);
                            cupon = new Cupon(cod, venc, pct);
                        }

                        Date ahora = new Date();
                        PorHora ph = new PorHora(null, ahora, ahora, v, "INGRESADO", cupon, Manager.VALOR_HORA);
                        manager.registrarIngreso(ph);
                        System.out.println("OK -> Registro creado ID=" + ph.getId());
                        break;
                    }
                    case 2: {
                        System.out.print("Patente: "); String pat = sc.nextLine();
                        System.out.print("Marca: ");   String mar = sc.nextLine();
                        System.out.print("Color: ");   String col = sc.nextLine();
                        Vehiculo v = new Vehiculo(pat, mar, col);

                        System.out.print("DNI cliente: "); String dni = sc.nextLine();
                        System.out.print("Domicilio: ");   String dom = sc.nextLine();
                        System.out.print("Celular: ");     String cel = sc.nextLine();
                        Cliente c = new Cliente(0, dni, dom, cel);

                        Date ahora = new Date();
                        Mensual m = new Mensual(null, ahora, ahora, v, "INGRESADO", c);
                        manager.registrarIngreso(m);
                        System.out.println("OK -> Registro mensual ID=" + m.getId());
                        break;
                    }
                    case 3: {
                        System.out.print("ID a buscar: ");
                        int id = Integer.parseInt(sc.nextLine());
                        RegistroIngresoSalida r = manager.obtenerRegistro(id);
                        if (r == null) {
                            System.out.println("No existe ID " + id);
                        } else {
                            System.out.println(r);
                            System.out.println("Importe actual: $" + r.obtenerImporte());
                        }
                        break;
                    }
                    case 4: {
                        System.out.print("ID a dar salida: ");
                        int id = Integer.parseInt(sc.nextLine());
                        RegistroIngresoSalida r = manager.obtenerRegistro(id);
                        if (r == null) {
                            System.out.println("No existe ID " + id);
                            break;
                        }
                        String tipo = r.getClass().getSimpleName();
                        String patente = r.getVehiculo().getPatente();
                        double importe = manager.registrarSalida(r);

                        System.out.println("--- SALIDA REGISTRADA ---");
                        System.out.println("ID:      " + id);
                        System.out.println("Tipo:    " + tipo);
                        System.out.println("Patente: " + patente);
                        System.out.println("Importe: $" + importe);
                        System.out.println("Estado:  AFUERA");
                        if (r instanceof Mensual) {
                            System.out.println("(Cliente mensual: cuota fuera del alcance)");
                        }
                        break;
                    }
                    case 5: {
                        if (manager.getRegistros().isEmpty()) {
                            System.out.println("No hay registros.");
                        } else {
                            for (RegistroIngresoSalida r : manager.getRegistros()) {
                                System.out.println("ID=" + r.getId()
                                        + " | tipo=" + r.getClass().getSimpleName()
                                        + " | patente=" + r.getVehiculo().getPatente()
                                        + " | estado=" + r.getEstado()
                                        + " | importe=$" + r.obtenerImporte());
                            }
                        }
                        break;
                    }
                    case 0:
                        System.out.println("Chau.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("ERROR -> " + e.getMessage());
            }
        } while (op != 0);

        sc.close();
    }
}