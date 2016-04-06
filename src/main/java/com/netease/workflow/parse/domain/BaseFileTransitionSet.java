package com.netease.workflow.parse.domain;

/**
 * @author wuhao
 */
public class BaseFileTransitionSet {

    private String toStateCode;

    private String triggerEvent;

    public String getToStateCode() {
        return toStateCode;
    }

    public void setToStateCode(String toStateCode) {
        this.toStateCode = toStateCode;
    }

    public String getTriggerEvent() {
        return triggerEvent;
    }

    public void setTriggerEvent(String triggerEvent) {
        this.triggerEvent = triggerEvent;
    }
}
