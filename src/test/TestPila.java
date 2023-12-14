package test;

import algoritmos.Algoritmos;
import implementacionDinamica.ColaDinamica;
import implementacionEstatica.ColaEstatica;
import implementacionEstatica.PilaEstatica;
import tdas.ColaTDA;
import tdas.PilaTDA;

public class TestPila {

	public static void main(String[] args) {
		
		Algoritmos algoritmo = new Algoritmos();
		
		//tp1
		
		//PILA-----------------------------------------------------------
		System.out.println("Creo una pila y la muestro");
		PilaTDA aux1 = algoritmo.generarPila(10);
		algoritmo.mostrarPila(aux1);
	
		System.out.println("Copio la primer pila en otra y la muestro");
		PilaTDA aux2 = algoritmo.copioPila(aux1);
		algoritmo.mostrarPila(aux2);
		System.out.println("La pila aux1 esta vacia? " + aux1.estaVacia());
		System.out.println("La pila aux2 esta vacia? " + aux2.estaVacia());
		System.out.println("Termine");
		
		//pasar pila
		PilaTDA auxPila1= algoritmo.pasarPila(aux1);
		System.out.println("Paso pila. Muestro aux1");
		algoritmo.mostrarPila(aux1);
		System.out.println("Muestro auxPila1");
		algoritmo.mostrarPila(auxPila1);
		//invertir pila
		System.out.println("Invertir pila");
		algoritmo.invertirPila(auxPila1);
		algoritmo.mostrarPila(auxPila1);
		//contar elementos de una pila
		System.out.println("contar elementos de la pila: "+algoritmo.sizePila(auxPila1));
		//sumar elementos de una pila
		System.out.println("sumar elementos de la pila: "+algoritmo.sumarPila(auxPila1));
		//promediar de elementos de una pila
		System.out.println("promediar elementos de la pila: "+algoritmo.avgPila(auxPila1));
		
		//COLA------------------------------------------------------------

		System.out.println("\nCreo una cola y la muestro");
		ColaTDA aux3= algoritmo.generarCola(5);
		algoritmo.mostrarCola(aux3);
		System.out.println("Copio la primer cola en otra y la muestro");
		ColaTDA aux4 = algoritmo.copioCola(aux3);
		algoritmo.mostrarCola(aux4);
		System.out.println("La cola aux3 esta vacia? " + aux3.estaVacia());
		System.out.println("La cola aux4 esta vacia? " + aux4.estaVacia());
		
		//pasar cola
		ColaTDA auxCola1= algoritmo.pasarCola(aux3);
		System.out.println("Paso cola aux3 a aucCola1. Muestro aux3");
		algoritmo.mostrarCola(aux3);
		System.out.println("Muestro auxCola1");
		algoritmo.mostrarCola(auxCola1);
		
		//invertir cola
		System.out.println("Invertir auxcola1");
		algoritmo.invertirCola(auxCola1);
		algoritmo.mostrarCola(auxCola1);
		
		ColaTDA auxCola2= algoritmo.generarCola(10);
		System.out.println("Muestro auxcola1");
		algoritmo.mostrarCola(auxCola1);
		System.out.println("Muestro auxcola2");
		algoritmo.mostrarCola(auxCola2);
		
		//coinciden los finales de las colas?
		System.out.println("Coinciden los finales de las colas? : "+algoritmo.coincidenColas(auxCola1,auxCola2));
		auxCola1.acolar(9);
		System.out.println("acole un 9 en la segunda cola. Coinciden los finales de las colas? : "+algoritmo.coincidenColas(auxCola1,auxCola2));
		
		//cola es capicua?
		System.out.println("Es capicua?: "+algoritmo.esCapicuaCola(auxCola1));
		//creo cola capicula
		ColaTDA capiCola= new ColaEstatica();
		capiCola.inicializar();
		capiCola.acolar(4);
		capiCola.acolar(3);
		capiCola.acolar(2);
		capiCola.acolar(3);
		capiCola.acolar(4);
		algoritmo.mostrarCola(capiCola);
		System.out.println("capicola. Es capicua?: "+algoritmo.esCapicuaCola(capiCola));
		
		//cola inversa
		System.out.println("no inversa cola. Es inversa?: "+algoritmo.esInversoCola(auxCola1,capiCola));
		//creo cola inversa
		algoritmo.mostrarCola(auxCola1);
		ColaTDA invCola= new ColaEstatica();
		invCola.inicializar();
		invCola.acolar(0);
		invCola.acolar(1);
		invCola.acolar(2);
		invCola.acolar(3);
		
		ColaTDA invCola2= new ColaEstatica();
		invCola2.inicializar();
		//invCola2.acolar(4); da false
		invCola2.acolar(3);
		invCola2.acolar(2);
		invCola2.acolar(1);
		invCola2.acolar(0);
		
		algoritmo.mostrarCola(invCola);
		System.out.println("inversa cola nueva. Es capicua?: "+algoritmo.esInversoCola(invCola2,invCola));
		
		
		ColaTDA cola4= new ColaEstatica();
		cola4.inicializar();
		cola4.acolar(0);
		cola4.acolar(1);
		cola4.acolar(2);
		cola4.acolar(3);
		System.out.println("\nCola original");
		algoritmo.mostrarCola(cola4);
		algoritmo.invertirColaC(cola4);
		System.out.println("Cola invertida");
		algoritmo.mostrarCola(cola4);
		
		//tp3
		
		//pila
		
		//capicua pila
		PilaTDA pila4= new PilaEstatica();
		pila4.inicializar();
		pila4.apilar(4);
		pila4.apilar(1);
		//pila4.apilar(2); da false
		pila4.apilar(4);
		System.out.println("Pila capicua?: "+algoritmo.capicuaPila(pila4));
		
		//quitarRepetidosPila
		pila4.apilar(4);
		pila4.apilar(1);
		pila4.apilar(2);
		pila4.apilar(9);
		pila4.apilar(4);
		algoritmo.mostrarPila(pila4);
		algoritmo.quitarRepetidosPila(pila4);
		System.out.println("\n");
		algoritmo.mostrarPila(pila4);
		
		//repartirPila
		algoritmo.repartirPila(pila4);
		
		//repetidosPila
		PilaTDA pila5= new PilaEstatica();
		pila5.inicializar();
		pila5.apilar(4);
		pila5.apilar(1);
		pila5.apilar(2);
		pila5.apilar(9);
		pila5.apilar(1);
		pila5.apilar(9);
		pila5.apilar(4);
		algoritmo.mostrarPila(pila5);
		algoritmo.repetidosPila(pila5);
		
		//cola
		
		//quitarRepetidosCola
		ColaTDA cola5= new ColaEstatica();
		cola5.inicializar();
		cola5.acolar(1);
		cola5.acolar(1);
		cola5.acolar(5);
		cola5.acolar(3);
		cola5.acolar(3);
		cola5.acolar(7);
		System.out.println("\n");
		algoritmo.mostrarCola(cola5);
		algoritmo.quitarRepetidosCola(cola5);
		System.out.println("\n");
		algoritmo.mostrarCola(cola5);
		
		
		
		//repartirCola
		algoritmo.repartirCola(cola5);
		
		ColaTDA cola6= new ColaEstatica();
		cola6.inicializar();
		cola6.acolar(1);
		cola6.acolar(1);
		cola6.acolar(5);
		cola6.acolar(3);
		cola6.acolar(3);
		cola6.acolar(7);
		cola6.acolar(7);
		cola6.acolar(7);
		algoritmo.mostrarCola(cola6);
		
		//repetidosCola
		algoritmo.repetidosCola(cola6);
		
		
		
		System.out.println();
		ColaTDA colitaDin= new ColaDinamica();
		colitaDin.inicializar();
		colitaDin.acolar(1);
		colitaDin.acolar(2);
		colitaDin.acolar(3);
		colitaDin.acolar(4);
		colitaDin.acolar(5);
		System.out.println(colitaDin.primero());
		colitaDin.desacolar();
		System.out.println(colitaDin.primero());
	}

}
