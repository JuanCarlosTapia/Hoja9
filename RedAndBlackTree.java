


public class RedAndBlackTree<V  extends Comparable<V>> {

    private BlackRedNode root;    


    
    public RedAndBlackTree() {
    }

   
   
    // Funcion que devuelve un valor buscado.
    public V get( V val) {
    	BlackRedNode NodoARevisar = root;
     
    	// Este ciclo revisa las posiciones del arbol, hasta que recorre las ramas donde podria estar el valor buscado.
    	while (NodoARevisar != null) {
    		
    		// Dependiendo de la comparacion, se va a la izquierda o derecha
            int comparacion = val.compareTo((V) NodoARevisar.getVal());
            
            if (comparacion < 0) 
            	NodoARevisar = NodoARevisar.getLeft(); // Se pone como nodo a revisar, al hijo izquierdo
            else if (comparacion > 0) 
            	NodoARevisar = NodoARevisar.getRight(); // Se pone como nodo a revisar, al hijo izquierdo
            else              
            	return (V) NodoARevisar.getVal(); // Cuando la comparacion es 0, se devuelve el valo encontrado.
        }
        return null;
    }

   // Funcion que devuelve si un valor esta en el arbol
    public boolean contains(V val) {
    	if (get(val) == null) // Se llama a la funcion get, la cual devuelve null si no lo encontro.
    		return false;
        return true;
    }

 // Metodo que ingresa un nuevo valor
    public void put(V val) {
    	// Se llama a una funcion que mete el valor, y balancea el arbol.
        root = NuevoArbol(root, val);
        root.setColor(1);
    }

    private BlackRedNode NuevoArbol(BlackRedNode nodo, V val) { 
    	// El arbol no puede estar vacio.
        if (nodo == null) 
        	return 
        
        // Se crea un nuevo nodo rojo
        new BlackRedNode(val, 1);

        // Dependiendo de la comparacion, se inserta a la derecha o izquierda.
        int cmp = val.compareTo((V) nodo.getVal());
        if  (cmp < 0) 
        	nodo.setLeft(NuevoArbol(nodo.getLeft(), val));
        else if (cmp > 0) 
        	nodo.setRight(NuevoArbol(nodo.getRight(), val)) ; 
        else             
        	nodo.setVal(val); 
        
        
        // Dependiendo de las condiciones, y de que los nodos si tengan hijos, se hacen giros y cambio de colores. ESto balancea el arbol
        if((nodo.getRight() !=null) && (nodo.getLeft()!=null))       
        	if ((nodo.getRight().getColor()==1) && (nodo.getLeft().getColor()==0))     // Si el hijo derecho es rojo y el izquierdo negro, se hira a la derecha
	        	nodo = girarIzquierda(nodo);
	     
        if((nodo.getLeft()!=null) && nodo.getLeft().getLeft() !=null)   
	        if ((nodo.getLeft().getColor()==1)  &&  (nodo.getLeft().getLeft().getColor()==1))  // Si hay rojos seguidos, se gira a la derecha.
	        	nodo = girarDerecha(nodo);
        
        if((nodo.getRight() !=null) && (nodo.getLeft()!=null))  
	        if ((nodo.getLeft().getColor()==1)  &&  (nodo.getRight().getColor()==1))     // Si ambos hijos son rojos, se cambia los colores.
	        	CambiarColores(nodo);
        
     

        return nodo; // SE devuelve el nuevo arbol
    }   



  
   

    // MEtodo que gira a la derecha un arbol, y devuelve el nuevo arbol
    private BlackRedNode girarDerecha(BlackRedNode nodo) {
    	BlackRedNode nuevo = nodo.getLeft();
    	nodo.setLeft(nuevo.getRight());
    	nuevo.setRight(nodo);
    	nuevo.setColor(nuevo.getRight().getColor());
    	nuevo.getRight().setColor(1);
        return nuevo;
    }


    // MEtodo que gira a la izquierda un arbol, y devuelve el nuevo arbol
    private BlackRedNode girarIzquierda(BlackRedNode nodo){ 
    	BlackRedNode nuevo = nodo.getRight();
    	nodo.setRight(nuevo.getLeft());
        nuevo.setLeft(nodo);
        nuevo.setColor(nuevo.getLeft().getColor());
        nuevo.getLeft().setColor(1);
        return nuevo;
    }

    // Metodo que cambia los colores de un nodo y de sus hijos.
    private void CambiarColores(BlackRedNode nodo) {
    	if (nodo.getColor()==0)
    		nodo.setColor(1);
    	else
    		nodo.setColor(0);
    	
    	if (nodo.getLeft().getColor()==0)
    		nodo.getLeft().setColor(1);
    	else
    		nodo.getLeft().setColor(0);
    	
    	if (nodo.getRight().getColor()==0)
    		nodo.getRight().setColor(1);
    	else
    		nodo.getRight().setColor(0);
        
    }
    
}
