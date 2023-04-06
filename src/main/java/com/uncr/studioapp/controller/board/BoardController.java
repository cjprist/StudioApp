package com.uncr.studioapp.controller.board;

import com.uncr.studioapp.domain.board.BoardAddVO;
import com.uncr.studioapp.domain.board.BoardLikeVO;
import com.uncr.studioapp.service.board.BoardService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.jdbc.Null;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/board/add", produces = "application/json")
    public ResponseEntity<Null> addBoard(
            @RequestBody BoardAddVO boardAddVO
    ){
        try {
            boardService.addBoard(boardAddVO);
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/board/like", produces = "application/json")
    public ResponseEntity<Void> likeBoard(
            @RequestBody BoardLikeVO boardLikeVO
            ){
        boardService.likeBoard(boardLikeVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/board/unlike", produces = "application/json")
    public ResponseEntity<Void> unlikeBoard(
            @RequestBody BoardLikeVO boardLikeVO
    ){
        boardService.unlikeBoard(boardLikeVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
