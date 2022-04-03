package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.doubleLinkedList;


class TestDoubleLinkedList {
	
	@Test
	void testPush() {
		doubleLinkedList<String> v = new doubleLinkedList<String>();
		v.push("Jeje");
		assertEquals(v.peek(), "Jeje");
	}

	@Test
	void testPull() {
		doubleLinkedList<String> v = new doubleLinkedList<String>();
		v.push("Jeje");
		assertEquals(v.pull(), "Jeje");
	}

	@Test
	void testPeek() {
		doubleLinkedList<String> v = new doubleLinkedList<String>();
		v.push("Jeje");
		assertEquals(v.peek(), "Jeje");
	}

	@Test
	void testCount() {
		doubleLinkedList<String> v = new doubleLinkedList<String>();
		v.push("Jeje");
		assertEquals(v.count(), 1);
		v.pull();
		assertEquals(v.count(), 0);
	}

	@Test
	void testIsEmpty() {
		doubleLinkedList<String> v = new doubleLinkedList<String>();
		v.push("Jeje");
		assertEquals(v.isEmpty(), false);
		v.pull();
		assertEquals(v.isEmpty(), true);
	}
	@Test
	void testInsertAtLast() {
		doubleLinkedList<String> v = new doubleLinkedList<String>();
		v.push("Jeje");
		v.push("hola");
		v.InsertAtLast("como estas");
		assertEquals(v.peek(), "como estas");
	}

	@Test
	void testDeleteLast() {
		doubleLinkedList<String> v = new doubleLinkedList<String>();
		v.push("Jeje");
		v.push("hola");
		v.InsertAtLast("como estas");
		assertEquals(v.peek(), "como estas");
		v.DeleteLast();
		assertEquals(v.peek(), "hola");
	}

	@Test
	void testGetLast() {
		doubleLinkedList<String> v = new doubleLinkedList<String>();
		v.push("Jeje");
		v.push("hola");
		v.InsertAtLast("como estas");
		assertEquals(v.peek(), v.GetLast());
	}

	}


