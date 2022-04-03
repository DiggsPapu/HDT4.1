package calculator;

public interface IStack<T> {
	public void push(T value);
	
	public T pull();
	
	public T peek();
	
	public int count();
	
	public boolean isEmpty();
}
