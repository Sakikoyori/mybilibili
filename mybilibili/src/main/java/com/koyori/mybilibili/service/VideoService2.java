package com.koyori.mybilibili.service;

import com.koyori.mybilibili.dto.Play;
import com.koyori.mybilibili.dto.Video;
import com.koyori.mybilibili.mapper.PlayMapper;
import com.koyori.mybilibili.mapper.VideoMapper;
import com.koyori.mybilibili.util.Bv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoService2
{
  @Autowired
  private VideoMapper videoMapper;

  @Autowired
  private PlayMapper playMapper;

  public Video find(String bv)
  {
    Video video = videoMapper.findByBv(bv);
    if (video == null)
    {
      return null;
    }

    List<Play> playList = playMapper.findByBv(bv);
    video.setPlayList(playList);
    return video;
  }

  public String publish(Video video)
  {
    video.setPublishTime(LocalDateTime.now());
    videoMapper.insert(video);
    int id = videoMapper.lastInsertId();
    String bv = Bv.get(id);
    videoMapper.updateBv(bv, id);
    for (Play play : video.getPlayList())
    {
      playMapper.insert(play, bv);
    }
    return bv;
  }
}
