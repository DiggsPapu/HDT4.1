package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.arrayList;

class TestArrayStack {


	@Test
	void testPush() {
		arrayList<String> array = new arrayList<String>();
		array.push("hola");
		array.push("soy");
		array.push("Diego");
		assertEquals(array.peek(), "Diego");
	}

	@Test
	void testPull() {
		arrayList<String> array = new arrayList<String>();
		array.push("hola");
		array.push("soy");
		array.push("Diego");
		array.pull();
		assertEquals(array.peek(), "soy");
	}

	@Test
	void testPeek() {
		arrayList<String> array = new arrayList<String>();
		array.push("hola");
		array.push("soy");
		array.push("Diego");
		assertEquals(array.peek(), "Diego");
	}

	@Test
	void testCount() {
		arrayList<String> array = new arrayList<String>();
		array.push("hola");
		array.push("soy");
		array.push("Diego");
		assertEquals(array.count(), 3);
	}

	@Test
	void testIsEmpty() {
		arrayList<String> array = new arrayList<String>();
		array.push("hola");
		array.push("soy");
		array.push("Diego");
		assertEquals(array.isEmpty(), false);
		array.pull();
		array.pull();
		array.pull();
		assertEquals(array.isEmpty(), true
				);
		
	}

}
