package com.example.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	private EditText accountEdit;
	private EditText pwdEdit;
	private Button login;
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	private CheckBox rememberPass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		accountEdit = (EditText)findViewById(R.id.username);
		pwdEdit = (EditText)findViewById(R.id.pwd);
		login = (Button)findViewById(R.id.btn_consure);
		//创建SharedPreferences对象
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		//找到复选框空间
		rememberPass = (CheckBox) findViewById(R.id.remember_pass);
		//判断是否为空
		boolean isRemember = pref.getBoolean("remember_pass", false);
		if (isRemember) {
			//将账号和密码都设置到文本框中
			String account = pref.getString("account", "");
			String pwd = pref.getString("password", "");
			accountEdit.setText(account);
			pwdEdit.setText(pwd);
			//将复选框的状态改为选中
			rememberPass.setChecked(true);
		}
		
		//登录按钮
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				String account = accountEdit.getText().toString();
				String pwd = pwdEdit.getText().toString();
				if ("admin".equals(account) && "123".equals(pwd)) {
					editor = pref.edit();
					//判断是否被选中
					if (rememberPass.isChecked()) {
						editor.putBoolean("remember_pass", true);
						editor.putString("account", account);
						editor.putString("password", pwd);
					}else{
						editor.clear();
					}
					//提交
					editor.commit();
					//跳转页面
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}else{
					Toast.makeText(getApplicationContext(), "登录失败，账号或密码错误", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
	}
	
}
