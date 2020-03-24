package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pojo.GoogleDataPoint;


@RestController("/")
public class HttpRestController {

    /*
     * @GetMapping("getStocks") public GoogleDataPoint getStocks(){ return new
     * GoogleDataPoint("Field1",00.00,00.00); }
     */

    private static Logger LOG = LoggerFactory.getLogger(HttpRestController.class);
    private Map<String, Object> cache = new HashMap<String, Object>();

    private final String LINK = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=AZ35ESNS50ESUG75";

    @GetMapping("getStocks/{symbol}")
    public Map getJSON(@PathVariable String symbol) throws IOException {
        ObjectMapper mapperObj = new ObjectMapper();
        String response = null;
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        if (!cache.containsKey(symbol)) {
            LOG.info("link =>" + String.format(LINK, symbol));

            URL url = new URL(String.format(LINK, symbol));


            URLConnection connection = url.openConnection();



            InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            response = "";
            String line = bufferedReader.readLine();
            while (line != null) {
                line = bufferedReader.readLine();
                response += line;
            }


            cache.put(symbol,response);
        }



        return cache;
    }


}
