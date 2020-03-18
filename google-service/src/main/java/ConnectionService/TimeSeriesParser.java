package ConnectionService;

import java.util.Map;

public abstract class TimeSeriesParser<Data> extends JsonParser<Data> {
	abstract Data resolve(Map<String, String> metaData,
            Map<String, Map<String, String>> TimeSeriesData) ;
	abstract String getTimeSeriesDataKey();

	  @Override
	  public Data resolve(JsonObject rootObject)  {
	    Type metaDataType = new TypeToken<Map<String, String>>() {
	    }.getType();
	    Type dataType = new TypeToken<Map<String, Map<String, String>>>() {
	    }.getType();
	    try {
	      Map<String, String> metaData = GSON.fromJson(rootObject.get("Meta Data"), metaDataType);
	      Map<String, Map<String, String>> TimeSeriesData = GSON.fromJson(rootObject.get(getTimeSeriesDataKey()), dataType);
	      return resolve(metaData, TimeSeriesData);
	    } catch (JsonSyntaxException e) {
	      throw new AlphaVantageException("time series api change", e);
	    }
	  }
}
