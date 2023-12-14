package algoritmos;

import java.lang.reflect.Array;
import java.util.Arrays;

import implementacionEstatica.ColaEstatica;
import implementacionEstatica.ColaPrioridadEstatica;
import implementacionEstatica.ConjuntoEstatica;
import implementacionEstatica.PilaEstatica;
import tdas.ColaPrioridadTDA;
import tdas.ColaTDA;
import tdas.ConjuntoTDA;
import tdas.PilaTDA;

public class Algoritmos {

	/*La pila origen esta inicializada**/
	public PilaTDA copioPila(PilaTDA origen) {
		PilaTDA resultado = new PilaEstatica();
		PilaTDA auxiliar = new PilaEstatica();
		resultado.inicializar();
		auxiliar.inicializar();
		
		while(!origen.estaVacia()) {
			auxiliar.apilar(origen.tope());
			origen.desapilar();
		}
		while(!auxiliar.estaVacia()) {
			origen.apilar(auxiliar.tope());
			resultado.apilar(auxiliar.tope());
			auxiliar.desapilar();
		}
		
		return resultado;
	}
	
	public void mostrarPila(PilaTDA origen) {
		PilaTDA auxPila = new PilaEstatica();
		auxPila.inicializar();
		while(!origen.estaVacia()) {
			System.out.println(origen.tope());
			auxPila.apilar(origen.tope());
			origen.desapilar();
		}
		while(!auxPila.estaVacia()) {
			origen.apilar(auxPila.tope());
			auxPila.desapilar();
		}
	}
	
	public PilaTDA generarPila(int cantidadValores) {
		PilaTDA resultado = new PilaEstatica();
		resultado.inicializar();
		for(int i=0; i< cantidadValores; i++) {
			resultado.apilar(i);
		}
		return resultado;
	}

	public PilaTDA pasarPila(PilaTDA origen) {
		PilaTDA resultado = new PilaEstatica();
		resultado.inicializar();
		
		while(!origen.estaVacia()) {
			resultado.apilar(origen.tope());
			origen.desapilar();
		}
		
		return resultado;
	}
	
	public void invertirPila(PilaTDA origen) {
		PilaTDA aux1 = new PilaEstatica();
		PilaTDA aux2 = new PilaEstatica();
		aux1.inicializar();
		aux2.inicializar();
		
		while(!origen.estaVacia()) {
			aux1.apilar(origen.tope());
			origen.desapilar();
		}
		while(!aux1.estaVacia()) {
			aux2.apilar(aux1.tope());
			aux1.desapilar();
		}
		while(!aux2.estaVacia()) {
			origen.apilar(aux2.tope());
			aux2.desapilar();
		}
		
	}
	
	public int sizePila(PilaTDA auxPila1) {
		int contador=0;
		PilaTDA aux= new PilaEstatica();
		aux.inicializar();
		while(!auxPila1.estaVacia()) {
			aux.apilar(auxPila1.tope());
			auxPila1.desapilar();
			contador++;
		}
		while(!aux.estaVacia()) {
			auxPila1.apilar(aux.tope());
			aux.desapilar();
		}
		return contador;
	}
	
	public int sumarPila(PilaTDA auxPila1) {
		int contador=0;
		PilaTDA aux= new PilaEstatica();
		aux.inicializar();
		while(!auxPila1.estaVacia()) {
			aux.apilar(auxPila1.tope());
			contador+=auxPila1.tope();
			auxPila1.desapilar();
		}
		while(!aux.estaVacia()) {
			auxPila1.apilar(aux.tope());
			aux.desapilar();
		}
		return contador;
	}
	
	public float avgPila(PilaTDA auxPila1) {
		int contador=0;
		int size=0;
		PilaTDA aux= new PilaEstatica();
		aux.inicializar();
		while(!auxPila1.estaVacia()) {
			aux.apilar(auxPila1.tope());
			contador+=auxPila1.tope();
			size++;
			auxPila1.desapilar();
		}
		while(!aux.estaVacia()) {
			auxPila1.apilar(aux.tope());
			aux.desapilar();
		}
		return (float)contador/size;
	}
	
