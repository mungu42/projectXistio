package controller;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@RestController("/")
public class HttpRestController {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final static Logger LOG = Logger.getLogger(HttpRestController.class.getName());
    @GetMapping("getStocks")
    public String getStocks() throws Exception {
        return sendGet().orElseGet(() -> "");
    }
    private Optional<String> sendGet() throws Exception {
        LOG.info("Made Request to "+"8081");

        HttpGet request = new HttpGet("http://localhost:8081/getStocks");

        // add request headers
            CloseableHttpResponse response = httpClient.execute(request);
            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                LOG.info(result);
                return Optional.of(result);
            }


        return Optional.of(null);

    }

}
