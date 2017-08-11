package de.holisticon.holunda.functionalfallbackfortechnicalretry.process.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FallbackActionDelegate implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("Doing some fallback action.............................................");
    }
}
