package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.vector;

class TestVector {


	@Test
	void testPush() {
		vector<String> v = new vector<String>();
		v.push("Jeje");
		assertEquals(v.peek(), "Jeje");
	}

	@Test
	void testPull() {
		vector<String> v = new vector<String>();
		v.push("Jeje");
		assertEquals(v.pull(), "Jeje");
	}

	@Test
	void testPeek() {
		vector<String> v = new vector<String>();
		v.push("Jeje");
		assertEquals(v.peek(), "Jeje");
	}

	@Test
	void testCount() {
		vector<String> v = new vector<String>();
		v.push("Jeje");
		assertEquals(v.count(), 1);
		v.pull();
		assertEquals(v.count(), 0);
	}

	@Test
	void testIsEmpty() {
		vector<String> v = new vector<String>();
		v.push("Jeje");
		assertEquals(v.isEmpty(), false);
		v.pull();
		assertEquals(v.isEmpty(), true);
	}

}
