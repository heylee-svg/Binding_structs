package com.cylan.bindingdemo.bind;

import android.content.Context;

/**
 * @author: Denghg  @createDate: 2021/1/21 下午4:34
 * @description
 **/
public interface IContext {
    IContext getAContext();

    Context getContext();

    public interface ActionListener {

        void onDoAction(IBindState state, Object result);

        void onActionFailed(IBindState state, int reason);

        void onActionStart(IBindState state);
    }
}
