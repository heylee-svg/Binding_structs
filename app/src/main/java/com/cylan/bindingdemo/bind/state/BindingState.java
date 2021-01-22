package com.cylan.bindingdemo.bind.state;

import android.util.Log;

import com.cylan.bindingdemo.bind.ABindState;
import com.cylan.bindingdemo.bind.AContext;
import com.cylan.bindingdemo.bind.BindView;
import com.cylan.bindingdemo.bind.IBindState;

/**
 * @author: Denghg  @createDate: 2021/1/21 下午3:46
 * @description
 **/
public class BindingState  extends ABindState {
    private String  TAG=BindingState.class.getSimpleName();

    @Override
    public void startAction(Object... objects) {
        Log.i(TAG,"startAction");
        getAContext().getActionListener().onActionStart(this); //这里给个接口回调BinderHandler方法

    }


    @Override
    public void stopAction() throws Exception {
        Log.i(TAG,"stopAction");
    }


}
