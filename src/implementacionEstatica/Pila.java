package implementacionEstatica;

import tdas.PilaTDA;

public class Pila implements PilaTDA {

	int[] array;
	int cont;
	
	@Override
	public void inicializar() {
		array=new int[100];
		cont=0;
	}

	@Override
	public void apilar(int valor) {
		array[cont]=valor;
		cont++;
	}

	@Override
	public void desapilar() {
		cont--;
	}

	@Override
	public int tope() {
		return array[cont-1];
	}

	@Override
	public boolean estaVacia() {
		return cont==0;
	}

}
