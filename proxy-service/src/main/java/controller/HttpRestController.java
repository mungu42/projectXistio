package controller;

import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController("/")
public class HttpRestController {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final static Logger LOG = Logger.getLogger(HttpRestController.class.getName());
    @GetMapping("getStocks")
    public JSONArray getStocks() throws Exception {
    	return sendGet();
    }
    private JSONArray sendGet() throws Exception {
        LOG.info("Made Request to "+"8081");

        HttpGet request = new HttpGet("http://localhost:8081/getAllStocks");

        // add request headers
            CloseableHttpResponse response = httpClient.execute(request);
            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);
            if(entity!=null) {
            	JSONParser jsonParser = new JSONParser();
            	JSONArray jsonArray = (JSONArray) jsonParser.parse(new InputStreamReader(entity.getContent(), "UTF-8"));

            	return jsonArray;
            }

        return new JSONArray();

    }

}
