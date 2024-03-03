package main.utils;

public class Utility {

	public void encodeTrack1Data()
	{
		
	}
	
	public void decodeTrack1Data(String track1)
	{
		if(track1.length() > 79)
			throw new IllegalArgumentException("Invalid Track-1 Data [Reason : Data Length exceeding 76 characters]..................................[FAILED]");
		
		if(!track1.startsWith("%") && !track1.endsWith("?"))
			throw new IllegalArgumentException("Invalid Track-1 Data [Reason : either String NOT start with '%' or NOT end with '?'].................[FAILED]");
		
		
		String[] segments = track1.substring(2, track1.length()-1).split("\\^");
		

		Track1 data = new Track1();

		data.setFormatCode(track1.charAt(1));
		data.setPrimaryAccountNumber(segments[0]);
		data.setCardHolderName(segments[1]);
		data.setOtherTrackData(segments[2]);
		data.setLRC(encodeLRC_v2(segments));
	
		System.out.println(data);
//		encodeLRC(segments);
	}
	
	public String encodeLRC(String[] segments)
	{
		//	Find max length
		int maxLength = 0;
		for (String s:segments)
			if (Converters.asciiToBinary(s).length() > maxLength)
				maxLength = Converters.asciiToBinary(s).length();

		char[][] charArr = new char[3][maxLength];

		for(int i=0; i<3; i++)
		{
			if(Converters.asciiToBinary(segments[i]).toCharArray().length != maxLength)
			{
				StringBuilder str = new StringBuilder(Converters.asciiToBinary(segments[i]));
				
				for(int j=0;j<32;j++)
					str.append('0');

				charArr[i] = str.toString().toCharArray();
				str.setLength(0);
				continue;
			}
			charArr[i] = Converters.asciiToBinary(segments[i]).toCharArray();
		}
	
		int ptr = 0;
		
//		Do encode Row-wise Parity
		StringBuilder rowPartity = new StringBuilder();		
		for(int i=0;i<3;i++)
		{
			for(int k=0; k<maxLength ; k++)
				if(charArr[i][k] == '1')
					ptr += 1;
			if(ptr != 0 && ptr % 2 == 0)
				rowPartity.append('1');
			else
				rowPartity.append('0');
			ptr = 0;
		}
/*		
		Do encode Column-wise Parity
		
		StringBuilder columnPartity = new StringBuilder();
		for(int k=0; k<maxLength ; k++)
		{
			for (int i=0; i<3; i++)
				if(charArr[i][k] == '1')
					ptr += 1;
			
			if(ptr != 0 && ptr % 2 == 0)
				columnPartity.append('1');
			else
				columnPartity.append('0');
			ptr = 0;
		}
*/
//		System.out.println("Row Parity    : " + rowPartity.toString());
//		System.out.println("Column Parity : " + columnPartity.toString());
		
		return rowPartity.toString();
	}
	
	private String encodeLRC_v2(String[] segments) {
        StringBuilder lrc = new StringBuilder();

        for (String segment : segments) {
            for (char c : segment.toCharArray()) {
                lrc.append(Character.getNumericValue(c));
            }
        }

        int sum = lrc.chars().map(Character::getNumericValue).sum();

        return Integer.toBinaryString(sum % 16);
    }
}