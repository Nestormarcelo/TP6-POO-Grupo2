package com.grupo2.poo.manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.grupo2.poo.empleados.model.Administrativo;
import com.grupo2.poo.empleados.model.Empleado;
import com.grupo2.poo.empleados.model.Limpieza;
import com.grupo2.poo.empleados.model.Profesional;
import com.grupo2.poo.empleados.model.Titulo;
import com.grupo2.poo.enums.Categoria;

public class ManagerEmpleado {
	private List<Empleado> empleados;

	public ManagerEmpleado() {
		this.empleados = new ArrayList<>();
		inicializarEmpleados();
	}

	private void inicializarEmpleados() {
		Profesional p1 = new Profesional("P101", "35111222", "Carlos Gómez", LocalDate.of(2015, 3, 15), 2);
		p1.agregarTitulo("P101", new Titulo(2014, "Ingeniería en Sistemas", "Universitario"));
		p1.agregarTitulo("P101", new Titulo(2018, "Diplomatura en Datos", "Universitario"));

		Profesional p2 = new Profesional("P102", "38333444", "Ana Martínez", LocalDate.of(2020, 8, 1), 0);
		p2.agregarTitulo("P102", new Titulo(2019, "Analista Programador", "Terciario"));

		Administrativo a1 = new Administrativo("A201", "33555666", "Roberto Fernández", LocalDate.of(2010, 5, 20), 3,Categoria.VENTAS);
		Administrativo a2 = new Administrativo("A202", "40777888", "Lucía Torres", LocalDate.of(2021, 1, 10), 1,Categoria.AUXILIAR);

		Limpieza l1 = new Limpieza("L301", "29999000", "Jorge Ramírez", LocalDate.of(2008, 11, 4), 2);
		Limpieza l2 = new Limpieza("L302", "41111222", "Mariana Ríos", LocalDate.of(2022, 6, 12), 1);

		agregarEmpleado(p1);
		agregarEmpleado(p2);
		agregarEmpleado(a1);
		agregarEmpleado(a2);
		agregarEmpleado(l1);
		agregarEmpleado(l2);
	}

	public void agregarEmpleado(Empleado empleado) {
		if (empleado == null) {
			System.out.println("Error: El empleado es nulo.");
			return;
		}
		if (buscarEmpleadoPorLegajo(empleado.getLegajo()) != null) {
			System.out.println("Error: El legajo ya existe");
			return;
		}
		empleados.add(empleado);
		System.out.println("\nEmpleado agregado correctamente"+empleado);

	}

	public Empleado buscarEmpleadoPorLegajo(String legajo) {
		for (Empleado emp : empleados) {
			if (emp.getLegajo().equalsIgnoreCase(legajo)) {
				return emp;
			}
		}
		return null;
	}

	public void cambiarCategoriaAdministrativo(String legajo, Categoria nuevaCategoria) {
		Empleado emp = buscarEmpleadoPorLegajo(legajo);
		if (emp == null) {
			System.out.println("No se encontro empleado con el legajo indicado");
			return;
		}
		if (emp instanceof Administrativo) {
			System.out.println("Cambiar categoria de Administrativo:"+ emp);
			System.out.println("Sueldo antes de cambiar de categoria: " + emp.calcularSueldoNeto());
			((Administrativo) emp).setCategoria(nuevaCategoria);
			System.out.println("Sueldo despues de cambiar de categoria: " + emp.calcularSueldoNeto());
		} else {
			System.out.println("El empleado no es Administrativo");
		}

	}

	public void agregarTituloProfesional(String legajo, Titulo titulo) {
		Empleado emp = buscarEmpleadoPorLegajo(legajo);
		if (emp == null) {
			System.out.println("No se encontro empleado con el legajo indicado");
			return;
		}
		if (emp instanceof Profesional) {
			System.out.println("Agregar título a profesional con:"+ emp);
			System.out.println("Sueldo altual:" + emp.calcularSueldoNeto());
			((Profesional) emp).agregarTitulo(legajo, titulo);
			System.out.println("Sueldo actualizado despues de agregar un nuevo titulo:" + emp.calcularSueldoNeto());
		}

	}

	public void obtenerEmpleadosPorCategoria(Categoria categoria) {
		double totalRemunerativos = 0;
		double totalSalarioFamiliar = 0;
		double totalDescuentos = 0;
		double totalNeto = 0;

		System.out.println("Empleados de categoría " + categoria.getDescripcion() + ":");
		for (Empleado e : empleados) {
			if (e instanceof Administrativo) {
				Administrativo admin = (Administrativo) e;
				if (admin.getCategoria() == categoria) {
					System.out.println(admin);
					double remunerativos = admin.calcularRemunerativoBonificable();
					double salario = admin.calcularSalarioFamiliar();
					double descuentos = admin.calcularDescuento();
					double neto = admin.calcularSueldoNeto();

					totalRemunerativos += remunerativos;
					totalSalarioFamiliar += salario;
					totalDescuentos += descuentos;
					totalNeto += neto;
				}
			}
		}

		System.out.println("\nTotales:");
		System.out.println("Remunerativos Bonificables: $" + totalRemunerativos);
		System.out.println("Salario Familiar: $" + totalSalarioFamiliar);
		System.out.println("Descuentos: $" + totalDescuentos);
		System.out.println("Importe Neto: $" + totalNeto);
	}

	public double calcularNetoAcumuladoPorTipo(String tipo) {
		double total = 0.0;
		for (Empleado emp : empleados) {
			if (tipo.equalsIgnoreCase("PROFESIONAL") && emp instanceof Profesional) {
				total += emp.calcularSueldoNeto();
			} else if (tipo.equalsIgnoreCase("ADMINISTRATIVO") && emp instanceof Administrativo) {
				total += emp.calcularSueldoNeto();
			} else if (tipo.equalsIgnoreCase("LIMPIEZA") && emp instanceof Limpieza) {
				total += emp.calcularSueldoNeto();
			}
		}
		System.out.println("Total Neto Acumulado para " + tipo + ":"   );
		return total;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
