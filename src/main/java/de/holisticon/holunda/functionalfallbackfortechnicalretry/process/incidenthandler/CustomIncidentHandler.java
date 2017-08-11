package de.holisticon.holunda.functionalfallbackfortechnicalretry.process.incidenthandler;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.impl.incident.DefaultIncidentHandler;
import org.camunda.bpm.engine.impl.incident.IncidentContext;
import org.camunda.bpm.engine.impl.incident.IncidentHandler;

@Slf4j
public class CustomIncidentHandler extends DefaultIncidentHandler {

    CustomIncidentHandler() {
        super("failedJob");
    }

    @Override
    public void handleIncident(IncidentContext context, String message) {
        log.info("-------------------------------------> handling Incident................................");
        createIncident(context, message);

        String executionId = context.getExecutionId();

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        Boolean triggerFallback = (Boolean) runtimeService.getVariable(executionId, "triggerFallback");
        if (triggerFallback == null) {
            log.info("variable triggerFallback does not yet exist!");
            runtimeService.setVariable(executionId, "triggerFallback", true);
        } else {
            log.info("nothing to do, fallback has been triggered before!");
        }
    }

    @Override
    public void resolveIncident(IncidentContext context) {
        log.info("-------------------------------------> resolve Incident................................");
        removeIncident(context, true);
    }

    @Override
    public void deleteIncident(IncidentContext context) {
        log.info("-------------------------------------> delete Incident................................");
        removeIncident(context, false);
    }
}
