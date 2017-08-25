package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//多个TimerTask任务延时的测试
public class ObjectC {

	private static Timer timer = new Timer();
	
	static public class MyTask1 extends TimerTask{
		public void run() {
			System.out.println("运行了 时间为" + new Date());
		}
	}
	
	static public class MyTask2 extends TimerTask{
		public void run() {
			System.out.println("运行了 时间为" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask1 task1 = new MyTask1();
		MyTask2 task2 = new MyTask2();
		
		//创建一个时间出来
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1 = "2017-07-28 23:48:00";
		String dateString2 = "2017-07-28 23:47:00";
		Date dateRef1 = sdf1.parse(dateString1);
		Date dateRef2 = sdf2.parse(dateString2);
		System.out.println("字符串一的时间是" + dateRef1.toLocaleString() + "当前的时间是" + new Date().toLocaleString());
		System.out.println("字符串二的时间是" + dateRef2.toLocaleString() + "当前的时间是" + new Date().toLocaleString());
		
		//创建一个定时器
		timer.schedule(task1, dateRef1);
		timer.schedule(task2, dateRef2);
		/*
		 * 	TimerTask是以   队列的方式   一个一个被顺序执行的，所以执行的时间有可能和预期的时间不一致
		 * 		因为前面的任务有可能消耗的时间较长，则后面的任务运行时间也会被延迟
		 */
	}
	
}
