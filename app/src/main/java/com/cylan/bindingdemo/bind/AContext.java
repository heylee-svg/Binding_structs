package com.cylan.bindingdemo.bind;

import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 * @author: Denghg  @createDate: 2021/1/21 下午3:47
 * @description
 **/
public abstract class AContext implements IContext {
    private Stack<IBindState> stateStack = new Stack<>();
    Context context;

    private ActionListener actionListener;

    public AContext(Context context) {
        this.context = context;
    }

    @Override
    public IContext getAContext() {
        return this;
    }

    @Override
    public Context getContext() {
        return this.context;
    }


    public void addState(IBindState state) {
        if (stateStack != null && !stateStack.contains(state)) {
            this.stateStack.add(state);
        }
    }

    public void removeState(IBindState state) {
        stateStack.remove(state);
    }

    public IBindState getCurrentState() {
        if (stateStack == null || stateStack.size() == 0) {
            return null;
        }
        IBindState state = stateStack.peek();
        state.setAContext(this); //这里this是BinderContext
        Log.i("current: ", state.getClass().getSimpleName());
        return state;
    }

    public BinderContext.ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
}
