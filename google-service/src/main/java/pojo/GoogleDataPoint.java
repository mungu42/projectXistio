package pojo;

import java.sql.Date;
import java.util.List;

public class GoogleDataPoint {
	private String information;
    private String symbol;
    private Date lastRefreshed;
    private String outputSize;
    private String timezone;
    
    private List<TimeSeriesData> timeSeriesData;
    
    public GoogleDataPoint(String information, String symbol, Date lastRefreshed, String outputSize,
			String timezone, List<TimeSeriesData> timeSeriesData) {
		super();
		this.information = information;
		this.symbol = symbol;
		this.lastRefreshed = lastRefreshed;
		//this.interval = interval;
		this.outputSize = outputSize;
		this.timezone = timezone;
		this.timeSeriesData = timeSeriesData;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Date getLastRefreshed() {
		return lastRefreshed;
	}

	public void setLastRefreshed(Date lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}

	public String getOutputSize() {
		return outputSize;
	}

	public void setOutputSize(String outputSize) {
		this.outputSize = outputSize;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public List<TimeSeriesData> getTimeSeriesData() {
		return timeSeriesData;
	}

	public void setTimeSeriesData(List<TimeSeriesData> timeSeriesData) {
		this.timeSeriesData = timeSeriesData;
	}

	

	/*
	 * public GoogleDataPoint(String symbol, Double open, Double close) {
	 * this.symbol = symbol; this.open = open; this.close = close; }
	 * 
	 * public String getSymbol() { return symbol; }
	 * 
	 * public void setSymbol(String symbol) { this.symbol = symbol; }
	 * 
	 * public Double getOpen() { return open; }
	 * 
	 * public void setOpen(Double open) { this.open = open; }
	 * 
	 * public Double getClose() { return close; }
	 * 
	 * public void setClose(Double close) { this.close = close; }
	 */
}
