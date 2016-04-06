package com.netease.workflow.parse.domain;

import java.util.List;

/**
 * @author wuhao
 */
public class FileTransitionSet extends BaseFileTransitionSet {

    private List<String> reachCommands;

    private List<String> leaveCommands;

    public List<String> getReachCommands() {
        return reachCommands;
    }

    public void setReachCommands(List<String> reachCommands) {
        this.reachCommands = reachCommands;
    }

    public List<String> getLeaveCommands() {
        return leaveCommands;
    }

    public void setLeaveCommands(List<String> leaveCommands) {
        this.leaveCommands = leaveCommands;
    }
}
