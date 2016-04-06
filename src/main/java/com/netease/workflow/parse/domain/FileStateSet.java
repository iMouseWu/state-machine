package com.netease.workflow.parse.domain;

import java.util.List;

/**
 * @author wuhao
 */
public class FileStateSet {
    private String name;

    private String code;

    private List<BaseFileTransitionSet> transitions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BaseFileTransitionSet> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<BaseFileTransitionSet> transitions) {
        this.transitions = transitions;
    }
}
