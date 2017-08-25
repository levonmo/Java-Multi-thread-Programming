package object;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 方法schedule(TimerTask task,long delay,long period)，
 * 	该方法的作用是 以执行该方法的当前时间为参考对象，在此时间的基础上延迟指定的毫秒数，再以某一间隔时间无数次数地执行某一任务
 */
public class ObjectM {

	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("运行了，时间为" + new Date());
		}
	}
	
	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		Timer timer = new Timer();
		System.out.println("当前的时间是" + new Date());
		
		timer.schedule(myTask, 3000, 5000);//第二个参数是几秒后执行，弟三个参数是每隔几秒执行一次
	}
}
