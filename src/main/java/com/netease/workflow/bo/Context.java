package com.netease.workflow.bo;

import com.netease.workflow.core.State;

/**
 * @author wuhao
 *         状态机上下文
 */
public class Context {

    private String orderId;

    private State fromState;

    private String triggerEventCode;

    private String commandKey;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public State getFromState() {
        return fromState;
    }

    public void setFromState(State fromState) {
        this.fromState = fromState;
    }

    public String getTriggerEventCode() {
        return triggerEventCode;
    }

    public void setTriggerEventCode(String triggerEventCode) {
        this.triggerEventCode = triggerEventCode;
    }

    public String getCommandKey() {
        return commandKey;
    }

    public void setCommandKey(String commandKey) {
        this.commandKey = commandKey;
    }
}
