package pojo;

import java.sql.Date;
import java.time.LocalDateTime;

public class TimeSeriesData {
	private final LocalDateTime dateTime;
	private final Double open,high,low,close,adjustedClose,dividedAmount,splitcoeff;
	private final long volume;
	
	
	public TimeSeriesData(LocalDateTime dateTime, Double open, Double high, Double low, Double close, Double adjustedClose,
			long volume, Double dividedAmount, Double splitcoeff) {
		super();
		this.dateTime = dateTime;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.adjustedClose = adjustedClose;
		this.volume = volume;
		this.dividedAmount = dividedAmount;
		this.splitcoeff = splitcoeff;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public Double getOpen() {
		return open;
	}
	
	public Double getHigh() {
		return high;
	}
	
	public Double getLow() {
		return low;
	}
	
	public Double getClose() {
		return close;
	}
	
	public Double getAdjustedClose() {
		return adjustedClose;
	}
	
	public long getVolume() {
		return volume;
	}
	
	public Double getDividedAmount() {
		return dividedAmount;
	}
	
	public Double getSplitcoeff() {
		return splitcoeff;
	}
	
	

}
