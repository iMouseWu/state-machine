package com.netease.workflow;

import com.netease.workflow.bo.Result;

/**
 * @author wuhao
 *         订单状态处理类
 */
public interface OrderStateAction {

    Result closeOrder(String orderId);


}
