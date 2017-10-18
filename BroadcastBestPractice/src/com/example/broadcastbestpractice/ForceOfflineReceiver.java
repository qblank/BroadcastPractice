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
		//创建对话框的对象
		Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("警告");
		builder.setMessage("你已经被管理员强制下线，请重新登录");
		//设置为不可取消对话框
		builder.setCancelable(false);
		builder.setPositiveButton("确定", new OnClickListener() {
		
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//关闭踢出所有已在线的
				ActivityCollector.finishAll();
				Intent intent = new Intent(context,LoginActivity.class);
				//在广播中启动活动需要加上这一句
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		//在广播中(非活动中)弹出对话框要设置对话框的类型
		AlertDialog alertDialog = builder.create();
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
	}

}
