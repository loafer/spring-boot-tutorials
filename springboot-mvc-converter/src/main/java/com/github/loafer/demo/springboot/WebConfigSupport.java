package com.github.loafer.demo.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;


/**
 * @author zhaojh.
 */
@Configuration
public class WebConfigSupport extends WebMvcConfigurationSupport {


  /**
   * 全局日期格式化，设置后@DateFormatter的pattern、iso等属性不在起作用
   * @param registry
   */
  @Override
  protected void addFormatters(FormatterRegistry registry) {
    registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    super.addFormatters(registry);
  }

  @Override
  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    super.configureMessageConverters(converters);
  }
}
