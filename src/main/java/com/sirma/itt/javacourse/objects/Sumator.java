package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A utility class implemeting methods for finding the sum of different data
 * types and numeric classes.
 */
public final class Sumator {
	/**
	 * private constructor.
	 */
	private Sumator() {
	}

	/**
	 * Finds the sum of two primitive integers.
	 * 
	 * @param a
	 *            Ineteger var
	 * @param b
	 *            Integer var
	 * @return the sum of a and b
	 */
	public static int sum(int a, int b) {
		return a + b;
	}

	/**
	 * Finds the sum of two floating-point variabls.
	 * 
	 * @param a
	 *            Float var
	 * @param b
	 *            Float var
	 * @return the sum of a and b
	 */
	public static float sum(float a, float b) {
		return a + b;
	}

	/**
	 * Finds the sum of two numbers represented as strings.
	 * 
	 * @param a
	 *            is a number represented as a string
	 * @param b
	 *            is a number represented a a string
	 * @return the sum of a and b
	 */
	public static String sum(String a, String b) {
		double temp = Double.parseDouble(a) + Double.parseDouble(b);
		return Double.toString(temp);
	}

	/**
	 * Finds the sum of two Big integers.
	 * 
	 * @param a
	 *            BigInteger instance
	 * @param b
	 *            BigIntegre instance
	 * @return the sum of a a nd b
	 */
	public static BigInteger sum(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	/**
	 * Finds the sum of two Big decimals.
	 * 
	 * @param a
	 *            BigDecimal instance
	 * @param b
	 *            BigDecimal instance
	 * @return the sum of a and b
	 */
	public static BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}
}
