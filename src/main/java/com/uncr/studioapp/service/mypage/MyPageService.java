package com.uncr.studioapp.service.mypage;

import com.uncr.studioapp.domain.board.BoardVO;
import com.uncr.studioapp.domain.mypage.MyPageVO;
import com.uncr.studioapp.mapper.mypage.MyPageMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MyPageService {
    final MyPageMapper myPageMapper;

    public MyPageService(MyPageMapper myPageMapper) {
        this.myPageMapper = myPageMapper;
    }

    public MyPageVO getMyPage(String agentID){
        MyPageVO returnVO= new MyPageVO();
        returnVO.setBoardVOS(myPageMapper.getMyBoard(agentID));
        returnVO.setAgentVO(myPageMapper.getAgentInfo(agentID));
        for (BoardVO boardVO: returnVO.getBoardVOS()){
            returnVO.setAgentTotalDuration(boardVO.getTotalDuration()+ returnVO.getAgentTotalDuration());
        }
        return returnVO;
    }
}