	public boolean capicuaPila(PilaTDA pila) {
		PilaTDA aux= this.copioPila(pila);
		this.invertirPila(aux);
		boolean flag=true;
		while(!pila.estaVacia()) {
			if(pila.tope()!=aux.tope()) {
				flag=false;
				break;
			}
			pila.desapilar();
			aux.desapilar();
		}
		return flag;
	}
	
	public void quitarRepetidosPila(PilaTDA pila) {
		int size = this.sizePila(pila);
		int [] array= new int [size];
		int i=0;
		while(!pila.estaVacia()) {
			array[i]=pila.tope();
			i++;
			pila.desapilar();
		}
		for(i=0;i<size;i++) {
			boolean flag=true;
			for(int k=i-1; k>=0;k--) {
				if(array[k]==array[i]) {
					flag=false;
					break;
				}
			}
			if(flag) {
				pila.apilar(array[i]);
			}
		}
	}
	
	public void repartirPila(PilaTDA pilapar) {
		int size= this.sizePila(pilapar);
		PilaTDA aux= this.copioPila(pilapar);
		int[] m1= new int[size/2];
		int[] m2= new int[size/2];
		int i=0;
		boolean flag=true;
		while(!aux.estaVacia()) {
			if((size/2)>i && flag) {
				m1[i]=aux.tope();
			}
			else {
				if(flag) {
					flag=false;
					i=0;
				}
				m2[i]=aux.tope();
			}
			i++;
			aux.desapilar();
		}
		System.out.println(Arrays.toString(m1)+"\n"+Arrays.toString(m2));
	}
	
	public void repetidosPila(PilaTDA pila) {
		PilaTDA aux= this.copioPila(pila);
		int size= this.sizePila(pila);
		int[] array= new int[size];
		for(int i=0;i<size;i++) {
			array[i]=aux.tope();
			aux.desapilar();
		}
		for(int i=0;i<size;i++) {
			if(repetidoEnArrayPila(array,array[i])) {
				if(!estaEnLaPila(aux,array[i])) {
					aux.apilar(array[i]);
				}
			}
		}
		System.out.println("Repetidos de la pila: ");
		this.mostrarPila(aux);
	}
	
