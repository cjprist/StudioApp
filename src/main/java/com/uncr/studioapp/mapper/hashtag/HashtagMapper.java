package com.uncr.studioapp.mapper.hashtag;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HashtagMapper {
    List<String> getHashtag();
    void addHashtag(List<String> hashtags);
}
