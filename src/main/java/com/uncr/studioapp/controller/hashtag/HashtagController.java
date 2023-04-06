package com.uncr.studioapp.controller.hashtag;

import com.uncr.studioapp.service.hashtag.HashtagService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class HashtagController {
    final
    HashtagService hashtagService;

    public HashtagController(HashtagService hashtagService) {
        this.hashtagService = hashtagService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hashtag/get")
    public ResponseEntity<List<String>> getHashtags(){
        return new ResponseEntity<>(hashtagService.getHashtags(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/hashtag/add")
    public ResponseEntity<Void> addHashtags(
            @RequestBody List<String> hashtags
    ){
        hashtagService.addHashtags(hashtags);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
