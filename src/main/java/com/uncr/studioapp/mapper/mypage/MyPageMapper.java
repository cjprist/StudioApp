package com.uncr.studioapp.mapper.mypage;

import com.uncr.studioapp.domain.agent.AgentVO;
import com.uncr.studioapp.domain.board.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPageMapper {
    List<BoardVO> getMyBoard(String agentID);
    AgentVO getAgentInfo(String agentID);
}
