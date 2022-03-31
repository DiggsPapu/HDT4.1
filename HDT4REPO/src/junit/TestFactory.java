package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.Factory;
import calculator.IStack;

class TestFactory {

	@Test
	void testCreateStack() {
		IStack<String> stack1 = Factory.CreateStack("ArrayList");
		stack1.getClass();
		assertEquals(stack1.isEmpty(),true);
		IStack<String> stack2 = Factory.CreateStack("Vector");
		stack1.getClass();
		assertEquals(stack2.isEmpty(),true);
		IStack<String> stack4 = Factory.CreateStack("hola");
		assertEquals(stack4,null);//Caso en el que es opcion no valida
		
		IStack<String> stack3 = Factory.CreateStack("List");
		stack3.getClass();
		assertEquals(stack3.isEmpty(),true);//Ingrese DoubleLinkedList o LinkedList
		
	}

}
