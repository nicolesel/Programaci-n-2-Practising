package tdas;

public interface ColaTDA {

	public void inicializar();
	
	/* la cola debe estar inicializada **/
	public void acolar(int valor);
	
	/* no debe estar vacia **/
	public void desacolar();
	
	/* no debe estar vacia **/
	public int primero();
	
	/* la cola debe estar inicializada **/
	public boolean estaVacia();
	
}
