package com.uncr.studioapp.mapper.board;

import com.uncr.studioapp.domain.board.BoardAddVO;
import com.uncr.studioapp.domain.board.BoardLikeVO;
import com.uncr.studioapp.domain.board.VideoVO;
import com.uncr.studioapp.domain.channel.ChannelVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    void addBoard(BoardAddVO boardAddVO);
    void addChannel(ChannelVO channelVO);

    void likeBoard(BoardLikeVO boardLikeVO);

    void unlikeBoard(BoardLikeVO boardLikeVO);

    void addVideo(VideoVO videoVO);
}
