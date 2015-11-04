public class Splay implements WordSet
{


	private SplayTree<Word> base;

	
	public Splay()
	{
		base = new SplayTree<Word>();
		
	}
	
	public void add(Word wordObject) {
		boolean esta = base.contains(wordObject);
		if(esta) return;
		base.put(wordObject);
	}

	
	public Word get(Word word) {
		boolean esta = base.contains(word);
		
		if(!esta) return null;
		return base.getRoot().getValue(); // Debido a que el valor buscado llega a la cima del arbol, solo se busca el valor de la raiz.
	}

}
