package ConnectionService;

import java.util.List;
import java.util.Map;

import pojo.TimeSeriesData;

public class TimeSeriesResponse {
	private final Map<String, String> metaData;
	private final List<TimeSeriesData> timeSeriesData;
	
	TimeSeriesResponse(final Map<String, String> metaData, final List<TimeSeriesData> timeSeriesData) {
	    this.timeSeriesData = timeSeriesData;
	    this.metaData = metaData;
	  }
	
	public Map<String, String> getMetaData() {
	    return metaData;
	  }
	
	public List<TimeSeriesData> getStockData() {
	    return timeSeriesData;
	  }


}
