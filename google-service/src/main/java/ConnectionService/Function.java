package ConnectionService;

public enum Function implements ApiParameter {
	TIME_SERIES_DAILY("TIME_SERIES_DAILY"),
	SMA("SMA"),
	  EMA("EMA"),
	  WMA("WMA"),
	  DEMA("DEMA"),
	  TEMA("TEMA"),
	  TRIMA("TRIMA"),
	  KAMA("KAMA"),
	  MAMA("MAMA"),
	  T3("T3"),
	  MACD("MACD"),
	  MACDEXT("MACDEXT"),
	  STOCH("STOCH"),
	  STOCHF("STOCHF"),
	  RSI("RSI"),
	  STOCHRSI("STOCHRSI"),
	  WILLR("WILLR"),
	  ADX("ADX"),
	  ADXR("ADXR"),
	  APO("APO"),
	  PPO("PPO"),
	  MOM("MOM"),
	  BOP("BOP"),
	  CCI("CCI"),
	  CMO("CMO"),
	  ROC("ROC"),
	  ROCR("ROCR"),
	  AROON("AROON"),
	  AROONOSC("AROONOSC"),
	  MFI("MFI"),
	  TRIX("TRIX"),
	  ULTOSC("ULTOSC"),
	  DX("DX"),
	  MINUS_DI("MINUS_DI"),
	  PLUS_DI("PLUS_DI"),
	  MINUS_DM("MINUS_DM"),
	  PLUS_DM("PLUS_DM"),
	  BBANDS("BBANDS"),
	  MIDPOINT("MIDPOINT"),
	  MIDPRICE("MIDPRICE"),
	  SAR("SAR"),
	  TRANGE("TRANGE"),
	  ATR("ATR"),
	  NATR("NATR"),
	  AD("AD"),
	  ADOSC("ADOSC"),
	  OBV("OBV"),
	  HT_TRENDLINE("HT_TRENDLINE"),
	  HT_SINE("HT_SINE"),
	  HT_TRENDMODE("HT_TRENDMODE"),
	  HT_DCPERIOD("HT_DCPERIOD"),
	  HT_DCPHASE("HT_DCPHASE"),
	  HT_PHASOR("HT_PHASOR");
	
	private final String urlParameter;

	  Function(String urlParameter) {
	    this.urlParameter = urlParameter;
	  }

	@Override
	public String getKey() {
		return "function";
	}

	@Override
	public String getValue() {
		return urlParameter;
	}

}
