package ConnectionService;

@FunctionalInterface
public interface ApiConnector {
	
	String getRequest(ApiParameter...apiParameters);

}
