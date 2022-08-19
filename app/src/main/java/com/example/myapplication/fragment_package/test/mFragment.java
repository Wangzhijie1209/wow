package com.example.myapplication.fragment_package.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class mFragment extends Fragment {

    private Button button;
    private TextView test;
    private Bundle bundle;
    private String message;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.test_fragment, container, false);
        button = contentView.findViewById(R.id.test_button);
        test = contentView.findViewById(R.id.test_text);

        //步骤1:通过getArgments()获取从Activity传过来的全部值
        bundle = this.getArguments();

        //步骤2:获取某一值
        message = bundle.getString("message");

        //步骤3:设置按钮,将设置的值显示出来
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示传递过来的值
                test.setText(message);
            }
        });

        return contentView;

    }

}
