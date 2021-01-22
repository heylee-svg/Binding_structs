package com.cylan.bindingdemo;

import android.content.Context;
import android.util.Log;

import com.cylan.bindingdemo.bind.BindView;
import com.cylan.bindingdemo.bind.BinderContext;
import com.cylan.bindingdemo.bind.IBindState;
import com.cylan.bindingdemo.bind.state.BindingState;
import com.cylan.bindingdemo.bind.IContext;
import com.cylan.bindingdemo.bind.state.PingInfoState;
import com.cylan.bindingdemo.bind.state.ScanState;

public class BinderHandler extends BinderContext implements IContext.ActionListener {

    BindView bindView;//给MainActivity用用来更新UI
    BinderContext binderContext;//用来操作各种state

    public BinderHandler(Context context, BindView bindView) {
        super(context);
        this.bindView = bindView;
        init(context);
    }

    public void init(Context context) {
        binderContext = new BinderContext(context);
        binderContext.setActionListener(this); //这里设置一个接口给state回调binderHandler方法
        IBindState scanState = new ScanState(); //这里this是BinderHandler 如果这么写scanstate getcontext就会有问题
        IBindState pingInfoState = new PingInfoState();
        IBindState bindingState = new BindingState();

        binderContext.addState(bindingState);
        binderContext.addState(pingInfoState);
        binderContext.addState(scanState);

    }

    public BinderContext getBinderContext() {
        return binderContext;
    }

    @Override
    public void onDoAction(IBindState state, Object result) {
        Log.i("BinderHandler", state + "callback onDoAction");


    }

    @Override
    public void onActionFailed(IBindState state, int reason) {

    }

    @Override
    public void onActionStart(IBindState state) {
        binderContext.removeState(state);
        if (binderContext.getCurrentState() != null) {
            binderContext.getCurrentState().startAction();
        }

    }
}