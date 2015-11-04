
public class SplayTree<V extends Comparable>
	{

    private SplayNode<V> root ;// raiz
    private SplayNode<V> vacio = new SplayNode<V>( null ); // arbol vacio
    
    
	    // Constructor
	    public SplayTree( )
	    {
	    	root = vacio;
	    }

	    
	    // Metodo que inserta en el arbol
	    public void put( V val )
	    {
	    	
	    	// Se crea un nuevo nodo que tiene el valor a ingresar.
	    	SplayNode<V> nuevoNodo = new SplayNode<V>(val);
            nuevoNodo.setLeft(vacio); 
    		nuevoNodo.setRight(vacio);

    		// Si la raiz esta vacia
            if( root == vacio )
            {
            	root = nuevoNodo; // Ese nodo se vuelve la raiz
            	 
            }
	        else
	        {
	        	
	            
	            
	            int compareResult = val.compareTo( root.getValue() );
	            
	            if( compareResult < 0 )
	            {
	            	// Se mueve la raiz a la derecha del nuevo nodo, y la izquierda de la raiz a la izquierda del nodo
	                nuevoNodo.setLeft(root.getLeft());
	                nuevoNodo.setRight(root);
	                root.setLeft(vacio);
	                root = nuevoNodo;
	                
	                root = splay( val, root );
	            }
	            else
	            if( compareResult > 0 )
	            {
	            	// Se mueve la raiz a la izquierda del nuevo nodo, y la derecha de la raiz a la derecha del nodo
	                nuevoNodo.setRight(root.getRight());
	                nuevoNodo.setLeft(root);
	                root.setRight(vacio);
	                root = nuevoNodo;
	                root = splay( val, root );
	            }
	            else
	                return;   
	        }
	    }

	   

	    // Metodo que revisa si un elemento esta en el arbol
	    public boolean contains( V val)
	    {
	        if( root == vacio)
	            return false;
	        
	        // Se reordena el arbol para que el elemento buscado quede arriba
	        root = splay( val, root );
	        
	        return root.getValue().compareTo(val) == 0;
	    }
	    
	    
	    

	
	  
	   
	    
	    // Este metodo reordena el arbol
	    private SplayNode<V> splay( V val, SplayNode<V> arbol )
	    {
	    	// Se crean arboles temporales que luego forman el nuevo
	        SplayNode<V> izquierda, derecha, cabeza;
	        cabeza  = new SplayNode<V>( null );
	        cabeza.setLeft(vacio);
	        cabeza.setRight(vacio);
	        izquierda = cabeza;
	        derecha = cabeza;
	        vacio.setValue(val);   

	        // Ciclo que termina cuando el arbol termina de reordenarse, cuando el valor que se quiere esta en la raiz.
	        // El arbol analizado cambia con cada hiro.
	        while(true)
	        {
	            int compareResult = val.compareTo( arbol.getValue() );   
	            if( compareResult < 0 )
	            {
	                if( val.compareTo( arbol.getLeft().getValue() ) < 0 )
	                	arbol = girarIzquierda( arbol ); // giro a la izquierda
	                if( arbol.getLeft() == vacio ) 
	                    break;
	                
	                derecha.setLeft(arbol);
	                derecha = arbol;
	                arbol = arbol.getLeft();
	            }
	            else if( compareResult > 0 )
	            {
	                if( val.compareTo( arbol.getRight().getValue() ) > 0 )
	                	arbol = girarDerecha( arbol );
	                if( arbol.getRight() == vacio )
	                    break;
	               
	                izquierda.setRight(arbol);
	                izquierda = arbol;
	                arbol = arbol.getRight();
	            }
	            else
	                break;
	        }    

	        // Se rearma el arbol con los arboles temporales.
	        izquierda.setRight(arbol.getLeft());
	        derecha.setLeft(arbol.getRight());
	        arbol.setLeft(cabeza.getRight());
	        arbol.setRight(cabeza.getLeft());
	        return arbol;
	    }

	   
	    
	    // Metodo que hace que un arbol gire hacia la izquierda, y se devuelve un nuevo arbol
	    public SplayNode<V> girarIzquierda( SplayNode<V> arbol )
	    {
	        SplayNode<V> nuevo = arbol.getLeft();
	        arbol.setLeft(nuevo.getRight());
	        nuevo.setRight(arbol);
	        return nuevo;
	    }

	    
	    // Metodo que hace que un arbol gire hacia la derecha, y se devuelve un nuevo arbol
	    public SplayNode<V> girarDerecha( SplayNode<V> arbol )
	    {
	        SplayNode<V> nuevo = arbol.getRight();
	        arbol.setRight(nuevo.getLeft());
	        nuevo.setLeft(arbol);
	        return nuevo;
	    }

	    
		
		
	    // Getters y Setters.
		public SplayNode<V> getRoot() {
			return root;
		}

		public void setRoot(SplayNode<V> root) {
			this.root = root;
		}

		
	    
	    
	}
	
