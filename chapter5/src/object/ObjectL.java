package object;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 方法schedule(TimerTask task,long delay)的测试
 * 	 该方法的作用是以执行schedule(TimerTask task,long delay)方法当前时间为参考时间，在此基础上延迟指定的毫秒数后执行一次任务
 */
public class ObjectL {
	
	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("运行了，时间为" + new Date());
		}
	}
	
	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		Timer timer = new Timer();
		System.out.println("当前的时间是" + new Date().toLocaleString());
		timer.schedule(myTask, 5000);
	}

}
