public class SplayNode<V extends Comparable> {
	   // Parametros
	   private V value;            // valor
	   private SplayNode<V> left;   // hijo izquierdo
	   private SplayNode<V> right;  // hijo derecho

	   
	   // Construcctor, Setters y Getters.
        public SplayNode( V val)
        {
            value  = val;
        }

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public SplayNode<V> getLeft() {
			return left;
		}

		public void setLeft(SplayNode<V> left) {
			this.left = left;
		}

		public SplayNode<V> getRight() {
			return right;
		}

		public void setRight(SplayNode<V> right) {
			this.right = right;
		}
	
}
