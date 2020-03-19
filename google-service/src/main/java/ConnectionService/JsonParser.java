package ConnectionService;

public class JsonParser<Data> {
	private static com.google.gson.JsonParser PARSER = new com.google.gson.JsonParser();
	protected static Gson GSON = new Gson();
	protected abstract Data resolve(JsonObject rootObject);
	public Data parseJson(String json) {
		
	    try {
	      JsonElement jsonElement = PARSER.parse(json);
	      JsonObject rootObject = jsonElement.getAsJsonObject();

	      JsonElement errorMessage = rootObject.get("Error Message");
	      if (errorMessage != null) {
	        throw new AlphaVantageException(errorMessage.getAsString());
	      }

	      return resolve(rootObject);

	    } catch (JsonSyntaxException e) {
	      throw new AlphaVantageException("error parsing json", e);
	    }
	  }


}
