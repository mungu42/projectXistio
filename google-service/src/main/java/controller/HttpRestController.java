package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class HttpRestController {

	/*
	 * @GetMapping("getStocks") public GoogleDataPoint getStocks(){ return new
	 * GoogleDataPoint("Field1",00.00,00.00); }
	 */
    
    @GetMapping("getStocks")
    public void getJSON() throws IOException {
//		final String SYM ="MSFT";
//		URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=011MUAEI4T1XCEGL");
//		URLConnection connection = url.openConnection();
//
//		InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
//		BufferedReader bufferedReader = new BufferedReader(inputStream);
//		String response = "";
//		String line = bufferedReader.readLine();
//		while(line!=null) {
//			System.out.println(line);
//			line = bufferedReader.readLine();
//			response += line;
//		}
//		return response;
		String apiKey = "50M3AP1K3Y";
		int timeout = 3000;
		AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		TimeSeries stockTimeSeries = new TimeSeries(apiConnector);

		try {
			IntraDay response = stockTimeSeries.intraDay("MSFT", Interval.ONE_MIN, OutputSize.COMPACT);
			Map<String, String> metaData = response.getMetaData();
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			List<StockData> stockData = response.getStockData();
			stockData.forEach(stock -> {
				System.out.println("date:   " + stock.getDateTime());
				System.out.println("open:   " + stock.getOpen());
				System.out.println("high:   " + stock.getHigh());
				System.out.println("low:    " + stock.getLow());
				System.out.println("close:  " + stock.getClose());
				System.out.println("volume: " + stock.getVolume());
			});
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
	}

}
