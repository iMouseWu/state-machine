package com.netease.workflow.core;

import com.netease.workflow.bo.Context;
import com.netease.workflow.bo.Result;

/**
 * @author wuhao
 */
public abstract class Command implements Event {

    public abstract String getCode();

    public abstract String getName();

    public abstract Result action(Context context);


}
