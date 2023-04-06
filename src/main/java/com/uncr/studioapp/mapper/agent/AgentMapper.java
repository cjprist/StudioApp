package com.uncr.studioapp.mapper.agent;

import com.uncr.studioapp.domain.agent.AgentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AgentMapper {
    void addAgent(AgentVO agentVO);
}
