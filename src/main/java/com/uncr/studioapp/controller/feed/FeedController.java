package com.uncr.studioapp.controller.feed;

import com.uncr.studioapp.domain.feed.FeedVO;
import com.uncr.studioapp.domain.feed.FeedWatchVO;
import com.uncr.studioapp.service.feed.FeedService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class FeedController {

    final
    FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/feed/get", produces = "application/json")
    public ResponseEntity<List<FeedVO>> getFeed(
            @RequestParam String agentID){
        return new ResponseEntity<>(feedService.getFeed(agentID), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/feed/watch", produces = "application/json")
    public ResponseEntity<Void> watchFeed(
            @RequestBody FeedWatchVO feedWatchVO){
        feedService.watchFeed(feedWatchVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
