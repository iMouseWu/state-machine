package com.netease.workflow.command.order;

import com.netease.workflow.bo.Context;
import com.netease.workflow.bo.Result;
import com.netease.workflow.core.Command;

/**
 * @author wuhao
 *         状态改变命令
 */
public class StateChangeCommand extends Command {

    private String code = "C_stateChange";

    private String name = "状态改变命令";

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Result action(Context context) {
        //调用订单接口,修改订单状态
        return null;
    }
}
