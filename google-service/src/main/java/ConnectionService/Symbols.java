package ConnectionService;

public class Symbols implements ApiParameter {
	private String[] symbols;
	
	public Symbols(String...symbols) {
		this.symbols= symbols;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "symbols";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return String.join(",",symbols);
	}
	

}
