package com.uncr.studioapp.service.feed;

import com.uncr.studioapp.domain.feed.FeedVO;
import com.uncr.studioapp.domain.feed.FeedWatchVO;
import com.uncr.studioapp.domain.feed.MyDurationDB;
import com.uncr.studioapp.domain.feed.MyLikeDB;
import com.uncr.studioapp.mapper.feed.FeedMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {
    final
    FeedMapper feedMapper;

    public FeedService(FeedMapper feedMapper) {
        this.feedMapper = feedMapper;
    }

    public List<FeedVO> getFeed(String agentID) {
        List<FeedVO> feedBoard= feedMapper.getFeed();
        if (agentID!=null){
            List<MyDurationDB> myDurationDBS= feedMapper.getMyDuration(agentID);
            List<MyLikeDB> myLikeDBS = feedMapper.getMyLike(agentID);
            for (MyDurationDB myDurationDB: myDurationDBS){
                for (FeedVO feedVO: feedBoard){
                    if (feedVO.getBoardID().equals(myDurationDB.getBoardID())){
                        feedVO.setMyDuration(myDurationDB.getMyDuration());
                    }
                }
            }
            for (MyLikeDB myLikeDB: myLikeDBS){
                for (FeedVO feedVO: feedBoard){
                    if (feedVO.getBoardID().equals(myLikeDB.getBoardID())){
                        feedVO.setMyLike(myLikeDB.isMyLike());
                    }
                }
            }
        }
       return feedBoard;
    }

    public void watchFeed(FeedWatchVO feedWatchVO) {
        feedMapper.watchFeed(feedWatchVO);
    }
}
