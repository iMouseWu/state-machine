package com.netease.workflow.core;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author wuhao
 *         状态机状态
 */
public class State {

    private String code;

    private String name;

    private List<BaseTransition> transitions;

    public State() {

    }

    public BaseTransition transform(String triggerEventCode) {
        for (BaseTransition transition : transitions) {
            if (StringUtils.equals(transition.getTriggerEvent().getCode(), triggerEventCode)) {
                return transition;
            }
        }
        return null;
    }

    public State(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
