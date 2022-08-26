package com.example.datastorage.sp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class SpTextActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private EditText accountEdit;
    private EditText passwordEdit;
    private CheckBox rememberPass;
    private Button button;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_text);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = findViewById(R.id.sp_account_edittext);
        passwordEdit = findViewById(R.id.sp_password_edittext);
        rememberPass = findViewById(R.id.sp_checkbox);
        button = findViewById(R.id.sp_button);

        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            //将账号和密码都设置到文本框中
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                //如果账号是 admin 且密码是 123456 就认为是登录成功
                if (account.equals("admin") && password.equals("123456")) {
                    edit = pref.edit();
                    if (rememberPass.isChecked()) {//检查复选框是否被选中
                        edit.putBoolean("remember_password", true);
                        edit.putString("account", account);
                        edit.putString("password", password);
                    } else {
                        edit.clear();
                    }
                    edit.apply();
                    Intent intent = new Intent(SpTextActivity.this, TextsActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SpTextActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}