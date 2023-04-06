package com.uncr.studioapp.controller.mypage;

import com.uncr.studioapp.domain.mypage.MyPageVO;
import com.uncr.studioapp.service.mypage.MyPageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class MyPageController {
    final MyPageService myPageService;
    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/mypage/get", produces = "application/json")
    public ResponseEntity<MyPageVO> getMyPage(
            @RequestParam String agentID
    ){
        return new ResponseEntity<>(myPageService.getMyPage(agentID), HttpStatus.OK);
    }
}
