package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		//�����Ի���Ķ���
		Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("����");
		builder.setMessage("���Ѿ�������Աǿ�����ߣ������µ�¼");
		//����Ϊ����ȡ���Ի���
		builder.setCancelable(false);
		builder.setPositiveButton("ȷ��", new OnClickListener() {
		
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//�ر��߳����������ߵ�
				ActivityCollector.finishAll();
				Intent intent = new Intent(context,LoginActivity.class);
				//�ڹ㲥���������Ҫ������һ��
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		//�ڹ㲥��(�ǻ��)�����Ի���Ҫ���öԻ��������
		AlertDialog alertDialog = builder.create();
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
	}

}