	public boolean repetidoEnArrayPila(int[] array, int elemento) {
		int cant=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]==elemento) {
				cant++;
			}
		}
		if(cant>1) {
			return true;
		}
		return false;
	}
	
	public boolean estaEnLaPila(PilaTDA pila, int elemento) {
		PilaTDA aux= this.copioPila(pila);
		while(!aux.estaVacia()) {
			if(aux.tope()==elemento) {
				return true;
			}
			aux.desapilar();
		}
		return false;
	}
	
	/*La cola origen esta inicializada**/
	public ColaTDA copioCola(ColaTDA origen) {
		ColaTDA resultado = new ColaEstatica();
		ColaTDA auxiliar = new ColaEstatica();
		resultado.inicializar();
		auxiliar.inicializar();
		
		while(!origen.estaVacia()) {
			auxiliar.acolar(origen.primero());
			origen.desacolar();
		}
		while(!auxiliar.estaVacia()) {
			origen.acolar(auxiliar.primero());
			resultado.acolar(auxiliar.primero());
			auxiliar.desacolar();
		}
		
		return resultado;
	}
	
	public ColaTDA pasarCola(ColaTDA origen) {
		ColaTDA resultado = new ColaEstatica();
		resultado.inicializar();
		
		while(!origen.estaVacia()) {
			resultado.acolar(origen.primero());
			origen.desacolar();
		}
		
		return resultado;
	}
	
	public void mostrarCola(ColaTDA origen) {
		ColaTDA auxCola = new ColaEstatica();
		auxCola.inicializar();
		while(!origen.estaVacia()) {
			System.out.println(origen.primero());
			auxCola.acolar(origen.primero());
			origen.desacolar();
		}
		while(!auxCola.estaVacia()) {
			origen.acolar(auxCola.primero());
			auxCola.desacolar();
		}
	}
	
	public ColaTDA generarCola(int cantidadValores) {
		ColaTDA resultado = new ColaEstatica();
		resultado.inicializar();
		for(int i=0;i<cantidadValores;i++) {
			resultado.acolar(i);
		}
		return resultado;
	}

	public void invertirCola(ColaTDA auxCola1) {
		PilaTDA aux = new PilaEstatica();
		aux.inicializar();
		
		while(!auxCola1.estaVacia()) {
			aux.apilar(auxCola1.primero());
			auxCola1.desacolar();
		}
		while(!aux.estaVacia()) {
			auxCola1.acolar(aux.tope());
			aux.desapilar();
		}
		
	}
	
	public void invertirColaC(ColaTDA auxCola1) {
		int size = this.sizeCola(auxCola1);
		int [] array= new int[size];
		
		int i=0;
		
		while(!auxCola1.estaVacia()) {
			array[i]=auxCola1.primero();
			auxCola1.desacolar();
			i++;
		}
		for(i--;i>=0;i--) {
			auxCola1.acolar(array[i]);
		}
	}
	

	private int sizeCola(ColaTDA auxCola1) {
		ColaTDA aux = this.copioCola(auxCola1);
		int size=0;
		while(!aux.estaVacia()) {
			aux.desacolar();
			size++;
		}
		return size;
	}

	public boolean coincidenColas(ColaTDA auxCola1, ColaTDA auxCola2) {
		ColaTDA aux1= this.copioCola(auxCola1);
		ColaTDA aux2= this.copioCola(auxCola2);

		int ultimo1=0;
	
		int ultimo2=0;
		
		while(!aux1.estaVacia()) {
			ultimo1=aux1.primero();
			System.out.println(ultimo1);
			aux1.desacolar();
		}
		
		while(!aux2.estaVacia()) {
			ultimo2=aux2.primero();
			System.out.println(ultimo2);
			aux2.desacolar();
		}
		System.out.println("ul1:"+ ultimo1+"ul2:"+ultimo2);
		return ultimo1==ultimo2;
	}

	public boolean esCapicuaCola(ColaTDA cola) {
		ColaTDA copia= this.copioCola(cola);
		this.invertirCola(copia);
		boolean flag = true;
		while(!cola.estaVacia()) {
			if(cola.primero()!=copia.primero()) {
				flag=false;
				break;
			}
			cola.desacolar();
			copia.desacolar();
		}
		return flag;
	}
	
	public boolean esInversoCola(ColaTDA cola, ColaTDA cola2) {
		this.invertirCola(cola2);
		boolean flag = true;
		while(!cola.estaVacia()) {
			if(cola.primero()!=cola2.primero()) {
				flag=false;
				break;
			}
			cola.desacolar();
			cola2.desacolar();
		}
		if(!cola2.estaVacia()) {
			flag= false;
		}
		return flag;
	}
	
	public void quitarRepetidosCola(ColaTDA cola) {
		ColaTDA aux = new ColaEstatica();
		aux.inicializar();
		while(!cola.estaVacia()) {
			aux.acolar(cola.primero());
			cola.desacolar();
		}
		while(!aux.estaVacia()) {
			if(!this.estaEnLaCola(cola, aux.primero())) {
				cola.acolar(aux.primero());
			}
			aux.desacolar();
		}
	}

	public boolean estaEnLaCola(ColaTDA cola,int elemento) {
		ColaTDA aux= this.copioCola(cola);
		while(!aux.estaVacia()) {
			if(aux.primero()==elemento) {
				return true;
			}
			aux.desacolar();
		}
		return false;
	}

	public void repartirCola(ColaTDA cola) {
		int size= this.sizeCola(cola);
		ColaTDA aux= this.copioCola(cola);
		int[] m1= new int[size/2];
		int[] m2= new int[size/2];
		
		for(int i=0;i<size/2;i++) {
			m1[i]=aux.primero();
			aux.desacolar();
		}
		for(int i=0;i<size/2;i++) {
			m2[i]=aux.primero();
			aux.desacolar();
		}
		System.out.println("m1= "+Arrays.toString(m1));
		System.out.println("m2= "+Arrays.toString(m2));
		
	}
	
	public void repetidosCola(ColaTDA cola) {
		int size= this.sizeCola(cola);
		int [] arrayOriginal= new int [size];
		ColaTDA aux= this.copioCola(cola);
		
		for(int i=0;i<size;i++) {
			arrayOriginal[i]=aux.primero();
			aux.desacolar();
		}
		for(int i=0;i<size;i++) {
			if(repetidoEnArrayCola(arrayOriginal,arrayOriginal[i])) {
				if(!estaEnLaCola(aux,arrayOriginal[i])) {
					aux.acolar(arrayOriginal[i]);
				}
			}
		}
		System.out.println("Repetidos de la cola: ");
		this.mostrarCola(aux);
	}

	private boolean repetidoEnArrayCola(int[] array, int elemento) {
		int cant=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]==elemento) {
				cant++;
			}
		}
		if(cant>1) {
			return true;
		}
		return false;
	}

	
	//COLA CON PRIORIDAD 
	
	public ColaPrioridadTDA unirColaPrioridad (ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
		ColaPrioridadTDA unir= new ColaPrioridadEstatica();
		unir.inicializarCola();
		while(!cola1.colaVacia()) {
			unir.acolar(cola1.primero(), cola1.prioridad());
			cola1.desacolar();
		}
		while(!cola2.colaVacia()) {
			unir.acolar(cola2.primero(), cola2.prioridad());
			cola2.desacolar();
		}
		return unir;
	}
	
	public boolean sonIgualesColaPrioridad (ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
		boolean iguales=true;
		while(!cola1.colaVacia()) {
			if(cola1.primero()!=cola2.primero() || cola1.prioridad()!=cola1.prioridad()) {
				iguales=false;
			}
			cola1.desacolar();
			cola2.desacolar();
		}
		if(!cola2.colaVacia()) {
			iguales=false;
		}
		return iguales;
	}
	
	
	//CONJUNTOS
	
	public ConjuntoTDA copiaConjunto (ConjuntoTDA con) {
		ConjuntoTDA result = new ConjuntoEstatica();
		ConjuntoTDA aux = new ConjuntoEstatica();
		result.inicializarConjunto();
		aux.inicializarConjunto();
		while(!con.conjuntoVacio()) {
    		int valor= con.elegir();
    		result.agregar(valor);
    		aux.agregar(valor);
    		con.sacar(valor);
		}
		while(!aux.conjuntoVacio()) {
    		int valor= aux.elegir();
    		con.agregar(valor);
    		aux.sacar(valor);
		}
		return result;
	}
	
	public ConjuntoTDA unionConjunto (ConjuntoTDA con1,ConjuntoTDA con2) {
		ConjuntoTDA con3 = new ConjuntoEstatica();
	    con3.inicializarConjunto();
	    ConjuntoTDA conj1= copiaConjunto(con1);
	    ConjuntoTDA conj2= copiaConjunto(con2);
	    while(!conj1.conjuntoVacio() || !conj2.conjuntoVacio()) {
	    	if(!conj1.conjuntoVacio()) {
	    		int valor= conj1.elegir();
	    		con3.agregar(valor);
	    		conj1.sacar(valor);
	    	}
	    	if(!conj2.conjuntoVacio()) {
	    		int valor= conj2.elegir();
	    		con3.agregar(valor);
	    		conj2.sacar(valor);
	    	}
	    }
	    return con3;
	}
	
	public ConjuntoTDA interseccionConjunto (ConjuntoTDA con1,ConjuntoTDA con2) {
		ConjuntoTDA con3 = new ConjuntoEstatica();
	    con3.inicializarConjunto();
	    ConjuntoTDA conj1= copiaConjunto(con1);
	    ConjuntoTDA conj2= copiaConjunto(con2);
	    while(!conj1.conjuntoVacio()) {
    		int valor= conj1.elegir();
    		if(conj2.pertenece(valor))
    			con3.agregar(valor);
    		conj1.sacar(valor);
    
	    }
	    return con3;
	}
	
	public ConjuntoTDA diferenciaConjunto (ConjuntoTDA con1,ConjuntoTDA con2) {
		ConjuntoTDA con3 = new ConjuntoEstatica();
	    con3.inicializarConjunto();
	    ConjuntoTDA conj1= copiaConjunto(con1);
	    ConjuntoTDA conj2= copiaConjunto(con2);
	    while(!conj1.conjuntoVacio()) {
    		int valor= conj1.elegir();
    		if(!conj2.pertenece(valor))
    			con3.agregar(valor);
    		conj1.sacar(valor);
    
	    }
	    return con3;
	}
	
	public ConjuntoTDA diferenciaSimetricaConjunto (ConjuntoTDA con1,ConjuntoTDA con2) {
		ConjuntoTDA con3 = new ConjuntoEstatica();
	    con3.inicializarConjunto();
	    ConjuntoTDA conj1= copiaConjunto(con1);
	    ConjuntoTDA conj2= copiaConjunto(con2);
	    while(!conj1.conjuntoVacio() || !conj2.conjuntoVacio()) {
	    	if(!conj1.conjuntoVacio()) {
	    		int valor= conj1.elegir();
	    		if(!con2.pertenece(valor))
	    			con3.agregar(valor);
	    		conj1.sacar(valor);
	    	}
	    	if(!conj2.conjuntoVacio()) {
	    		int valor= conj2.elegir();
	    		if(!con1.pertenece(valor))
	    			con3.agregar(valor);
	    		conj2.sacar(valor);
	    	}
	    }
	    return con3;
	}
	
	public ConjuntoTDA diferenciaSimetricaConjunto2 (ConjuntoTDA con1,ConjuntoTDA con2) { //con metodos 
	    ConjuntoTDA union= unionConjunto(con1,con2);
	    ConjuntoTDA interseccion= interseccionConjunto(con1,con2);
	    ConjuntoTDA difSim= diferenciaConjunto(union,interseccion);
	    return difSim;
	}
	
	public boolean sonIgualesConjunto (ConjuntoTDA con1,ConjuntoTDA con2) {
	    ConjuntoTDA conj1= copiaConjunto(con1);
	    ConjuntoTDA conj2= copiaConjunto(con2);
	    boolean flag=true;
	    while(!conj1.conjuntoVacio() && flag) {
	    	int valor= conj1.elegir();
    		if(!conj2.pertenece(valor))
    			flag=false;
    		conj1.sacar(valor);
    		conj2.sacar(valor);
	    }
	    if(!conj2.conjuntoVacio())
	    	flag=false;
	    return flag;
	}
	
	public int cardinalidadConjunto (ConjuntoTDA con) {
		int cant=0;
		
		ConjuntoTDA copia= copiaConjunto(con);
		while(!copia.conjuntoVacio()) {
			copia.sacar(copia.elegir());
			cant++;
		}
		return cant;
	}
	
	public ConjuntoTDA juntarPilaYColaEnConjunto (PilaTDA pilaOriginal, ColaTDA colaOriginal) {
		ConjuntoTDA con= new ConjuntoEstatica();
		con.inicializarConjunto();
		PilaTDA pila= copioPila(pilaOriginal);
		ColaTDA cola= copioCola(colaOriginal);
			
		while(!pila.estaVacia()) {
			con.agregar(pila.tope());
			pila.desapilar();
		}
		while(!cola.estaVacia()) {
			con.agregar(cola.primero());
			cola.desacolar();
		}
		return con;
	}
	
	public boolean sonIgualesPilaColaConjunto (PilaTDA pilaOriginal, ColaTDA colaOriginal) {
		ConjuntoTDA pilaCon= new ConjuntoEstatica();
		ConjuntoTDA colaCon= new ConjuntoEstatica();
		pilaCon.inicializarConjunto();
		colaCon.inicializarConjunto();
		
		PilaTDA pila= copioPila(pilaOriginal);
		ColaTDA cola= copioCola(colaOriginal);
		
		while(!pila.estaVacia()) {
			pilaCon.agregar(pila.tope());
			pila.desapilar();
		}
		while(!cola.estaVacia()) {
			colaCon.agregar(cola.primero());
			cola.desacolar();
		}
		return sonIgualesConjunto(pilaCon,colaCon);
	}
	

	
}
