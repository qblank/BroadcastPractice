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
		//����SharedPreferences����
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		//�ҵ���ѡ��ռ�
		rememberPass = (CheckBox) findViewById(R.id.remember_pass);
		//�ж��Ƿ�Ϊ��
		boolean isRemember = pref.getBoolean("remember_pass", false);
		if (isRemember) {
			//���˺ź����붼���õ��ı�����
			String account = pref.getString("account", "");
			String pwd = pref.getString("password", "");
			accountEdit.setText(account);
			pwdEdit.setText(pwd);
			//����ѡ���״̬��Ϊѡ��
			rememberPass.setChecked(true);
		}
		
		//��¼��ť
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				String account = accountEdit.getText().toString();
				String pwd = pwdEdit.getText().toString();
				if ("admin".equals(account) && "123".equals(pwd)) {
					editor = pref.edit();
					//�ж��Ƿ�ѡ��
					if (rememberPass.isChecked()) {
						editor.putBoolean("remember_pass", true);
						editor.putString("account", account);
						editor.putString("password", pwd);
					}else{
						editor.clear();
					}
					//�ύ
					editor.commit();
					//��תҳ��
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}else{
					Toast.makeText(getApplicationContext(), "��¼ʧ�ܣ��˺Ż��������", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
	}
	
}
