package main.utils;

public class Converters {

	public static String asciiToBinary(String ascii)
    {
      StringBuilder bin = new StringBuilder();

      for(int i=0; i<ascii.length(); i++)
      {
        for (int k=3; k>= 0;k--)
        {
          int mask = 1 << k;
          bin.append((((int) ascii.charAt(i)) & mask) != 0 ? 1:0);
        }
        
        if(i == (ascii.length()-1))
        	break;
        else
        	bin.append(" ");
      }
      
      return bin.toString();
    }
	
	public static String asciiToHex(String ascii)
	{
		StringBuilder hex = new StringBuilder();
	     
	    for(int i=0; i< ascii.length();i++)
	    {
	    	hex.append(Integer.toHexString((int) ascii.charAt(i)));
/*	    	
	    	if(i == (ascii.length()-1))
	        	break;
	        else
	        	hex.append(" ");
*/
	    }
	    
	     
	    return hex.toString();
	}
	
	public static String hexToAscii(String hexValue)
	{
		// TODO Auto-generated method stub
		if(hexValue.length() % 2 != 0)
			hexValue = "0" + hexValue;
		
		StringBuilder builder = new StringBuilder();
		for(int i =0;i<hexValue.length();i+=2)
		{
			String str = hexValue.substring(i, i+2);
			int hex = Integer.parseInt(str, 16);
			byte[] bytes = String.valueOf(Character.toChars(hex)).getBytes();
			builder.append(new String(bytes));
		}
		
		return builder.toString();
	}
}
