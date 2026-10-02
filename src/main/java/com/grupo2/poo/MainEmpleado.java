package com.grupo2.poo;

import java.time.LocalDate;

import com.grupo2.poo.empleados.model.Administrativo;
import com.grupo2.poo.empleados.model.Empleado;
import com.grupo2.poo.empleados.model.Limpieza;
import com.grupo2.poo.empleados.model.Profesional;
import com.grupo2.poo.empleados.model.Titulo;
import com.grupo2.poo.enums.Categoria;
import com.grupo2.poo.manager.ManagerEmpleado;

public class MainEmpleado {

	public static void main(String[] args) {
		ManagerEmpleado manager = new ManagerEmpleado();
	
		/* a) agregar empleados de distintos */
		System.out.println("a)");
		Empleado nuevoProf = new Profesional("P103", "42000111", "Sofía López", LocalDate.of(2019, 4, 1), 1);
		manager.agregarEmpleado(nuevoProf);
		manager.agregarTituloProfesional("P103",new Titulo(2018, "Contadora Pública", "Universitario"));
		
		Empleado nuevoAdm = new Administrativo("A203", "36000222", "Pedro Gómez", LocalDate.of(2016, 9, 15), 2, Categoria.GERENCIA);
		manager.agregarEmpleado(nuevoAdm);
		
       Empleado nuevoLim = new Limpieza("L303", "39000333", "Esteban Sanchez", LocalDate.of(2021, 2, 10), 0);
       manager.agregarEmpleado(nuevoLim);
        
  
        /* b) buscar empleado por legajo y mostar sus datos */
        System.out.println("\nb)");
        Empleado emplB1 =manager.buscarEmpleadoPorLegajo("p101");
        System.out.println(emplB1);
        Empleado emplB2 =manager.buscarEmpleadoPorLegajo("p102");
        System.out.println(emplB2);
        
        
        /* c) Buscar un empleado administrativo por legajo, cambiar su categoría y mostrar el sueldo neto que le corresponde */
        System.out.println("\nc)");
        manager.cambiarCategoriaAdministrativo("A201", Categoria.GERENCIA);
        
        /* d) Buscar un empleado profesional por legajo, agregarle un nuevo título y mostrar el sueldo neto que le corresponde */
        System.out.println("\nd)");
        manager.agregarTituloProfesional("p103", new Titulo(2020, "Comercio Exterior", "Universitario"));
        
        /* e) Obtener y mostrar los empleados de un categoría X, al final de todo mostrar el total acumulado de los remunerativos bonificables, salario, descuentos e importe neto. */
        System.out.println("\ne)");
        manager.obtenerEmpleadosPorCategoria(Categoria.GERENCIA);
        
        /* f) Calcular el importe neto acumulado de todos los empleados cuyo tipo sea igual a uno solicitado al usuario. */
        System.out.println("\nf)");
        System.out.println(manager.calcularNetoAcumuladoPorTipo("Administrativo"));
        ;
	}

}
