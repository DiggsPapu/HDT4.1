package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.Calculator;

class TestCalculator {

	@Test
	void testGetInstance() {
		Calculator calc = Calculator.getInstance();
		Calculator calc2 = Calculator.getInstance();
		assertEquals(calc.hashCode(), calc2.hashCode());
	}

	@Test
	void testAdd() {
		Calculator calc = Calculator.getInstance();
		assertEquals(calc.add("293", "532"), "825.0");
		assertEquals(calc.add("fdjs", "532"), null);
	}

	@Test
	void testSubs() {
		Calculator calc = Calculator.getInstance();
		assertEquals(calc.subs("532", "293"), "-239.0");
		assertEquals(calc.subs("532", "2jkl93"), null);
	}

	@Test
	void testMult() {
		Calculator calc = Calculator.getInstance();
		assertEquals(calc.mult("293", "532"), "155876.0");
		assertEquals(calc.mult("293", "5kjl32"), null);
	}

	@Test
	void testDiv() {
		Calculator calc = Calculator.getInstance();
		assertEquals(calc.div("10", "100"), "10.0");
		assertEquals(calc.div("10", "10kl0"), null);
		
	}

	@Test
	void testExp() {
		Calculator calc = Calculator.getInstance();
		assertEquals(calc.exp("3", "2"), "8.0");
		assertEquals(calc.exp("3", "2jkl"), null);
	}

}
