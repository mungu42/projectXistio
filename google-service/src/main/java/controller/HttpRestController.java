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

    @Autowired
    private AlphaVantageApi alphaVantageApi;

    @GetMapping("getStocks/{symbol}/")
    public JSONObject getDataforSymbol(@PathVariable String sym,@PathVariable("apiKey") String apiKey) throws IOException, ParseException {

        HttpEntity entity =  alphaVantageApi.getSymListData(sym,apiKey);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(
                new InputStreamReader(entity.getContent(), "UTF-8"));

        return jsonObject;
    }

    @GetMapping("getAllStocks/{api_key}")
    public List getAllData(@PathVariable("apiKey") String apiKey) throws IOException, ParseException {
        return alphaVantageApi.getStoredSymbolResults(apiKey);
    }

}
