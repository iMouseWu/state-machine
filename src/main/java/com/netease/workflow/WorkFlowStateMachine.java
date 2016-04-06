package com.netease.workflow;

import com.netease.workflow.bo.Context;
import com.netease.workflow.bo.Result;
import com.netease.workflow.command.order.RefundCommand;
import com.netease.workflow.core.*;
import com.netease.workflow.parse.domain.*;
import com.netease.workflow.parse.read.ConfigLoad;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuhao
 */
public class WorkFlowStateMachine implements StateMachine {

    private final static Map<String, State> stateMap = new HashMap<>();

    private final static Map<String, TriggerEvent> eventMap = new HashMap<>();

    private final static Map<String, Command> commandMap = new HashMap<>();

    private ConfigLoad configLoad;

    @Override
    public State transform(Context context) {
        State fromState = stateMap.get(context.getFromState());
        BaseTransition baseTransition = fromState.transform(context.getTriggerEventCode());

        List<Command> leaveCommands = null;
        List<Command> reachCommands = null;
        if (baseTransition instanceof MultipleTransition) {
            String commandKey = context.getCommandKey();
            if (StringUtils.isBlank(commandKey)) {
                throw new IllegalArgumentException("commandKey is null");
            }
            MultipleTransition multipleTransition = (MultipleTransition) baseTransition;
            leaveCommands = multipleTransition.getLeaveCommands(commandKey);
            reachCommands = multipleTransition.getReachCommands(commandKey);

        } else if (baseTransition instanceof Transition) {
            Transition transition = (Transition) baseTransition;
            leaveCommands = transition.getLeaveCommands();
            reachCommands = transition.getReachCommands();
        }

        for (Command command : leaveCommands) {
            Result result = command.action(context);
        }

        for (Command command : reachCommands) {
            Result result = command.action(context);
        }
        return baseTransition.getToState();
    }

    public void init() {
        ConfigInfo configInfo = configLoad.load();
        initTriggerEvent(configInfo.getEvents());
        initCommand(configInfo.getCommands());

        List<FileStateSet> fileStates = configInfo.getStates();
        for (FileStateSet fileState : fileStates) {
            State state = new State(fileState.getCode(), fileState.getName());
            List<BaseFileTransitionSet> fileTransitions = fileState.getTransitions();
            List<Transition> transitions = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(fileTransitions)) {
                for (BaseFileTransitionSet fileTransition : fileTransitions) {
                    Transition transition = new Transition();
                    transition.setTriggerEvent(eventMap.get(fileTransition.getTriggerEvent()));
//                    transition.setLeaveCommands(generateLeaveCommands(fileTransition.getLeaveCommands()));
//                    transition.setReachCommands(generateLeaveCommands(fileTransition.getReachCommands()));
                    transitions.add(transition);
                }
            }
//            state.setTransitions(transitions);
            stateMap.put(state.getCode(), state);
        }
    }

    private void initTriggerEvent(List<FileEventSet> events) {
        if (CollectionUtils.isNotEmpty(events)) {
            for (FileEventSet event : events) {
                TriggerEvent triggerEvent = new TriggerEvent(event.getCode(), event.getName());
                eventMap.put(event.getCode(), triggerEvent);
            }
        }
    }

    private void initCommand(List<FileCommandSet> fileCommands) {

        if (CollectionUtils.isNotEmpty(fileCommands)) {
            for (FileCommandSet fileCommand : fileCommands) {
                String bean = fileCommand.getBean();
                //TODO 通过spring容器获取bean
                Command command = new RefundCommand();
                commandMap.put(command.getCode(), command);
            }
        }
    }

    private List<Command> generateLeaveCommands(List<String> fileCommands) {
        List<Command> commands = new ArrayList<>();
        for (String fileCommand : fileCommands) {
            Command command = commandMap.get(fileCommand);
            commands.add(command);
        }
        return commands;
    }

}
