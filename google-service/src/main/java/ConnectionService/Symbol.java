package ConnectionService;

public class Symbol implements ApiParameter {
	private String symbol;
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "symbol";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return symbol;
	}
	
	

}
