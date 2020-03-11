package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.GoogleDataPoint;


@RestController("/")
public class HttpRestController {

    @GetMapping("getStocks")
    public GoogleDataPoint getStocks(){
        return new GoogleDataPoint("Field1","Field2","Field3");
    }

}
