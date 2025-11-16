package com.koyori.mybilibili;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MybilibiliApplication implements WebMvcConfigurer
{
  @Value("${video-path}")
  private String videoPath;

  @Value("${image-path}")
  private String imgPath;

  public static void main(String[] args)
  {
    SpringApplication.run(MybilibiliApplication.class, args);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler("/play/**").addResourceLocations("file:d:\\BilibiliVideo");
    registry.addResourceHandler("/img/**").addResourceLocations("file:d:\\BilibiliImage");
  }
}