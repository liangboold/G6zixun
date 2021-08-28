package com.example.g6information.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.g6information.R;

public class ResActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        initView();
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(user.getText().toString())||TextUtils.isEmpty(pass.getText().toString())){
                    Toast.makeText(ResActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    if (pass.length()<6){
                        Toast.makeText(ResActivity.this, "密码需要大于等于6位数", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent intent = new Intent(ResActivity.this, LoginActivity.class);
                        intent.putExtra("u",user.getText().toString());
                        intent.putExtra("p",pass.getText().toString());
                        startActivity(intent);
                        Toast.makeText(ResActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initView() {
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        res = (Button) findViewById(R.id.res);
    }
}