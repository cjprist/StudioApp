package com.uncr.studioapp.domain.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
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
    private String videoID;
    private int totalDuration;
    private int totalWatchers;
    private int totalLikes;
    private int totalComments;
}
