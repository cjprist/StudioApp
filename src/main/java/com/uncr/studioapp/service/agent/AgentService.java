package com.uncr.studioapp.service.agent;

import com.uncr.studioapp.domain.agent.AgentVO;
import com.uncr.studioapp.mapper.agent.AgentMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AgentService {
    final
    AgentMapper agentMapper;

    public AgentService(AgentMapper agentMapper) {
        this.agentMapper = agentMapper;
    }

    public void addAgent(AgentVO agentVO){
        agentMapper.addAgent(agentVO);
    }
}
