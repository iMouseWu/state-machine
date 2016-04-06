package com.netease.workflow.command.order;

import com.netease.workflow.bo.Context;
import com.netease.workflow.bo.Result;
import com.netease.workflow.core.Command;

/**
 * @author wuhao
 *         退款命令
 */
public class RefundCommand extends Command {

    private String code = "C_refund";

    private String name = "退款命令";

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
        //调用海淘接口,执行退款操作
        return null;
    }
}
