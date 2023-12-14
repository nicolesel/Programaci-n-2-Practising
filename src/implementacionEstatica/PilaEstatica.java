package implementacionEstatica;

import tdas.PilaTDA;

public class PilaEstatica implements PilaTDA {

	private int[] valores;
	private int cantidad;
	
	@Override
	public void inicializar() {
		valores = new int[100];
		cantidad = 0;
	}

	@Override
	public void apilar(int valor) {
		valores[cantidad] = valor;
		cantidad = cantidad + 1;   //es seria igual si pongo cantidad++ 
 	}

	@Override
	public void desapilar() {
		cantidad--;

	}

	@Override
	public int tope() {
		return valores[cantidad - 1];
	}

	@Override
	public boolean estaVacia() {
		return cantidad == 0;
	}

}
