import java.util.HashMap;
import java.util.TreeMap;

public class Treemap implements WordSet
{
	private TreeMap<String,Word> base;
	
	public Treemap()
	{
		base = new TreeMap<String,Word>();
	}
	
	public Word get(Word word){
	
		boolean esta = base.containsKey(word.getWord());
		if(!esta) return null;
		return base.get(word.getWord());
		
	}
	
	public void add(Word wordObject)
	{
		base.putIfAbsent(wordObject.getWord(), wordObject);
		
	}
}
