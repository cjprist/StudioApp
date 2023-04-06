package com.uncr.studioapp.mapper.comment;

import com.uncr.studioapp.domain.comment.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void addComment(CommentVO commentVO);
    List<CommentVO> getComment(String boardID);
}
