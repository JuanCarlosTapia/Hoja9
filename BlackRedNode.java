public class BlackRedNode<V  extends Comparable<V>> {
        private V val;         
        private BlackRedNode left, right; 
        private int color;     
        
        
        public BlackRedNode(V val, int color) {
            this.val = val;
            this.color = color;
            
        }


		public V getVal() {
			return val;
		}


		public void setVal(V val) {
			this.val = val;
		}


		public BlackRedNode getLeft() {
			return left;
		}


		public void setLeft(BlackRedNode left) {
			this.left = left;
		}


		public BlackRedNode getRight() {
			return right;
		}


		public void setRight(BlackRedNode right) {
			this.right = right;
		}


		public int getColor() {
			return color;
		}


		public void setColor(int color) {
			this.color = color;
		}
    }
	
