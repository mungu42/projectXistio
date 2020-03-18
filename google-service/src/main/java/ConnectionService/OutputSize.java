package ConnectionService;

public enum OutputSize implements ApiParameter {
	COMPACT("compact"),
	FULL("full");

	private final String outputSize;
	
	

	private OutputSize(String outputSize) {
		this.outputSize = outputSize;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "outputsize";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return outputSize;
	}
	

}
