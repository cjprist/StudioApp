package com.uncr.studioapp.domain.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentVO {
    private String commentID;
    private Long boardID;
    private String commentTime;
    private String commentContent;
    private String agentID;
    private String agentNickname;
    private String agentURI;
}
