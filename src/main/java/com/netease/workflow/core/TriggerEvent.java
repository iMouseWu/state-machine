package com.netease.workflow.core;

/**
 * @author wuhao
 */
public class TriggerEvent implements Event {

    private String code;

    private String name;

    public TriggerEvent() {

    }

    public TriggerEvent(String code, String name) {
        this.code = code;
        this.name = name;

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
