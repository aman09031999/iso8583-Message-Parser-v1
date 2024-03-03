package main;

import main.utils.Converters;
//import main.utils.FormatType;
import main.utils.Formater;

public class TestFormaterClass {

	public static final String str = "D00124309";

	public static void main(String[] args)
	{
		//	Meta-Data
		String userInput = fromSource();
//		FormatType type = FormatType.numeric_with_indicator;
//		int length = 8;	
		
		//	Decoding Transaction Amt. for DE-28, 29, 30, 31 or 97
		System.out.println("Decode Transaction Amt. from Hex to Decimal (upto 2-decimal places)");
		System.out.println("User Input (in Hex)	: " + userInput);
		System.out.println("Decode	   (in Decimal)	: " + Formater.decodeTransAmt(userInput));

		System.out.println("\nEncode Transaction Amt. from Decimal (upto 2-decimal places) to Hex");
		
		double txAmt = 1243.09;
		System.out.println("User Input (in Decimal)	: " + txAmt);
		System.out.println("Decode	   (in Hex)	: " + Formater.encodeTransAmt(txAmt, 0, 8));		

	}
	
	public static String fromSource()	{
		return Converters.asciiToHex(str);
	}
}
