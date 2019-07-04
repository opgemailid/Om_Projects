package com.om.convertor;

import java.util.Scanner;

public class NumberToWordConvertor {
	public static void main(String[] args) {
		int number = 0;
		NumberToWordConvertor numberToWordConvertor = new NumberToWordConvertor();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any number : ");
		try {
			// input a number
			number = scanner.nextInt();
			if (number == 0) {
				System.out.print("Number in words: Zero");
			} else {
				System.out.print("Number in words: " + numberToWordConvertor.getNumberToWord(number));
			}
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		}

		// closing the scanner
		scanner.close();
	}

	public String getNumberToWord(int number) {
		StringBuilder sb = new StringBuilder();

		String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
				"ninety" };

		if (number == 0) {
			return "Zero";
		}

		// only is case of negative number
		if (number < 0) {

			// convert the number to string
			String numberStr = "" + number;

			// remove minus from number
			numberStr = numberStr.substring(1);

			// start with minus and convert the rest of number
			return "minus " + getNumberToWord(Integer.parseInt(numberStr));
		}

		// check if number is divisible by million
		if ((number / 1000000) > 0) {
			sb.append("" + (getNumberToWord(number / 1000000)) + " million ");
			number = number % 1000000;
		}

		// check if number is divisible by thousand
		if ((number / 1000) > 0) {
			sb.append("" + (getNumberToWord(number / 1000)) + " thousand ");
			number = number % 1000;
		}

		// check if number is divisible by hundred
		if ((number / 100) > 0) {
			sb.append("" + (getNumberToWord(number / 100)) + " hundred and ");
			number = number % 100;
		}

		if (number > 0) {
			// check if number is within teens
			if (number < 20) {
				
				// fetch the respective value from unit array
				sb.append(" "+unitsArray[number]);
			} else {
				
				// fetch the respective value from tens array
				sb.append(tensArray[number / 10]);
				
				if ((number % 10) > 0) {
					sb.append(" "+unitsArray[number % 10]);
				}
			}
		}

		return sb.toString();
	}
}
