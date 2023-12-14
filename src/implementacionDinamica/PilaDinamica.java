package implementacionDinamica;

import tdas.PilaTDA;

public class PilaDinamica implements PilaTDA {

	private class Nodo {
		int x;
		Nodo sig;
	}
	
	private Nodo primero;
	
	@Override
	public void inicializar() {
		primero=null;
	}

	@Override
	public void apilar(int valor) {
		Nodo nodo= new Nodo();
		nodo.x=valor;
		nodo.sig=primero;
		primero=nodo;
	}

	@Override
	public void desapilar() {
		primero=primero.sig;
	}

	@Override
	public int tope() {
		return primero.x;
	}

	@Override
	public boolean estaVacia() {
		return primero==null;
	}

}
