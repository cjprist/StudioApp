package com.uncr.studioapp.service.comment;

import com.uncr.studioapp.domain.comment.CommentVO;
import com.uncr.studioapp.mapper.comment.CommentMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CommentService {
    final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public void addComment(CommentVO commentVO){
        commentMapper.addComment(commentVO);
    }
    public List<CommentVO> getComment(String boardID){
        return commentMapper.getComment(boardID);
    }
}
