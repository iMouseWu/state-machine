package com.netease.workflow;

import com.netease.workflow.bo.Context;
import com.netease.workflow.core.State;

/**
 * @author wuhao
 */
public interface StateMachine {

    State transform( Context context);


}
