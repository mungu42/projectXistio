package pojo;

public class GoogleDataPoint {
	private String lastRefreshed;
	private String closePrice; 
	private String symbol;
	
	public GoogleDataPoint(String lastRefreshed, String price, String symbol) {
		super();
		this.lastRefreshed = lastRefreshed;
		this.closePrice = price;
		this.symbol = symbol;
	}
	public String getLastRefreshed() {
		return lastRefreshed;
	}
	public void setLastRefreshed(String lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}
	public String getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(String closePrice) {
		this.closePrice = closePrice;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
