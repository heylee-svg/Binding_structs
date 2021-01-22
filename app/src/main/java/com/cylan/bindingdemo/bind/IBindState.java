package com.cylan.bindingdemo.bind;

/**
 * @author: Denghg  @createDate: 2021/1/21 下午3:44
 * @description
 **/
public interface IBindState {
    String TAG = "IBindState";

    /**
     * ：开始工作.
     */
    void startAction(Object... objects);

    void stopAction() throws Exception;

    void setAContext(AContext context);
}
