package main.utils;

public class Track1 extends Track2
{
	private static final char startSentinal = '%';
	private static final char separators = '^';
	
	private char formatCode;
	private String cardHolderName;

	
	public void setFormatCode(char formatCode) {
		this.formatCode = formatCode;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;

	}
	@Override
	public String toString() {
		return "Track1 [formatCode=" + formatCode + ", cardHolderName=" + cardHolderName + ", primaryAccountNumber="
				+ primaryAccountNumber + ", otherTrackData=" + otherTrackData + ", LRC=" + LRC + "]";
	}
	
	
}