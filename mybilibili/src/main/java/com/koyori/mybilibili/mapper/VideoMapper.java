package com.koyori.mybilibili.mapper;

import com.koyori.mybilibili.dto.Video;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VideoMapper
{
  @Select("""
      select bv,
             title,
             publish_time,
             cover,
             introduction,
             type,
             category,
             tags
      from video
      where bv=#{bv}
      """)
  Video findByBv(String bv);

  @Insert("""
      insert into video(type, category, title,
        cover, introduction, publish_time, tags)
      VALUES (#{type}, #{category}, #{title},
        #{cover}, #{introduction}, #{publishTime}, #{tags})
      """)
  void insert(Video video);

  @Select("select last_insert_id()")
  int lastInsertId();

  @Update("update video set bv=#{bv} where id=#{id}")
  void updateBv(@Param("bv") String bv, @Param("id") int id);
}
