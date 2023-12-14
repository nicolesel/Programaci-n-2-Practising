package implementacionEstatica;

import tdas.ConjuntoTDA;

public class ConjuntoEstatica implements ConjuntoTDA{
	
	private int[]array;
	private int cant;
	@Override
	public void inicializarConjunto() {
		array= new int[100];
		cant=0;
	}
	@Override
	public void agregar(int x) {
		if(!this.pertenece(x)) {
			array[cant]=x;
			cant++;
		}
	}
	@Override
	public void sacar(int x) {
		if(this.pertenece(x)) {
			int k = cant-1;
			for(int i=0;i<cant;i++) {
				if(this.array[i]==x) {
					k=i;
				}
			}
			array[k]=array[cant-1];
			cant--;
		}
		
	}
	@Override
	public int elegir() {
		return array[0]; //devolver cualquier cosa
	}
	@Override
	public boolean pertenece(int x) {
		boolean flag=false;
		for(int i=0;i<cant;i++) {
			if(this.array[i]==x)
				flag=true; //lo hago asi pq es mas facil, pero quiza menos efic?
		}
		return flag;
	}
	@Override
	public boolean conjuntoVacio() {
		return cant==0;
	}
	@Override
	public void print() {
		for(int i=0;i<cant;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

}
