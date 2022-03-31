package calculator;
import java.util.Scanner;
public class Factory {
	
	/**
	 * Creates a stack based on the option, returns null if its not valid
	 * @param selectedFactory
	 * @return IStack<String> based on the option
	 * @exception null
	 */
	public static IStack<String> CreateStack(String selectedFactory) {
		switch (selectedFactory) {
		
		case "Vector":{
			System.out.print("\nSe ha creado un vector");
			return new vector<>();
		}
		case "ArrayList":{
			System.out.print("\nSe ha creado un arrayList");
			return new arrayList<>();
		}
		case "List":{
			IList<String> list = CreateList();
//			System.out.print(list.getClass());
			return (IStack<String>)list;
		}
		default:{
			System.out.print("\nNo ha ingresado una opcion valida");
			return null;
		}
		
		}
		
	}
	/**
	 * Creates a stack based on which kind of list
	 * @return
	 */
	private static IList<String> CreateList(){
		Scanner scan = new Scanner(System.in);
		System.out.print("\nIngrese el tipo de lista (LinkedList, DoubleLinkedList): ");
		String selectedList = scan.nextLine();
		System.out.print(selectedList);
		switch(selectedList) {
		
		case "LinkedList": {
			scan.close();
//			System.out.print("Entro");
			return new linkedList<>();
			
		}
		case "DoubleLinkedList" :{
			scan.close();
//			System.out.print("Entro a d");
			return new doubleLinkedList<>();
			
		}
		default:{
			scan.close();
			System.out.print("\nNo es una opcion valida");
			return null;
		}
		
		}
	}
}
