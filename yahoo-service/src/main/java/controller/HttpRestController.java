package controller;

import alphavantage.AlphaVantageApi;
import org.apache.http.HttpEntity;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


@RestController("/")
public class HttpRestController {

    /*
     * @GetMapping("getStocks") public GoogleDataPoint getStocks(){ return new
     * GoogleDataPoint("Field1",00.00,00.00); }
     */

    @Autowired
    private AlphaVantageApi alphaVantageApi;

    @GetMapping("getStocks/{symbol}/{apiKey}")
    public JSONObject getDataforSymbol(@PathVariable String symbol,@PathVariable String apiKey) throws IOException, ParseException {

        HttpEntity entity =  alphaVantageApi.getSymListData(symbol,apiKey);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(
                new InputStreamReader(entity.getContent(), "UTF-8"));

        return jsonObject;
    }
    @GetMapping("getAllStocks/{apiKey}")
    public List<Map<String, String>> getAllData(@PathVariable String apiKey) throws IOException, ParseException {
        return alphaVantageApi.getStoredSymbolResults(apiKey);
    }

}
