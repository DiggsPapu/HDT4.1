package calculator;
import java.util.ArrayList;
public class arrayList<T> implements IStack<T> {
	
	private ArrayList<String> structure;
	
	public arrayList() {
		this.structure = new ArrayList<String>();
	}
	/**
	 * Adds the element at the end of the arrayList
	 * @param value, value that is anything
	 * @return none, is void
	 */
	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		structure.add((String) value);
	}
	/**
	 * Removes the last element of the arrayList.
	 * @param none, it just returns the last element.
	 * @return generic, it returns the element.
	 */
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
