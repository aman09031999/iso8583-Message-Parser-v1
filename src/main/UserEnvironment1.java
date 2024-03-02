package main;

import main.utils.Converters;
import main.utils.FormatType;
import main.utils.Formater;

public class UserEnvironment1 {

	public static final String str = "D0000000000124309";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//	Meta-Data
		String userInput = fromSource();
		FormatType type = FormatType.numeric_with_indicator;
		int length = 8;		
		
		//	Decoding Transaction Amt. for DE-28, 29, 30, 31 or 97
		System.out.println("User Input (in Hex)	: " + userInput);
		System.out.println("Decode	   (in decimal)	: " + Formater.decodeTransAmt(Converters.hexToAscii(userInput)));
	}
	
	public static String fromSource()	{
		return Converters.asciiToHex(str);
	}
}
