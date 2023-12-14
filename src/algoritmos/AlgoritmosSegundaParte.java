package algoritmos;

import implementacionEstatica.ConjuntoEstatica;
import tdas.ABBTDA;
import tdas.ConjuntoTDA;
import tdas.GrafoTDA;

public class AlgoritmosSegundaParte {

	// ABB
	
	public boolean estaEnABB (ABBTDA arbol, int x) {
		if(!arbol.arbolVacio()) {
			if(arbol.raiz()==x) {
				return true;
			}
			else if(arbol.raiz() > x) 
				return estaEnABB(arbol.hijoIzq(),x);
			else if(arbol.raiz() < x) 
				return estaEnABB(arbol.hijoDer(),x);
		}
		return false; //si es hoja y no lo encontro. quise hacer else pero error
	}
	
	public boolean esHojaABB (ABBTDA arbol, int x) {
		if(!arbol.arbolVacio()) {
			if(arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio() && arbol.raiz() == x) 
				return true;
			else if(arbol.raiz()<x)
				return esHojaABB(arbol.hijoDer(),x);
			else if(arbol.raiz()>x)
				return esHojaABB(arbol.hijoIzq(),x);
		}
		return false; 
	}
	
	public int profundidadABB(ABBTDA arbol, int x) {
		return profundidadAuxABB(arbol,x,0);
	}
	
	public int profundidadAuxABB(ABBTDA arbol, int x, int profundidadActual) {
		if(!arbol.arbolVacio()) {
			if(arbol.raiz()==x) 
				return profundidadActual;
			else if(arbol.raiz() < x)
				return profundidadAuxABB(arbol.hijoDer(),x,profundidadActual+1);
			else if(arbol.raiz() > x)
				return profundidadAuxABB(arbol.hijoIzq(),x,profundidadActual+1);
		}
		return -1;
	}
	
	public int menorABB(ABBTDA arbol) {
		if(arbol.hijoIzq().arbolVacio())
			return arbol.raiz();
		else
			return menorABB(arbol.hijoIzq());
	}
	
	public int cantNodosABB(ABBTDA arbol) {
		if(arbol.arbolVacio()) 
			return 0;
		else
			return 1 + cantNodosABB(arbol.hijoDer()) + cantNodosABB(arbol.hijoIzq());
	}
	
	public int sumaNodosABB(ABBTDA arbol) {
		if(arbol.arbolVacio()) 
			return 0;
		else
			return arbol.raiz() + sumaNodosABB(arbol.hijoDer()) + sumaNodosABB(arbol.hijoIzq());
	}
	
	public int cantHojasABB(ABBTDA arbol) {
		if (arbol.arbolVacio()) //tiene que haber si o si pq ti tiene un hijo de un lado solo (no es hoja), no tendra un if al cual entrar y va a pedir el los hijos del un arbol null
	        return 0;
		else if(arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio()) 
			return 1;
		else
			return cantHojasABB(arbol.hijoDer()) + cantHojasABB(arbol.hijoIzq());
	}
	
	//precondición: a inicializado y no vacío
	public int alturaABB(ABBTDA arbol) {
		int resp;
		if(arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) { //es hoja
			resp = 0;
		} else {
			if (arbol.hijoIzq().arbolVacio()) //HD no es vacío
				resp = alturaABB(arbol.hijoDer()) + 1;
			else if (arbol.hijoDer().arbolVacio()) //HI no es vacío
				resp = alturaABB(arbol.hijoIzq()) + 1;
			else { //HD y HI no vacíos
				int altI = alturaABB(arbol.hijoIzq())+1;
				int altD = alturaABB(arbol.hijoDer())+1;
				if(altI>altD)
					resp=altI;
				else
					resp=altD;
				//resp = altI > altD ? altI + 1 : altD + 1; //igual con if, o con Math.max
			}
		}
		return resp;
	}
	
	public int altura2ABB(ABBTDA arbol) {
		if(!arbol.arbolVacio())
			return Math.max(altura2ABB(arbol.hijoIzq()), altura2ABB(arbol.hijoDer())) + 1;
		else
			return -1;
	}
	
	public int sumarImparesABB(ABBTDA arbol) {
		if(arbol.arbolVacio()) 
			return 0;
		else {
			int sumar=0;
			if(arbol.raiz()%2!=0)
				sumar=arbol.raiz();
			return sumar + sumarImparesABB(arbol.hijoDer()) + sumarImparesABB(arbol.hijoIzq());
		}
	}
	
	public int cantHojasParABB(ABBTDA arbol) {
		if(arbol.arbolVacio())
			return 0;
		else {
			if(arbol.hijoDer().arbolVacio()&&arbol.hijoIzq().arbolVacio()&&arbol.raiz()%2==0)
				return 1;
			else 
				return cantHojasParABB(arbol.hijoDer()) + cantHojasParABB(arbol.hijoIzq());
			
		}
	}
	
