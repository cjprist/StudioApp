package com.uncr.studioapp.domain.mypage;

import com.uncr.studioapp.domain.agent.AgentVO;
import com.uncr.studioapp.domain.board.BoardVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyPageVO {
    private AgentVO agentVO;
    private List<BoardVO> boardVOS;
    private int agentTotalDuration=0;
}
