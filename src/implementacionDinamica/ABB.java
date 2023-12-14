package implementacionDinamica;

import tdas.ABBTDA;

public class ABB implements ABBTDA {
	
	private class NodoABB{
		int info;
		ABBTDA hi;
		ABBTDA hd;
	}
	
	private NodoABB nodo;

	@Override
	public void inicializarArbol() {
		nodo=null;
	}

	@Override
	public void agregarElem(int x) {
		if(nodo==null) {
			nodo= new NodoABB();
			nodo.info=x;
			nodo.hd=new ABB();
			nodo.hd.inicializarArbol();
			nodo.hi=new ABB();
			nodo.hi.inicializarArbol();
		}
		else if(nodo.info > x) {
			nodo.hi.agregarElem(x);
		}
		else if(nodo.info < x) {
			nodo.hd.agregarElem(x);
		}
		else {
			//encontre x y no hago nada.
		}
	}

	@Override
	public void eliminarElem(int x) {
		if(nodo!=null) {
			if(nodo.info==x && nodo.hi.arbolVacio() && nodo.hd.arbolVacio()) {
				nodo=null;
			}
			else if(nodo.info==x && !nodo.hi.arbolVacio()) {
				int mayor = mayor(nodo.hi);
				nodo.info=mayor;
				nodo.hi.eliminarElem(mayor);
			}
			else if(nodo.info==x && !nodo.hd.arbolVacio()) {//nodo.hi.arbolvacio()
				int menor= menor(nodo.hd);
				nodo.info=menor;
				nodo.hd.eliminarElem(menor);
			}
			else if(nodo.info < x)
				nodo.hd.eliminarElem(x);
			else if(nodo.info > x) {
				nodo.hi.eliminarElem(x);
			}
		}
		else {
			//quiere decir que no lo encontro y no tiene que hacer nada
		}
	}

	@Override
	public int raiz() {
		return nodo.info;
	}

	@Override
	public ABBTDA hijoIzq() {
		return nodo.hi;
	}

	@Override
	public ABBTDA hijoDer() {
		return nodo.hd;
	}

	@Override
	public boolean arbolVacio() {
		return nodo==null;
	}
	
	private int mayor(ABBTDA nodo) {
		if(nodo.hijoDer().arbolVacio()) 
			return nodo.raiz(); //llegamos
		else 
			return mayor(nodo.hijoDer()); //no llegamos todavía
	}
	
	private int menor(ABBTDA nodo) {
		if(nodo.hijoIzq().arbolVacio()) 
			return nodo.raiz(); //llegamos
		else 
			return menor(nodo.hijoIzq()); //no llegamos todavía
	}

}
