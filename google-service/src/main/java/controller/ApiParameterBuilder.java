package controller;

public class ApiParameterBuilder {
	private StringBuilder urlBuilder;

	public ApiParameterBuilder() {
		this.urlBuilder = new StringBuilder();
	}
	
	private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=";
	
	public String getURL(String symbol) {
		urlBuilder.delete(0, urlBuilder.length());
		urlBuilder.append(BASE_URL);
		urlBuilder.append(symbol);
		urlBuilder.append("&apikey=IIZ9PO7RRW6IXUAQ");
		
		return urlBuilder.toString();
	}
}
