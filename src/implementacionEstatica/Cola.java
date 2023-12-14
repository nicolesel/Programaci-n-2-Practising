package implementacionEstatica;

import tdas.ColaTDA;

public class Cola implements ColaTDA{

	int[] array;
	int cont;
	
	@Override
	public void inicializar() {
		array=new int[100];
		cont=0;
	}

	@Override
	public void acolar(int valor) {
		array[cont]=valor;
		cont++;
	}

	@Override
	public void desacolar() {
		for(int i=0;i<cont;i++) {
			array[i]=array[i+1];
		}
		cont--;
	}

	@Override
	public int primero() {
		return array[0];
	}

	@Override
	public boolean estaVacia() {
		return cont==0;
	}

}
