package com.netease.workflow.core;

/**
 * @author wuhao
 */
public class BaseTransition {

    private State toState;

    private TriggerEvent triggerEvent;

    public State getToState() {
        return toState;
    }

    public void setToState(State toState) {
        this.toState = toState;
    }

    public TriggerEvent getTriggerEvent() {
        return triggerEvent;
    }

    public void setTriggerEvent(TriggerEvent triggerEvent) {
        this.triggerEvent = triggerEvent;
    }
}
