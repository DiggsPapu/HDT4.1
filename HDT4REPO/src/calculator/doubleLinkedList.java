package calculator;
import java.util.LinkedList;
/**
 * 
 * @author Diego Alonzo
 * Aclaracion: se importa la linked list porque linkedlist da todas las operaciones esperables en listas
 * Es decir que tambien realiza las que se esperarian para una lista doblemente linked.
 * https://stackoverflow.com/questions/31365998/is-there-any-doubly-linked-list-implementation-in-java
 * @param <T>
 */
public class doubleLinkedList<T> implements IStack<T>, IList<T> {
	private LinkedList<String> structure;
	
	public doubleLinkedList() {
		this.structure = new LinkedList<>();
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
		return (T) structure.getLast();
	}

	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		InsertAtLast(value);
	}

	@Override
	public T pull() {
		// TODO Auto-generated method stub
		return (T) DeleteLast();
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return (T) GetLast() ;
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
