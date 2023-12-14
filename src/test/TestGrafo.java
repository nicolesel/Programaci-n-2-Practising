package test;

import algoritmos.AlgoritmosSegundaParte;
import implementacionEstatica.GrafoEstatica;
import tdas.ConjuntoTDA;
import tdas.GrafoTDA;

public class TestGrafo {
	public static void main(String[] args) {
		AlgoritmosSegundaParte a= new AlgoritmosSegundaParte();
		GrafoTDA g= new GrafoEstatica();
		g.inicializarGrafo();
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);
		g.agregarArista(1, 2, 1);
		g.agregarArista(2, 4, 2);
		g.agregarArista(2, 5, 2);
		g.agregarArista(2, 3, 2);
		g.agregarArista(4, 5, 4);
		g.agregarArista(5, 3, 5);
		g.agregarArista(5, 1, 10);
		g.agregarArista(1, 6, 10);
		g.agregarArista(6, 4, 10);
		
		
		System.out.println("adyacentesDoblesGrafo Para 1");
		ConjuntoTDA c= a.adyacentesDoblesGrafo(g,1);
		while(!c.conjuntoVacio()) {
			int num=c.elegir();
			c.sacar(num);
			System.out.println(num);
		}
		System.out.println("adyacentesDoblesGrafo Para 4");
		c= a.adyacentesDoblesGrafo(g,4);
		while(!c.conjuntoVacio()) {
			int num=c.elegir();
			c.sacar(num);
			System.out.println(num);
		}
		
		
		System.out.println("Mayor costo vertice 5: "+a.mayorCostoGrafo(g,5));
		System.out.println("Mayor costo vertice 2: "+a.mayorCostoGrafo(g,2));
		
		
		
		System.out.println("Predecesores de 2: ");
		c= a.predecesoresGrafo(g,2);
		while(!c.conjuntoVacio()) {
			int num=c.elegir();
			c.sacar(num);
			System.out.println(num);
		}
		System.out.println("Predecesores de 5: ");
		c= a.predecesoresGrafo(g,5);
		while(!c.conjuntoVacio()) {
			int num=c.elegir();
			c.sacar(num);
			System.out.println(num);
		}
		System.out.println("Predecesores de 3: ");
		c= a.predecesoresGrafo(g,3);
		while(!c.conjuntoVacio()) {
			int num=c.elegir();
			c.sacar(num);
			System.out.println(num);
		}
		
		
		
		System.out.println("Aislados: ");
		c= a.aisladosGrafo(g);
		while(!c.conjuntoVacio()) {
			int num=c.elegir();
			c.sacar(num);
			System.out.println(num);
		}
		
		
		
		System.out.println("Puente entre 1 y 4: ");
		c= a.puentesGrafo(g,1,4);
		while(!c.conjuntoVacio()) {
			int num=c.elegir();
			c.sacar(num);
			System.out.println(num);
		}
		System.out.println("Puente entre 4 y 3: ");
		c= a.puentesGrafo(g,4,3);
		while(!c.conjuntoVacio()) {
			int num=c.elegir();
			c.sacar(num);
			System.out.println(num);
		}
		
		
		System.out.println("Grado de 4: "+a.gradoGrafo(g, 4));
		System.out.println("Grado de 5: "+a.gradoGrafo(g, 5));
		System.out.println("Grado de 6: "+a.gradoGrafo(g, 6));
		System.out.println("Grado de 7: "+a.gradoGrafo(g, 7));
		System.out.println("Grado de 2: "+a.gradoGrafo(g, 2));
		
	}
}
