package com.ur.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 描述:
 * 静态文件配置
 * @author huifer
 * @date 2019-01-01
 */
//@Configuration
public class StaticConfig extends WebMvcConfigurerAdapter {
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
    registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
    registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
    registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
    super.addResourceHandlers(registry);
  }
}