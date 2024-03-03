package main.utils;

public class Track2
{
	private static final char startSentinal = '~';
	private static final char separators = '=';
	private static final char endSentinal = '?';
	
	public String primaryAccountNumber; 
	public String otherTrackData;

	public String LRC; //Longitude Redundancy Check (LRC)
	
	public void setPrimaryAccountNumber(String primaryAccountNumber) {
		this.primaryAccountNumber = primaryAccountNumber;
	}
	
	public void setOtherTrackData(String otherTrackData) {
		this.otherTrackData = otherTrackData;
	}

	public void setLRC(String lRC) {
		LRC = lRC;
	}
}