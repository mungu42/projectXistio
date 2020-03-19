package ConnectionService;

public class FromSymbol implements ApiParameter {
	String fromSymbol;

	public FromSymbol(String fromSymbol) {
		super();
		this.fromSymbol = fromSymbol;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "from_symbol";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return fromSymbol;
	}
	

}
