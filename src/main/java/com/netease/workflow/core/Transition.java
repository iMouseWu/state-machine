package com.netease.workflow.core;

import java.util.List;

/**
 * @author wuhao
 */
public class Transition extends BaseTransition {

    private List<Command> leaveCommands;

    private List<Command> reachCommands;

    public List<Command> getLeaveCommands() {
        return leaveCommands;
    }

    public void setLeaveCommands(List<Command> leaveCommands) {
        this.leaveCommands = leaveCommands;
    }

    public List<Command> getReachCommands() {
        return reachCommands;
    }

    public void setReachCommands(List<Command> reachCommands) {
        this.reachCommands = reachCommands;
    }
}
