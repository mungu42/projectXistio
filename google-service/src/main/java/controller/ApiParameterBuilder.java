package controller;

public class ApiParameterBuilder {
	private StringBuilder urlBuilder;

	public ApiParameterBuilder() {
		this.urlBuilder = new StringBuilder();
	}
	
	private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=";
	
	String[] symList = {"MSFT","GOOG","TM","BAC","VOD","CSCO","KO","WFC","UBS","MTU"};
	

}
