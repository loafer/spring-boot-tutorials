package com.github.loafer.demo.springboot.convert;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;

/**
 * @author zhaojh.
 */
@RestController
@RequestMapping("/convert")
public class ConvertController {

  @RequestMapping("primitive")
  public String primitive(Integer value){
    return "Converted primitive " + value;
  }

  @RequestMapping("date/{value}")
  public String date(@PathVariable @DateTimeFormat Date value){
    return "Converted date " + value;
  }

  @RequestMapping("date")
  public String date2(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date value){
    return "Converted date " + value;
  }

  @RequestMapping("collection")
  public String collection(@RequestParam Collection<Integer> values){
    return "Converted collection " + values;
  }

  @RequestMapping("dateCollection")
  public String dateCollection(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Collection<Date> values){
    return "Converted date collection " + values;
  }
}
