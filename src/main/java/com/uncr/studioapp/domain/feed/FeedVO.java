package com.uncr.studioapp.domain.feed;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedVO {
    private Long boardID;
    private String agentID;
    private String agentNickname;
    private String agentURI;
    private String channelID;
    private String channelThumbnail;
    private String channelTitle;
    private String boardTitle;
    private String boardTime;
    private String boardContent;
    private String youtubeComment;
    private String videoID;
    private String videoThumbnail;
    private String videoCategory;
    private int totalDuration;
    private int totalWatchers;
    private int totalLikes;
    private int totalComments;
    private Integer myDuration=null;
    private boolean myLike=false;
}
