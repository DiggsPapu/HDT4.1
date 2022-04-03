package calculator;

public interface IList<T> {
	public void InsertAtLast(T value);
	
	public T DeleteLast();
	
	public T GetLast();
	
	public boolean isEmpty();
	
	public int count();
}
