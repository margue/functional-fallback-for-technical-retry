package de.holisticon.holunda.functionalfallbackfortechnicalretry.process;

public class RetryHandlingProcess {

    public static final String KEY = "RetryHandlingProcess";
    public static final String RESOURCE = "bpmn/RetryHandlingProcess.bpmn";

    public static enum ACTIVITIES {
        ;
        public static final String CALL_FAILING_SERVICE = "Task_CallFailingService";
    }

}

