package de.holisticon.holunda.functionalfallbackfortechnicalretry.process.incidenthandler;

import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.incident.IncidentHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IncidentHandlerProcessEnginePlugin extends AbstractProcessEnginePlugin {

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        List<IncidentHandler> customIncidentHandlers = new ArrayList<IncidentHandler>();
        customIncidentHandlers.add(new CustomIncidentHandler());
        processEngineConfiguration.setCustomIncidentHandlers(customIncidentHandlers );

    }

}
