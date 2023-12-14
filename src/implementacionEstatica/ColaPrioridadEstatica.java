package implementacionEstatica;

import tdas.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA{

	private class Elemento {
		int valor; 
		int prioridad;
	}
	
	private Elemento[] elementos;
	private int indice;
	
	@Override
	public void inicializarCola() { 
		indice = 0;
		elementos = new Elemento[100];
	}
	
	@Override
	public void acolar(int x, int prioridad) {
		Elemento e= new Elemento();
		e.prioridad=prioridad;
		e.valor=x;
		int k=0;
		int i=indice-1;
		while(i>=0 && k==0) {
		 	if(elementos[i].prioridad>=prioridad){
		 		k=i+1;
		 	}
			else{
				elementos[i+1]=elementos[i];
			}
			i--;
		}
		/*for(int i=indice-1;i>=0;i--) {
			if(elementos[i].prioridad>=prioridad) {
				k=i+1;
				break;
			}
			elementos[i+1]=elementos[i];
		}*/
		indice++;
		elementos[k]=e;
	}
	
	@Override
	public void desacolar() {
		for(int i=1;i<indice;i++) {
			elementos[i-1]= elementos[i];
		}
		indice--;
	}
	
	@Override
	public int primero() {
		return elementos[0].valor;
	}
	
	@Override
	public int prioridad() {
		return elementos[0].prioridad;
	}
	
	@Override
	public boolean colaVacia() {
		return indice==0;
	}
	
	public void print () { //en realidad no se puede, pero me da fiaca hacer en algoritmos
		for(int i=0;i<indice;i++) {
			System.out.println(elementos[i].valor+" -> "+elementos[i].prioridad);
		}
		
	}
	
}

/*@Override
	public void inicializarCola() {
		elementos= new Elemento[100];
		indice=0;
	}

	@Override
	public void acolar(int x, int prioridad) {
		Elemento e= new Elemento();
		e.prioridad=prioridad;
		e.valor=x;
		int k;
		for(int i=indice-1;i>=0;i--) {
			if(elementos[i].prioridad>=prioridad) {
				k=i+1;
				break;
			}
			elementos[i+1]=elementos[i];
		}
		indice++;
		elementos[k]=e;
	}

	@Override
	public void desacolar() {
		for(int i=1;i<indice;i++) {
			elementos[i-1]= elementos[i];
		}
		indice--;
		
	}

	@Override
	public int primero() {
		return Elementos[0].valor;
	}

	@Override
	public int prioridad() {
		return Elementos[0].prioridad;
	}

	@Override
	public boolean colaVacia() {
		return indice==0;
	}*/