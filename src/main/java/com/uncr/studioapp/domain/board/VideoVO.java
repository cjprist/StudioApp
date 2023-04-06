package com.uncr.studioapp.domain.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoVO {
    private String videoID;
    private String videoThumbnail;
    private String videoCategory;

    public VideoVO(String videoID) {
        this.videoID=videoID;
    }
}
