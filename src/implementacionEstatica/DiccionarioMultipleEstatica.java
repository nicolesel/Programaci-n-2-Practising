package implementacionEstatica;

import tdas.ConjuntoTDA;
import tdas.DiccionarioMultipleTDA;

public class DiccionarioMultipleEstatica implements DiccionarioMultipleTDA{
	
	private class Elemento{
		int clave;
		ConjuntoTDA con;
	}
	
	Elemento elementos[];
	int cant;

	@Override
	public void inicializarDiccionario() {
		elementos= new Elemento[100];
		cant=0;
		
	}

	@Override
	public void agregar(int clave, int valor) {
		int pos= this.getIndex(clave);
		if(pos!=-1) {
			elementos[pos].con.agregar(valor);
		}
		else {
			Elemento e= new Elemento();
			e.clave=clave;
			e.con= new ConjuntoEstatica();
			e.con.inicializarConjunto();
			e.con.agregar(valor);
			elementos[cant]=e;
			cant++;
		}
		
	}

	@Override
	public void eliminar(int clave) {
		int pos= this.getIndex(clave);
		if(pos!=-1) {
			elementos[pos]=elementos[cant-1];
			cant--;
		}
		
	}

	@Override
	public void eliminarValor(int clave, int valor) {
		int pos= this.getIndex(clave);
		if(pos!=-1) {
			if(elementos[pos].con.pertenece(valor)) {
				elementos[pos].con.sacar(valor);
				if(elementos[pos].con.conjuntoVacio()) {
					this.eliminar(clave);
				}
			}
		}
		
	}

	@Override
	public ConjuntoTDA recuperar(int clave) {
		int pos= this.getIndex(clave);
		ConjuntoTDA conjunto= new ConjuntoEstatica();
		conjunto.inicializarConjunto();
		if(pos!=-1) {
			conjunto=elementos[pos].con;
		}
		return conjunto;
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA conjunto= new ConjuntoEstatica();
		conjunto.inicializarConjunto();
		for(int i=0;i<cant;i++) {
			conjunto.agregar(elementos[i].clave);
		}
		return conjunto;
	}
	
	private int getIndex(int clave) {
		int pos=-1;
		for(int i=0;i<cant;i++) {
			if(elementos[i].clave==clave) {
				pos=i;
			}
		}
		return pos;
	}
	@Override
	public void print() {
		for(int i=0;i<cant;i++) {
			System.out.print(elementos[i].clave+" -> ");
			elementos[i].con.print();
		}
	}

}
