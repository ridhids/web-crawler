package com.rnaidu.webcrawler.helper;

//Java program to validate domain name.
//using regular expression.

import java.util.regex.*;
public class ValidDomain {

	// Function to validate domain name.
	public static boolean isValidDomain(String str)
	{
		// Regex to check valid domain name.
		String regex = "^((?!-)[geeksforgeeks]"
					+ "{1,63}(?<!-)\\.)"
					+ "+[A-Za-z]{2,6}";

		// Compile the ReGex
		Pattern p
			= Pattern.compile(regex);

		// If the string is empty
		// return false
		if (str == null) {
			return false;
		}

		// Pattern class contains matcher()
		// method to find the matching
		// between the given string and
		// regular expression.
		Matcher m = p.matcher(str);

		// Return if the string
		// matched the ReGex
		return m.matches();
	}

	// Driver Code
	public static void main(String args[])
	{

		// Test Case 1:
		String str1 = "geeksforgeeks.org";
		System.out.println(isValidDomain(str1));

		// Test Case 2:
		String str2 = "contribute.geeksforgeeks.org";
		System.out.println(isValidDomain(str2));

		// Test Case 3:
		String str3 = "-geeksforgeeks.org";
		System.out.println(isValidDomain(str3));

		// Test Case 4:
		String str4 = "geeksforgeeks.o";
		System.out.println(isValidDomain(str4));

		// Test Case 5:
		String str5 = ".org";
		System.out.println(isValidDomain(str5));
	}
}

