package test;

import implementacionEstatica.ConjuntoEstatica;
import implementacionEstatica.DiccionarioMultipleEstatica;
import tdas.ConjuntoTDA;
import tdas.DiccionarioMultipleTDA;

public class TestDiccionarioMultiple {
	public static void main(String[] args) {
		DiccionarioMultipleTDA dic= new DiccionarioMultipleEstatica();
		dic.inicializarDiccionario();
		dic.agregar(2, 1);
		dic.agregar(2, 3);
		dic.agregar(2, 6);
		dic.agregar(2, 7);
		dic.agregar(3, 10);
		dic.agregar(3, 6);
		dic.agregar(7, 1);
		dic.print();
		ConjuntoTDA claves=(ConjuntoEstatica) dic.claves();
		claves.print();
		ConjuntoTDA valores=(ConjuntoEstatica) dic.recuperar(3);
		valores.print();
		dic.eliminar(3);
		dic.print();
		valores=(ConjuntoEstatica) dic.recuperar(3);
		valores.print();
	}

}
