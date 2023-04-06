package com.uncr.studioapp.service.board;

import com.uncr.studioapp.domain.board.BoardAddVO;
import com.uncr.studioapp.domain.board.BoardLikeVO;
import com.uncr.studioapp.domain.board.VideoVO;
import com.uncr.studioapp.domain.channel.ChannelVO;
import com.uncr.studioapp.mapper.board.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import util.YoutubeDataAPI;

@Log4j2
@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }



    public void addBoard(BoardAddVO boardAddVO) throws ParseException, NullPointerException {
        YoutubeDataAPI youtubeDataAPI = new YoutubeDataAPI();
        ChannelVO channelVO=new ChannelVO(boardAddVO.getChannelID());
        VideoVO videoVO = new VideoVO(boardAddVO.getVideoID());
        videoVO.setVideoCategory(boardAddVO.getVideoCategory());
        videoVO.setVideoThumbnail(boardAddVO.getVideoThumbnail());
        youtubeDataAPI.setChannelInfo(channelVO);
        boardMapper.addChannel(channelVO);
        boardMapper.addBoard(boardAddVO);
        boardMapper.addVideo(videoVO);
    }

    public void likeBoard(BoardLikeVO boardLikeVO) {
        boardMapper.likeBoard(boardLikeVO);
    }

    public void unlikeBoard(BoardLikeVO boardLikeVO) {
        boardMapper.unlikeBoard(boardLikeVO);
    }
}
