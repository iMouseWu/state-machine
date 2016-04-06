package com.netease.workflow.core;

import java.util.List;
import java.util.Map;

/**
 * @author wuhao
 */
public class MultipleTransition extends BaseTransition {

    private Map<String, List<Command>> leaveCommandMap;

    private Map<String, List<Command>> reachCommandMap;

    public Map<String, List<Command>> getLeaveCommandMap() {
        return leaveCommandMap;
    }

    public void setLeaveCommandMap(Map<String, List<Command>> leaveCommandMap) {
        this.leaveCommandMap = leaveCommandMap;
    }

    public Map<String, List<Command>> getReachCommandMap() {
        return reachCommandMap;
    }

    public void setReachCommandMap(Map<String, List<Command>> reachCommandMap) {
        this.reachCommandMap = reachCommandMap;
    }

    public List<Command> getLeaveCommands(String commandKey) {
        return leaveCommandMap.get(commandKey);
    }

    public List<Command> getReachCommands(String commandKey) {
        return reachCommandMap.get(commandKey);
    }
}
