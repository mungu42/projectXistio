package ConnectionService;

import java.util.List;
import java.util.Map;

import pojo.TimeSeriesData;

public class Daily extends TimeSeriesResponse{
	private Daily(final Map<String, String> metaData,final List<TimeSeriesData> TimeSeriesData) {
		super(metaData, TimeSeriesData);
	}

	public static Daily from(String json)  {
	    Parser parser = new Parser();
	    return parser.parseJson(json);
	  }
	private static class Parser extends TimeSeriesParser<Daily> {

	    @Override
	    String getTimeSeriesDataKey() {
	      return "Time Series (Daily)";
	    }
	    @Override
	    Daily resolve(Map<String, String> metaData,
	                  Map<String, Map<String, String>> TimeSeriesData)  {
	      List<TimeSeriesData> stocks = new ArrayList<>();
	      try {
	        TimeSeriesData.forEach((key, values) -> stocks.add(new TimeSeriesData(
	                LocalDate.parse(key, SIMPLE_DATE_FORMAT).atStartOfDay(),
	                Double.parseDouble(values.get("1. open")),
	                Double.parseDouble(values.get("2. high")),
	                Double.parseDouble(values.get("3. low")),
	                Double.parseDouble(values.get("4. close")),
	                Long.parseLong(values.get("5. volume"))
	        )));
	      } catch (Exception e) {
	        throw new AlphaVantageException("Daily api change", e);
	      }
	      return new Daily(metaData, stocks);
	    }
	  }
}
