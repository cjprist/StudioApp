package com.uncr.studioapp.service.hashtag;

import com.uncr.studioapp.mapper.hashtag.HashtagMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashtagService {
    final
    HashtagMapper hashtagMapper;

    public HashtagService(HashtagMapper hashtagMapper) {
        this.hashtagMapper = hashtagMapper;
    }

    public List<String> getHashtags(){
        return hashtagMapper.getHashtag();
    }

    public void addHashtags(List<String> hashtags){
        hashtagMapper.addHashtag(hashtags);
    }
}
