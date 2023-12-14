package test;

import algoritmos.Algoritmos;
import implementacionEstatica.ColaEstatica;
import implementacionEstatica.ConjuntoEstatica;
import implementacionEstatica.PilaEstatica;
import tdas.ColaTDA;
import tdas.ConjuntoTDA;
import tdas.PilaTDA;


public class TestConjunto {
	public static void main(String[] args) {
		Algoritmos algoritmo= new Algoritmos();
		ConjuntoTDA con1= new ConjuntoEstatica();
		ConjuntoTDA con2= new ConjuntoEstatica();
		con1.inicializarConjunto();
		con2.inicializarConjunto();
		
		con1.agregar(1);
		con1.agregar(2);
		con1.agregar(6);
		con1.agregar(3);
		con1.agregar(4);
		
		con2.agregar(4);
		con2.agregar(5);
		con2.agregar(6);
		con2.agregar(7);
		
		con1.print();
		con2.print();
		
		ConjuntoTDA con3= algoritmo.unionConjunto(con1, con2);
		
		con3.print();
		
		ConjuntoTDA con4= algoritmo.interseccionConjunto(con1, con2);
		
		con4.print();
		
		ConjuntoTDA con5= algoritmo.diferenciaConjunto(con1, con2);
		
		con5.print();
		
		ConjuntoTDA con6= algoritmo.diferenciaSimetricaConjunto(con1, con2);
		
		con6.print();
		
		ConjuntoTDA con7= algoritmo.diferenciaSimetricaConjunto2(con1, con2);
		
		con7.print();
		
		System.out.println("Son iguales: "+algoritmo.sonIgualesConjunto(con1, con2));
		
		ConjuntoTDA conjunto1= new ConjuntoEstatica();
		ConjuntoTDA conjunto2= new ConjuntoEstatica();
		conjunto1.inicializarConjunto();
		conjunto2.inicializarConjunto();
		
		conjunto1.agregar(1);
		conjunto1.agregar(2);
		conjunto1.agregar(3);
		
		conjunto2.agregar(3);
		conjunto2.agregar(1);
		conjunto2.agregar(2);
		
		System.out.println("Son iguales: "+algoritmo.sonIgualesConjunto(conjunto1, conjunto2));
		
		System.out.println("Cardinalidad de conjunto1: "+algoritmo.cardinalidadConjunto(conjunto1));
		
		PilaTDA pila= new PilaEstatica();
		pila.inicializar();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		
		ColaTDA cola= new ColaEstatica();
		cola.inicializar();
		cola.acolar(-1);
		cola.acolar(-2);
		cola.acolar(-3);
	
		ConjuntoTDA conjunto3 = algoritmo.juntarPilaYColaEnConjunto(pila, cola);
		
		conjunto3.print();
		
		System.out.println("Son iguales: "+algoritmo.sonIgualesPilaColaConjunto(pila,cola));
				
		
		PilaTDA pila2= new PilaEstatica();
		pila2.inicializar();
		pila2.apilar(1);
		pila2.apilar(2);
		pila2.apilar(3);
		pila2.apilar(4);
		
		ColaTDA cola2= new ColaEstatica();
		cola2.inicializar();
		cola2.acolar(2);
		cola2.acolar(4);
		cola2.acolar(1);
		cola2.acolar(3);

		System.out.println("Son iguales: "+algoritmo.sonIgualesPilaColaConjunto(pila2,cola2));
		
	}

}
