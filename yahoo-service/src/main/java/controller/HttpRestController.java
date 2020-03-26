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
import java.util.Map;


@RestController("/")
public class HttpRestController {

    /*
     * @GetMapping("getStocks") public GoogleDataPoint getStocks(){ return new
     * GoogleDataPoint("Field1",00.00,00.00); }
     */

    @Autowired
    private AlphaVantageApi alphaVantageApi;

    @GetMapping("getStocks/{symbol}")
    public JSONObject getDataforSymbol(@PathVariable String sym) throws IOException, ParseException {

        HttpEntity entity =  alphaVantageApi.getSymListData(sym);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(
                new InputStreamReader(entity.getContent(), "UTF-8"));

        return jsonObject;
    }
    @GetMapping("getAllStocks")
    public Map getAllData() throws IOException, ParseException {
        return (Map) alphaVantageApi.getStoredSymbolResults();
    }

}
