package test;

import algoritmos.AlgoritmosSegundaParte;
import implementacionDinamica.ABB;
import tdas.ABBTDA;

public class TestABB {

	public static void main(String[] args) {
		AlgoritmosSegundaParte a= new AlgoritmosSegundaParte();
		ABBTDA arbol = new ABB();
        arbol.inicializarArbol();

        arbol.agregarElem(10);
        arbol.agregarElem(5);
        arbol.agregarElem(15);
        arbol.agregarElem(3);
        arbol.agregarElem(8);

        
        System.out.println("¿El nodo 5 está en el árbol? " + a.estaEnABB(arbol, 5));
        System.out.println("¿El nodo 12 está en el árbol? " +a.estaEnABB(arbol, 12));
        
        System.out.println("¿El nodo 8 es hoja? " +a.esHojaABB(arbol, 8));
        System.out.println("¿El nodo 10 es hoja? " +a.esHojaABB(arbol, 10));
        System.out.println("¿El nodo 12 es hoja? " +a.esHojaABB(arbol, 12));
        System.out.println("¿El nodo 3 es hoja? " +a.esHojaABB(arbol, 3));
        System.out.println("¿El nodo 15 es hoja? " +a.esHojaABB(arbol, 15));
        System.out.println("¿El nodo 5 es hoja? " +a.esHojaABB(arbol, 5));
        
        System.out.println("¿Profundidad del nodo 8? " +a.profundidadABB(arbol, 8));
        System.out.println("¿Profundidad del nodo 10? " +a.profundidadABB(arbol, 10));
        System.out.println("¿Profundidad del nodo 3? " +a.profundidadABB(arbol, 3));
        System.out.println("¿Profundidad del nodo 15? " +a.profundidadABB(arbol, 15));
        System.out.println("¿Profundidad del nodo 4? " +a.profundidadABB(arbol, 4));
        
        System.out.println("¿Menor arbol? " +a.menorABB(arbol));
        
        System.out.println("¿Cantidad de nodos? " +a.cantNodosABB(arbol));
        
        System.out.println("¿Suma de nodos? " +a.sumaNodosABB(arbol));
        
        System.out.println("¿Suma de hojas? " +a.cantHojasABB(arbol));
        
        System.out.println("¿Altura? " +a.alturaABB(arbol));
        System.out.println("¿Altura? " +a.altura2ABB(arbol));
        
        System.out.println("¿Suma de valores impares? " +a.sumarImparesABB(arbol));
        
        System.out.println("¿Hojas pares? " +a.cantHojasParABB(arbol));
        
	}
}
