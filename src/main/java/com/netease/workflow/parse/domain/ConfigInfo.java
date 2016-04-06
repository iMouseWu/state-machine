package com.netease.workflow.parse.domain;

import java.util.List;

/**
 * @author wuhao
 */
public class ConfigInfo {

    private List<FileEventSet> events;

    private List<FileCommandSet> commands;

    private List<FileStateSet> states;

    public List<FileEventSet> getEvents() {
        return events;
    }

    public void setEvents(List<FileEventSet> events) {
        this.events = events;
    }

    public List<FileCommandSet> getCommands() {
        return commands;
    }

    public void setCommands(List<FileCommandSet> commands) {
        this.commands = commands;
    }

    public List<FileStateSet> getStates() {
        return states;
    }

    public void setStates(List<FileStateSet> states) {
        this.states = states;
    }
}
