package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.linkedList;

class TestLinkedList {


	@Test
	void testPush() {
		linkedList<String> v = new linkedList<String>();
		v.push("Jeje");
		assertEquals(v.peek(), "Jeje");
	}

	@Test
	void testPull() {
		linkedList<String> v = new linkedList<String>();
		v.push("Jeje");
		assertEquals(v.pull(), "Jeje");
	}

	@Test
	void testPeek() {
		linkedList<String> v = new linkedList<String>();
		v.push("Jeje");
		assertEquals(v.peek(), "Jeje");
	}

	@Test
	void testCount() {
		linkedList<String> v = new linkedList<String>();
		v.push("Jeje");
		assertEquals(v.count(), 1);
		v.pull();
		assertEquals(v.count(), 0);
	}

	@Test
	void testIsEmpty() {
		linkedList<String> v = new linkedList<String>();
		v.push("Jeje");
		assertEquals(v.isEmpty(), false);
		v.pull();
		assertEquals(v.isEmpty(), true);
	}
	@Test
	void testInsertAtLast() {
		linkedList<String> v = new linkedList<String>();
		v.push("Jeje");
		v.push("hola");
		v.InsertAtLast("como estas");
		assertEquals(v.peek(), "como estas");
	}

	@Test
	void testDeleteLast() {
		linkedList<String> v = new linkedList<String>();
		v.push("Jeje");
		v.push("hola");
		v.InsertAtLast("como estas");
		assertEquals(v.peek(), "como estas");
		v.DeleteLast();
		assertEquals(v.peek(), "hola");
	}

	@Test
	void testGetLast() {
		linkedList<String> v = new linkedList<String>();
		v.push("Jeje");
		v.push("hola");
		v.InsertAtLast("como estas");
		assertEquals(v.peek(), v.GetLast());
	}

}
