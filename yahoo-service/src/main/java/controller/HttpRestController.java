package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pojo.YahooDataPoint;

@RestController("/")
public class HttpRestController {

    /*
     * @GetMapping("getStocks") public GoogleDataPoint getStocks(){ return new
     * GoogleDataPoint("Field1",00.00,00.00); }
     */

    @GetMapping("getStocks")
    public Map<String, YahooDataPoint> getJSON() throws IOException {
        Map<String, YahooDataPoint> symbolData = new HashMap<String, YahooDataPoint>();
        ApiParameterBuilder apiUrlBuilder = new ApiParameterBuilder();
        String[] symList = { "MSFT", "GOOG", "TM", "BAC", "VOD", "CSCO", "KO", "WFC", "UBS", "PEP" };
        YahooDataPoint stock;

        Date lastRefDate;
        for (String sym : symList) {
            URL url = new URL(apiUrlBuilder.getURL(sym));
            URLConnection connection = url.openConnection();
            InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String date = "";
            String line = bufferedReader.readLine();
            int i = 0;

            while (line != null) {
                if (line.contains("Last Refreshed")) {

                    // System.out.println(line);
                    int semiIndex = line.indexOf(":");
                    int index1 = line.indexOf("\"", semiIndex);
                    int index2 = line.lastIndexOf(" ");
                    date = line.substring(index1 + 1, index2);
                    // stock.setLastRefreshed(date);
                    // System.out.println(date);
                }
                if (line.contains("close\":")) {
                    // System.out.println(line);
                    i++;
                }

                if (i > 0)
                    break;

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODOAuto-generated catch block
                    e.printStackTrace();
                }

                line = bufferedReader.readLine();

            }
            /*
             * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
             * Auto-generated catch block e.printStackTrace(); }
             */

            // System.out.println(line);

            int semiIndex = line.indexOf(":");
            int index1 = line.indexOf("\"", semiIndex);
            int index2 = line.lastIndexOf("\"");
            String price = line.substring(index1 + 1, index2);
            System.out.println(price);

            stock = new YahooDataPoint(date, price, sym);
            symbolData.put(sym, stock);

        }
        return symbolData;

    }

}
