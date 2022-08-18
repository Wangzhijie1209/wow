package com.example.myapplication.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.chat.utils.Hide;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initMsgs();
        initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);
        msgAdapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size() - 1);//当有新消息时
                    //刷新RecyclerView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);//将RecclerView定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                }
            }
        });


    }

    private void initView() {
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
    }

    private void initMsgs() {
        Msg msg = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg);
        Msg msg1 = new Msg("Hello. Who is that?", Msg.TYPE_SEND);
        msgList.add(msg1);
        Msg msg2 = new Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECEIVED);
        msgList.add(msg2);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            //获得当前得到焦点的View.一般情况下就是EditText(特殊情况就是轨迹球或者实体案件回移动焦点)
            View v = getCurrentFocus();

            if (Hide.getInstance().isShowIdHideInput(v, ev)) {
                Hide.getInstance().hideSoftInput(v.getWindowToken(), this);
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}