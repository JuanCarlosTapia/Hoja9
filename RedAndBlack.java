public class RedAndBlack implements WordSet
{

	private RedAndBlackTree<Word> base;
	
	public RedAndBlack()
	{
		base = new RedAndBlackTree<Word>();
	}
	
	public void add(Word wordObject) {
		boolean esta = base.contains(wordObject);
		if(esta) return;
		base.put( wordObject);
		
	}

	
	public Word get(Word word) {
		boolean esta = base.contains(word);
		if(!esta) return null;
		return base.get(word);
	}

}
