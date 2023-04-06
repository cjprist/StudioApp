package com.uncr.studioapp.controller.agent;

import com.uncr.studioapp.domain.agent.AgentVO;
import com.uncr.studioapp.service.agent.AgentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class AgentController {
    final
    AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }
    @RequestMapping(method = RequestMethod.POST, path = "/agent/add", produces = "application/json")
    public ResponseEntity<Void> addAgent(
            @RequestBody AgentVO agentVO
            ){
        agentService.addAgent(agentVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
