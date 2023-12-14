package tdas;

public interface ColaPrioridadTDA {
	void inicializarCola();
	void acolar(int x,int prioridad); //cola inicializada
	void desacolar(); //cola inicializasa y no vacia
	int primero(); //cola inicializada y no vacia
	int prioridad(); //cola inicializada y no vacia
	boolean colaVacia(); //cola inicializada
	void print();


}
