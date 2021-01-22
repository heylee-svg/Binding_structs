package com.cylan.bindingdemo.bind;

import androidx.annotation.CallSuper;

/**
 * @author: Denghg  @createDate: 2021/1/21 下午4:21
 * @description
 **/
public abstract class ABindState implements IBindState {
    AContext mAcontext;



    @CallSuper
    public AContext getAContext() {
        return mAcontext;
    }

    @Override
    public void setAContext(AContext context) {
        mAcontext = context;
    }
}
