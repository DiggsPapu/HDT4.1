package calculator;
import java.util.LinkedList;
public class linkedList<T> implements IStack<T>, IList<T> {
	
	private LinkedList<String> structure;
	
	public linkedList() {
		structure = new LinkedList<>();
	}
	@Override
	public void InsertAtLast(T value) {
		// TODO Auto-generated method stub
		structure.addLast((String) value);
	}

	@Override
	public T DeleteLast() {
		// TODO Auto-generated method stub
		return (T) structure.removeLast();
	}

	@Override
	public T GetLast() {
		// TODO Auto-generated method stub
		return (T) structure.get(structure.size()-1);
	}

	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		structure.add((String) value);
	}

	@Override
	public T pull() {
		// TODO Auto-generated method stub
		return DeleteLast();
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return GetLast();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return structure.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return structure.isEmpty();
	}

}
