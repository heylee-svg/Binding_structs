package com.cylan.bindingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cylan.bindingdemo.bind.BindView;

public class MainActivity extends AppCompatActivity implements BindView {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BinderHandler binderHandler = new BinderHandler(this, this);
        textView = findViewById(R.id.click_me);
        textView.setOnClickListener(v -> {
            if (binderHandler.getBinderContext().getCurrentState() != null) {
                binderHandler.getBinderContext().getCurrentState().startAction();
            }
        });
    }

    //这个方法用来更新UI
    @Override
    public void startBinding() {

    }
}