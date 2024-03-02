package main.utils;

public class Formater {

	public static double decodeTransAmt(String txAmt)
	{
	    StringBuffer amt = new StringBuffer(txAmt).delete(0, 1);

	    return Double.parseDouble(amt.toString())/100; 
	}
	   
	public static String encodeTransAmt(double txAmt,
	                                    int indicator,		//	1 for Credit || 0 for Debit
										int length)			//	length of Data Element
	{
		int val = (int) (txAmt * 100);
	    int count = (int) Math.floor(Math.log10(val) + 1);
	     
	    StringBuilder str = new StringBuilder();
	     
	    if(indicator == 1)
	      str.append('C');
	    else
	      str.append('D');
	     
	    if(count != 0)
	      for(int i=0; i<length-count;i++)
	        str.append('0');
	    
	    return str.append(val).toString(); 
    }
}
