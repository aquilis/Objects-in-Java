package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

/**
 * Class testing the utility class Sumator.
 * @author vtsonev
 */
public class SumatorTest {

	/**
	 * Test the sum of two integers.
	 */
	@Test
	public void testIntSum() {
		assertEquals(Sumator.sum(-4, 2), -2);
	}

	/**
	 * Test the sum of two floating point numbers.
	 */
	@Test
	public void testDoubleSum() {
		assertEquals(0.6, Sumator.sum(0.2f, 0.4f), 0.001);
	}

	/**
	 * Test the sum of two string numbers.
	 */
	@Test
	public void testStringSum() {
		assertEquals("3.14", Sumator.sum("3.00", "0.14"));
	}

	/**
	 * Test the sum of two BigIntegers.
	 */
	@Test
	public void testBigIntegerSum() {
		BigInteger expected = new BigInteger("3000");
		assertTrue(expected.equals(Sumator.sum(new BigInteger("1500"),
				new BigInteger("1500"))));
	}

	/**
	 * Test the sum of two BigDecimals.
	 */
	@Test
	public void testBigdecomalSum() {
		BigDecimal expected = new BigDecimal("300.14");
		BigDecimal expected2 = new BigDecimal("-2.0");
		assertEquals(expected,
				Sumator.sum(new BigDecimal("300.0"), new BigDecimal("0.14")));
		assertEquals(expected2,
				Sumator.sum(new BigDecimal("6.0"), new BigDecimal("-8.0")));
	}

}
