package com.example.broadcastbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
/**
 * 活动管理类
 * @author evan_qb
 *
 */
public class ActivityCollector {
	public static List<Activity> activities = new ArrayList<Activity>();
	
	/**
	 * 添加活动
	 * @param activity
	 */
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	
	/**
	 * 移除活动
	 * @param activity
	 */
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	
	/**
	 * 移除所有
	 */
	public static void finishAll(){
		for (Activity activity : activities) {
			//判断是否已经退出
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
}
