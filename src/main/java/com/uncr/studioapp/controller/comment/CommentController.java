package com.uncr.studioapp.controller.comment;

import com.uncr.studioapp.domain.comment.CommentVO;
import com.uncr.studioapp.service.comment.CommentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class CommentController {
    final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/comment/add", produces = "application/json")
    public ResponseEntity<Void> addComment(
            @RequestBody CommentVO commentVO
    ){
      commentService.addComment(commentVO);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/comment/get", produces = "application/json")
    public ResponseEntity<List<CommentVO>> getComment(
            @RequestParam String boardID
    ){
        return new ResponseEntity<>(commentService.getComment(boardID), HttpStatus.OK);
    }
}
