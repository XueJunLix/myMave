package com.ur;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 * 通过打成war包部署在Tomcat的webapps目录下时，需要实现此类。
 */
public class UrBiServletInitializer extends SpringBootServletInitializer {

 @Override
 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

  // 注意这里要指向原先用main方法执行的Application启动类

  return builder.sources(UrBiPortalApplication.class);
 }
}