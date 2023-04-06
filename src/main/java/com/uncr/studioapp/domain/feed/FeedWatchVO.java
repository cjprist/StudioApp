package com.uncr.studioapp.domain.feed;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedWatchVO {
    private String agentID;
    private Long boardID;
    private int duration;
}
