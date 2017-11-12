package com.teodorstoev.camunda.web;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {
    @Autowired
    private RuntimeService runtimeService;

    @RequestMapping(method = RequestMethod.GET)
    public String sum(@RequestParam Integer first, @RequestParam Integer second) {
        ProcessInstanceWithVariables sum = runtimeService.createProcessInstanceByKey("sum")
                .setVariable("first", first)
                .setVariable("second", second)
                .executeWithVariablesInReturn();

        VariableMap variables = sum.getVariables();

        return String.format("%d + %d = %d",
                variables.getValue("first", Integer.class),
                variables.getValue("second", Integer.class),
                variables.getValue("sum", Integer.class));
    }
}
