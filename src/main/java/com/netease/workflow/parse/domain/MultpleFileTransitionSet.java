package com.netease.workflow.parse.domain;

import java.util.List;
import java.util.Map;

/**
 * @author wuhao
 */
public class MultpleFileTransitionSet extends BaseFileTransitionSet {

    private Map<String, List<String>> reachCommandMap;

    private Map<String, List<String>> leaveCommandMap;

    public Map<String, List<String>> getReachCommandMap() {
        return reachCommandMap;
    }

    public void setReachCommandMap(Map<String, List<String>> reachCommandMap) {
        this.reachCommandMap = reachCommandMap;
    }

    public Map<String, List<String>> getLeaveCommandMap() {
        return leaveCommandMap;
    }

    public void setLeaveCommandMap(Map<String, List<String>> leaveCommandMap) {
        this.leaveCommandMap = leaveCommandMap;
    }
}
