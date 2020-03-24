package controller;

import org.apache.http.HttpEntity;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;


@RestController("/")
public class HttpRestController {

    /*
     * @GetMapping("getStocks") public GoogleDataPoint getStocks(){ return new
     * GoogleDataPoint("Field1",00.00,00.00); }
     */

    private AlphaVantageApi alphaVantageApi =  new AlphaVantageApi();
    @GetMapping("getStocks")
    public JSONObject getJSON() throws IOException, ParseException {

        HttpEntity entity =  alphaVantageApi.getSymListData("MSFT");

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(
                new InputStreamReader(entity.getContent(), "UTF-8"));

        return jsonObject;
    }


}
