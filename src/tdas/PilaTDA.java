package tdas;

public interface PilaTDA {

	public void inicializar(); //Metodo - Accion que puedo hacer 
	// public - siempre
	// tipo de retorno - cualquier tipo de dato.
	// nombre - sin espacios entre medio. 
	// () - Si existe, esta la lista de parametros.
	
	/* La pila tiene que estar inicializada **/
	public void apilar(int valor);
	
	/* La pila no debe estar vacia **/
	public void desapilar();
	
	/* La pila no debe estar vacia **/
	public int tope();
	
	/* La pila tiene que estar inicializada **/
	public boolean estaVacia();
	
}
