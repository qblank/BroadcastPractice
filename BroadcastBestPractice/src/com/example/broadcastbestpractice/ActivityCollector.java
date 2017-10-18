package com.example.broadcastbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
/**
 * �������
 * @author evan_qb
 *
 */
public class ActivityCollector {
	public static List<Activity> activities = new ArrayList<Activity>();
	
	/**
	 * ��ӻ
	 * @param activity
	 */
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	
	/**
	 * �Ƴ��
	 * @param activity
	 */
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	
	/**
	 * �Ƴ�����
	 */
	public static void finishAll(){
		for (Activity activity : activities) {
			//�ж��Ƿ��Ѿ��˳�
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
}
