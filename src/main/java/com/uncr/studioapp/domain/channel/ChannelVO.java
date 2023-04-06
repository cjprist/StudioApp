package com.uncr.studioapp.domain.channel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelVO {
    private String channelID;
    private String channelTitle;
    private String channelThumbnail;
    private String channelRegion;

    public ChannelVO(){}

    public ChannelVO(String channelID){
        this.channelID=channelID;
    }
}
