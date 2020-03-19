package ConnectionService;

public class ToSymbol implements ApiParameter{
	String toSymbol;

	public ToSymbol(String toSymbol) {
		super();
		this.toSymbol = toSymbol;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "to_symbol";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return toSymbol;
	}

}
