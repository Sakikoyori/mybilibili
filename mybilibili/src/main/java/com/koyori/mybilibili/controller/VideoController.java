package com.koyori.mybilibili.controller;

import com.koyori.mybilibili.dto.Video;
import com.koyori.mybilibili.service.VideoService1;
import com.koyori.mybilibili.service.VideoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
public class VideoController
{
/*   @Autowired
  VideoService1 videoService1;

  @RequestMapping("/video/{bv}")
  @ResponseBody
  public Video t(@PathVariable String bv)
  {
    return videoService1.find(bv);
  } */

  @Autowired
  VideoService2 videoService2;

  @RequestMapping("/video/{bv}")
  @ResponseBody
  public Video t(@PathVariable String bv)
  {
    return videoService2.find(bv);
  }

  @RequestMapping("/publish")
  @ResponseBody
  public Map<String, String> publish(@RequestBody Video video)
  {
    String bv = videoService2.publish(video);
    return Map.of("bv",bv);
  }
}