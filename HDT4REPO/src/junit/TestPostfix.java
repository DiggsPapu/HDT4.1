package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.PostfixCalculator;

class TestPostfix {

	@Test
	void testCalculate() {
		PostfixCalculator calc = new PostfixCalculator("Vector");
		assertEquals(calc.calculate("1+1"), "2.0");
		assertEquals(calc.calculate("(1+2^3)"), "9.0");
		assertEquals(calc.calculate("(33*(24-5/5)"), null);
		assertEquals(calc.calculate("(33*(24-5/5))"), "759.0");
		assertEquals(calc.calculate("1+1)"), null);
		assertEquals(calc.calculate("1++"), null);
		assertEquals(calc.calculate("(1++1)"), null);
		PostfixCalculator calc1 = new PostfixCalculator("ArrayList");
		assertEquals(calc1.calculate("1+1"), "2.0");
		assertEquals(calc1.calculate("(1+2^3)"), "9.0");
		assertEquals(calc1.calculate("(33*(24-5/5)"), null);
		assertEquals(calc1.calculate("(33*(24-5/5))"), "759.0");
		assertEquals(calc1.calculate("1+1)"), null);
		assertEquals(calc1.calculate("1++"), null);
		assertEquals(calc1.calculate("(1++1)"), null);
		
	}

}
