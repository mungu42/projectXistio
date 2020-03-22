package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.YahooDataPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController("/")
public class HttpRestController {

    @GetMapping("getStocks")
    public String getJSON() throws IOException {
        final String SYM ="MSFT";
        URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=011MUAEI4T1XCEGL");
        URLConnection connection = url.openConnection();

        InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStream);
        String response = "";
        String line = bufferedReader.readLine();
        while(line!=null) {
            System.out.println(line);
            line = bufferedReader.readLine();
            response += line;
        }
        return response;
    }
}
