package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//计划时间早于当前的时间:提前运行的效果 。如果执行任务的时候早于当前时间，则立即执行任务
public class ObjectB {
	
	private static Timer timer = new Timer();
	
	//这里是定义一个定时器，时间到就会执行run里面的方法了
	static public class MyTask extends TimerTask {

		public void run() {
			System.out.println("运行了，时间为" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask task = new MyTask();
		
		//定义一个时间出来
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-7-28 23:39:00";
		Date dateRef = sdf.parse(dateString);
		System.out.println("字符串的时间是" + dateRef.toLocaleString() + "当前的时间是" + new Date().toLocaleString());
		
		//创建一个定时器出来
		timer.schedule(task, dateRef);
		/*
		 * 如果执行任务的时间早于当前时间，则立即执行task任务
		 */
	}
	

}