	public int cantHojasParABB2 (ABBTDA arbol) {
		if(arbol.arbolVacio()) {
			return 0;
		}
		else {
			int va=0;
			if(arbol.raiz()%2==0 && arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio()) {
				va=1;
			}
			return va + cantHojasParABB(arbol.hijoDer()) + cantHojasParABB(arbol.hijoIzq()); 
		}
	}
	
	//Grafos
	
	public ConjuntoTDA adyacentesDoblesGrafo(GrafoTDA grafo,int v) {
		ConjuntoTDA c= new ConjuntoEstatica();
		c.inicializarConjunto();
		ConjuntoTDA vertices1= grafo.vertices();
		ConjuntoTDA vertices2= grafo.vertices();
		ConjuntoTDA vertices3;
		while(!vertices1.conjuntoVacio()) {
			int vertice=vertices1.elegir();
			vertices1.sacar(vertice);
			if(vertice==v) {
				while(!vertices2.conjuntoVacio()) {
					int x= vertices2.elegir();
					vertices2.sacar(x);
					vertices3= grafo.vertices();
					while(!vertices3.conjuntoVacio()) {
						int w= vertices3.elegir();
						vertices3.sacar(w);
						if(grafo.existeArista(v, x)&&grafo.existeArista(x, w)) {
							c.agregar(w);
						}
					}
					
				}
			}
		}
		return c;
	}
	
	public int mayorCostoGrafo(GrafoTDA grafo,int v) {
		int mayor=0;
		ConjuntoTDA vertices1= grafo.vertices();
		ConjuntoTDA vertices2= grafo.vertices();
		while(!vertices1.conjuntoVacio()) {
			int vertice=vertices1.elegir();
			vertices1.sacar(vertice);
			if(vertice==v) {
				while(!vertices2.conjuntoVacio()) {
					int x= vertices2.elegir();
					vertices2.sacar(x);
					if(grafo.pesoArista(v, x)>mayor)
						mayor=grafo.pesoArista(v, x);
				}
			}
		}
		return mayor;
	}
	
	public ConjuntoTDA predecesoresGrafo(GrafoTDA g,int v) {
		ConjuntoTDA c= new ConjuntoEstatica();
		c.inicializarConjunto();
		ConjuntoTDA vertices1= g.vertices();
		ConjuntoTDA vertices2= g.vertices();
		while(!vertices1.conjuntoVacio()) {
			int vertice= vertices1.elegir();
			vertices1.sacar(vertice);
			if(vertice==v) {
				while(!vertices2.conjuntoVacio()) {
					int pre= vertices2.elegir();
					vertices2.sacar(pre);
					if(g.existeArista(pre, v)) {
						c.agregar(pre);
					}
				}		
			}
		}
		return c;
	}
	
	public ConjuntoTDA aisladosGrafo(GrafoTDA g) {
		ConjuntoTDA c= new ConjuntoEstatica();
		c.inicializarConjunto();
		ConjuntoTDA vertices1= g.vertices();
		ConjuntoTDA vertices2;
		while(!vertices1.conjuntoVacio()) {
			int vertice= vertices1.elegir();
			vertices1.sacar(vertice);
			vertices2=g.vertices();
			boolean flag=false;
			while(!vertices2.conjuntoVacio()) {
				int ais=vertices2.elegir();
				vertices2.sacar(ais);
				if(g.existeArista(vertice, ais)||g.existeArista(ais, vertice)) {
					flag=true;
				}
			}
			if(flag==false) {
				c.agregar(vertice);
			}
		}
		return c;
	}
	
	public ConjuntoTDA puentesGrafo(GrafoTDA g,int v1,int v2) {
		ConjuntoTDA c= new ConjuntoEstatica();
		c.inicializarConjunto();
		ConjuntoTDA vertices1= g.vertices();
		while(!vertices1.conjuntoVacio()) {
			int p= vertices1.elegir();
			vertices1.sacar(p);
			if(g.existeArista(v1, p) && g.existeArista(p, v2)) {
				c.agregar(p);
			}
			
		}
		return c;
	}
	
	public int gradoGrafo(GrafoTDA g,int v) {
		int grado=0;
		ConjuntoTDA vertices1= g.vertices();
		while(!vertices1.conjuntoVacio()) {
			int vert= vertices1.elegir();
			vertices1.sacar(vert);
			if(g.existeArista(v,vert)) {
				grado+=1;
			}
			else if(g.existeArista(vert, v)) {
				grado-=1;
			}
			
		}
		return grado;
	}
	
	
}
