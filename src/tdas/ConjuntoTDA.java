package tdas;

public interface ConjuntoTDA {
	void inicializarConjunto();
	void agregar(int x); //conjuto debe estar inicializado
	void sacar(int x); //conjunto inicializado
	int elegir(); //conjunto inicializado y no vacio
	boolean pertenece(int x); //conjunto inicializado
	boolean conjuntoVacio(); //conjunto inicializado
	void print(); //lo hago para pruebas
}
