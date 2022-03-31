package calculator;

public interface IList<T> {
	public void InsertAtStart(T value);
	
	public T DeleteAtStart();
	
	public T GetAtStart();
	
	public boolean isEmpty();
	
	public int count();
}
