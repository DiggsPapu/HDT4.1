package calculator;
import java.util.Vector;
public class vector<T> implements IStack<T> {
	private Vector<String> structure;
	
	public vector() {
		this.structure = new Vector<>();
	}
	
	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		structure.add((String) value);
	}

	@Override
	public T pull() {
		// TODO Auto-generated method stub
		return (T) structure.remove(structure.size()-1);
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return (T) structure.get(structure.size()-1);
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
