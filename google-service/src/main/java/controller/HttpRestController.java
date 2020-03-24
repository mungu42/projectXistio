package controller;

import alphavantage.AlphaVantageApi;
import org.apache.http.HttpEntity;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


@RestController("/")
public class HttpRestController {

    @Autowired
    private AlphaVantageApi alphaVantageApi;

    @GetMapping("getStocks")
    public JSONObject getJSON() throws IOException, ParseException {

        HttpEntity entity = alphaVantageApi.getSymListData("MSFT");

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(
                new InputStreamReader(entity.getContent(), "UTF-8"));

        return jsonObject;
    }

    @GetMapping("getAllStocks")
    public Map<String, JSONObject> getAllData() throws IOException, ParseException {
        return alphaVantageApi.getStoredSymbolResults();
    }

}
