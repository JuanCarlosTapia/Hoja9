
public class RedAndBlackTree<V  extends Comparable<V>> {

    private BlackRedNode root;    


    
    public RedAndBlackTree() {
    }

   
   
 
    public V get( V val) {
    	BlackRedNode NodoARevisar = root;
        while (NodoARevisar != null) {
        
            int comparacion = val.compareTo((V) NodoARevisar.getVal());
            
            if      (comparacion < 0) NodoARevisar = NodoARevisar.getLeft();
            else if (comparacion > 0) NodoARevisar = NodoARevisar.getRight();
            else              return (V) NodoARevisar.getVal();
        }
        return null;
    }

   
    public boolean contains(V val) {
    	if (get(val) == null)
    		return false;
        return true;
    }

 
    public void put(V val) {
        root = NuevoArbol(root, val);
        root.setColor(1);
    }

    private BlackRedNode NuevoArbol(BlackRedNode nodo, V val) { 
        if (nodo == null) return 
        	new BlackRedNode(val, 1);

        int cmp = val.compareTo((V) nodo.getVal());
        if  (cmp < 0) 
        	nodo.setLeft(NuevoArbol(nodo.getLeft(), val));
        else if (cmp > 0) 
        	nodo.setRight(NuevoArbol(nodo.getRight(), val)) ; 
        else             
        	nodo.setVal(val); 
        
        if((nodo.getRight() !=null) && (nodo.getLeft()!=null))       
        	if ((nodo.getRight().getColor()==1) && (nodo.getLeft().getColor()==0))    
	        	nodo = girarIzquierda(nodo);
	     
        if((nodo.getLeft()!=null) && nodo.getLeft().getLeft() !=null)  
	        if ((nodo.getLeft().getColor()==1)  &&  (nodo.getLeft().getLeft().getColor()==1)) 
	        	nodo = girarDerecha(nodo);
        
        if((nodo.getRight() !=null) && (nodo.getLeft()!=null))  
	        if ((nodo.getLeft().getColor()==1)  &&  (nodo.getRight().getColor()==1))     
	        	CambiarColores(nodo);
        
     

        return nodo;
    }   // && (nodo.getLeft().getLeft()!=null))  



  
   


    private BlackRedNode girarDerecha(BlackRedNode nodo) {
    	BlackRedNode nuevo = nodo.getLeft();
    	nodo.setLeft(nuevo.getRight());
    	nuevo.setRight(nodo);
    	nuevo.setColor(nuevo.getRight().getColor());
    	nuevo.getRight().setColor(1);
        return nuevo;
    }

    private BlackRedNode girarIzquierda(BlackRedNode nodo){ 
    	BlackRedNode nuevo = nodo.getRight();
    	nodo.setRight(nuevo.getLeft());
        nuevo.setLeft(nodo);
        nuevo.setColor(nuevo.getLeft().getColor());
        nuevo.getLeft().setColor(1);
        return nuevo;
    }

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
