package calculator;
import java.util.Scanner;
public class Factory {
	
	/**
	 * Creates a stack based on the option, returns null if its not valid
	 * @param selectedFactory
	 * @return IStack<String> based on the option
	 * @exception null
	 */
	@SuppressWarnings("unchecked")
	public static IStack<String> CreateStack(String selectedFactory) {
		switch (selectedFactory) {
		
		case "Vector":{
//			System.out.print("\nSe ha creado un vector");
			return new vector<>();
		}
		case "ArrayList":{
//			System.out.print("\nSe ha creado un arrayList");
			return new arrayList<>();
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
	public static IList<String> CreateList(String selectedList){
		
		switch(selectedList) {
		
		case "LinkedList": {
			
//			System.out.print("Entro");
			return new linkedList<>();
			
		}
		case "DoubleLinkedList" :{
			
//			System.out.print("Entro a d");
			return new doubleLinkedList<>();
			
		}
		default:{
			
			System.out.print("\nNo es una opcion valida");
			return null;
		}
		
		}
	}
}
