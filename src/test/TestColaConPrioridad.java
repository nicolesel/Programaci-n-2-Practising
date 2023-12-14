package test;

import algoritmos.Algoritmos;
import implementacionEstatica.ColaPrioridadEstatica;
import tdas.ColaPrioridadTDA;

public class TestColaConPrioridad {
	
	public static void main(String[] args) {
		
		Algoritmos algoritmo= new Algoritmos();
		
		ColaPrioridadTDA cola= new ColaPrioridadEstatica();
		cola.inicializarCola();
		cola.acolar(1, 1);
		cola.acolar(2, 2);
		cola.acolar(3, 3);
		cola.acolar(0, 0);
		cola.acolar(10, 10);
		cola.acolar(5, 5);
		cola.print();
		System.out.println(cola.primero()+" "+cola.prioridad());
		cola.desacolar();
		cola.desacolar();
		cola.print();
		System.out.println(cola.colaVacia());
		
		ColaPrioridadTDA cola2= new ColaPrioridadEstatica();
		cola2.inicializarCola();
		cola2.acolar(100, 3);
		cola2.acolar(100, 1);
		
		ColaPrioridadTDA unir=algoritmo.unirColaPrioridad(cola2,cola);
		unir.print();
		
		ColaPrioridadTDA c1= new ColaPrioridadEstatica();
		ColaPrioridadTDA c2= new ColaPrioridadEstatica();
		c1.inicializarCola();
		c2.inicializarCola();
		
		c1.acolar(1, 1);
		c1.acolar(2, 2);
		c1.acolar(3, 3);
		c1.acolar(3, 3);
		
		c2.acolar(1, 1);
		c2.acolar(2, 2);
		c2.acolar(3, 3);
		
		System.out.println(algoritmo.sonIgualesColaPrioridad(c1,c2));
		
		
	}

}
