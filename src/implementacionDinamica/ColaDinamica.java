package implementacionDinamica;

import tdas.ColaTDA;

public class ColaDinamica implements ColaTDA{

	private class Nodo{
		int x;
		Nodo sig;
	}
	
	private Nodo primero;
	
	@Override
	public void inicializar() {
		primero=null;
	}

	@Override
	public void acolar(int valor) {
		Nodo nodo = new Nodo();
	    nodo.x = valor;
	    nodo.sig = null;

	    if (primero == null) {
	        // Si la cola está vacía, el nuevo nodo será el primero
	        primero = nodo;
	    } else {
	        // Si la cola no está vacía, agregar el nuevo nodo al final
	        Nodo viajero = primero;
	        while (viajero.sig != null) {
	            viajero = viajero.sig;
	        }
	        viajero.sig = nodo;
	    }
	}

	@Override
	public void desacolar() {
		primero=primero.sig;
	}

	@Override
	public int primero() {
		return primero.x;
	}

	@Override
	public boolean estaVacia() {
		return primero==null;
	}

}
