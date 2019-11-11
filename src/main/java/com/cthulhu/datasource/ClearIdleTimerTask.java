package com.cthulhu.datasource;

import java.util.TimerTask;

/**
 * 清除空闲连接任务
 *
 * @author Administrator
 */
public class ClearIdleTimerTask extends TimerTask {
	@Override
	public void run() {
		DDSHolder.instance().clearIdleDDS();
	}
}
