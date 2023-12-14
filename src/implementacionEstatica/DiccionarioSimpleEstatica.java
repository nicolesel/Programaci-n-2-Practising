package implementacionEstatica;

import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;

public class DiccionarioSimpleEstatica implements DiccionarioSimpleTDA{

	private class Elemento{
		int clave;
		int valor;
	}
	private Elemento[] elementos;
	private int cant;
	
	@Override
	public void inicializarDiccionario() {
		elementos= new Elemento[100];
		cant=0;
	}

	@Override
	public void agregar(int clave, int valor) {
		int pos= this.getIndex(clave);
		if(pos==-1) {//osea, si si existe
			Elemento e= new Elemento();
			e.clave=clave;
			e.valor=valor;
			elementos[cant]=e;
			cant++;
		}
		else {
			elementos[pos].valor=valor;
		}
		
	}

	@Override
	public void eliminar(int clave) {
		int pos= getIndex(clave);
		if(pos!=-1) { //existe
			elementos[pos]=elementos[cant-1];
			cant--;
		}
		
	}

	@Override
	public int recuperar(int clave) {
		int pos= getIndex(clave);
		return elementos[pos].valor; //no puede no existir la clave
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA con= new ConjuntoEstatica();
		con.inicializarConjunto();
		for(int i=0;i<cant;i++) {
			con.agregar(elementos[i].clave);
		}
		return con;
	}
	
	private int getIndex(int clave) {
		int pos=-1;
		for(int i=0;i<cant;i++) {
			if(elementos[i].clave==clave) { 
				pos=i;//podria agregar aca i=cant; ??
			}
		}
		return pos;
	}

}
