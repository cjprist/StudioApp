package com.uncr.studioapp.domain.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardAddVO {
    private String agentID;
    private String channelID;
    private String boardTitle;
    private String boardContent;
    private String videoID;
    private String videoThumbnail;
    private String videoCategory;
}
