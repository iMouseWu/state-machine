package com.netease.workflow.parse.read.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.workflow.parse.domain.*;
import com.netease.workflow.parse.read.ConfigLoad;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wuhao
 */
public class LocalFileConfigLoad implements ConfigLoad {

    @Override
    public ConfigInfo load() {
        File path = new File(this.getClass().getResource("/").getPath());
        File file = new File(path.getAbsolutePath() + "/config/config.json");
        String info = null;
        try {
            info = FileUtils.readFileToString(file);
        } catch (IOException e) {
            //TODO
        }

        ConfigInfo configInfo = new ConfigInfo();

        JSONObject jsonObject = JSON.parseObject(info);
        JSONArray eventsJsonArray = jsonObject.getJSONArray("events");
        List<FileEventSet> fileEventSets = JSON.parseArray(eventsJsonArray.toJSONString(), FileEventSet.class);
        configInfo.setEvents(fileEventSets);

        JSONArray commandsJsonArray = jsonObject.getJSONArray("commands");
        List<FileCommandSet> fileCommandSets = JSON.parseArray(commandsJsonArray.toJSONString(), FileCommandSet.class);
        configInfo.setCommands(fileCommandSets);

        JSONArray statesJsonArray = jsonObject.getJSONArray("states");
        List<FileStateSet> states = new ArrayList<>();
        for (int i = 0; i < statesJsonArray.size(); i++) {
            FileStateSet state = new FileStateSet();
            JSONObject statesJSONObject = statesJsonArray.getJSONObject(i);
            String name = statesJSONObject.getString("name");
            state.setName(name);
            String code = statesJSONObject.getString("code");
            state.setCode(code);
            JSONArray transitionsJSONArray = statesJSONObject.getJSONArray("transitions");
            List<BaseFileTransitionSet> baseTransitions = new ArrayList<>();
            for (int j = 1; i < transitionsJSONArray.size(); j++) {
                BaseFileTransitionSet baseFileTransitionSet = null;
                JSONObject transitionsJsonObject = transitionsJSONArray.getJSONObject(j);
                JSONArray reachCommandsJsonArray = transitionsJsonObject.getJSONArray("reachCommands");
                JSONArray leaveCommandsJsonArray = transitionsJsonObject.getJSONArray("leaveCommands");
                if (CollectionUtils.isNotEmpty(reachCommandsJsonArray) && CollectionUtils.isNotEmpty
                        (leaveCommandsJsonArray)) {
                    List<String> reachCommands = JSON.parseArray(reachCommandsJsonArray.toJSONString(), String.class);
                    List<String> leaveCommands = JSON.parseArray(leaveCommandsJsonArray.toJSONString(), String.class);
                    baseFileTransitionSet = new FileTransitionSet();
                    ((FileTransitionSet) baseFileTransitionSet).setLeaveCommands(leaveCommands);
                    ((FileTransitionSet) baseFileTransitionSet).setReachCommands(reachCommands);
                } else {
                    @SuppressWarnings("unchecked")
                    Map<String, List<String>> reachCommandMap = (Map<String, List<String>>) JSON.parseObject
                            (transitionsJsonObject.getJSONObject
                                    ("reachCommandMap").toJSONString(), Map.class);
                    @SuppressWarnings("unchecked")
                    Map<String, List<String>> leaveCommandMap = (Map<String, List<String>>) JSON.parseObject
                            (transitionsJsonObject.getJSONObject
                                    ("leaveCommandMap").toJSONString(), Map.class);
                    baseFileTransitionSet = new MultpleFileTransitionSet();
                    ((MultpleFileTransitionSet) baseFileTransitionSet).setLeaveCommandMap(leaveCommandMap);
                    ((MultpleFileTransitionSet) baseFileTransitionSet).setReachCommandMap(reachCommandMap);
                }
                String toStateCode = transitionsJsonObject.getString("toStateCode");
                String triggerEvent = transitionsJsonObject.getString("triggerEvent");
                baseFileTransitionSet.setToStateCode(toStateCode);
                baseFileTransitionSet.setTriggerEvent(triggerEvent);
                baseTransitions.add(baseFileTransitionSet);
            }
            state.setTransitions(baseTransitions);
            states.add(state);
            configInfo.setStates(states);
        }

        return configInfo;
    }

}
