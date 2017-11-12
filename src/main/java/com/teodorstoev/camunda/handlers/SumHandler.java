package com.teodorstoev.camunda.handlers;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class SumHandler implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {
        Integer first = (Integer) execution.getVariable("first");
        Integer second = (Integer) execution.getVariable("second");

        execution.setVariable("sum", first + second);
    }
}
