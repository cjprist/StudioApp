package com.uncr.studioapp.mapper.feed;

import com.uncr.studioapp.domain.feed.FeedVO;
import com.uncr.studioapp.domain.feed.FeedWatchVO;
import com.uncr.studioapp.domain.feed.MyDurationDB;
import com.uncr.studioapp.domain.feed.MyLikeDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    List<FeedVO> getFeed();
    List<MyDurationDB> getMyDuration(String agentID);
    List<MyLikeDB> getMyLike(String agentID);
    void watchFeed(FeedWatchVO feedWatchVO);
}
