package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.YahooDataPoint;

@RestController("/")
public class HttpRestController {

    @GetMapping("getStocks")
    public YahooDataPoint getStocks(){
        return new YahooDataPoint("Field1","Field2","Field3");
    }

}
