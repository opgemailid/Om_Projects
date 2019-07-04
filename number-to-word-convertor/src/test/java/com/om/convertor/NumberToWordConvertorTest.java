package com.om.convertor;

import junit.framework.TestCase;

/**
 * Unit test for NumberToWordConvertor.
 */
public class NumberToWordConvertorTest extends TestCase {

	public NumberToWordConvertorTest(String testName) {
		super(testName);
	}

	public void testGetNumberToWord() {
		NumberToWordConvertor numberToWordConvertor = new NumberToWordConvertor();
		
		String numberToWord = numberToWordConvertor.getNumberToWord(1);
		assertEquals(" one", numberToWord);
		
		numberToWord = numberToWordConvertor.getNumberToWord(21);
		assertEquals("twenty one", numberToWord);
		
		numberToWord = numberToWordConvertor.getNumberToWord(105);
		assertEquals(" one hundred and  five", numberToWord);
		
		
		numberToWord = numberToWordConvertor.getNumberToWord(56945781);
		assertEquals("fifty six million  nine hundred and forty five thousand  seven hundred and eighty one", numberToWord);
	}
}
