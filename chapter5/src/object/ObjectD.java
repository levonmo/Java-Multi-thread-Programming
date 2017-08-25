package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//因为前面的任务有可能消耗的时间较长，则后面的任务运行时间也会被延迟
public class ObjectD {

	private static Timer timer = new Timer();
	
	static public class MyTask1 extends TimerTask{
		public void run() {
			try {
				System.out.println("1开始了，时间为" + new Date());
				Thread.sleep(5000);
				System.out.println("1结束了，时间为" + new Date());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static public class MyTask2 extends TimerTask{
		public void run() {
			System.out.println("2运行了，时间为" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask1 myTask1 = new MyTask1();
		MyTask2 myTask2 = new MyTask2();
		
		//定义一个时间出来
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1 = "2017-07-29 00:04:01";
		String dateString2 = "2017-07-29 00:04:02";		
		Date date1 = sdf1.parse(dateString1);
		Date date2 = sdf1.parse(dateString1);
		
		timer.schedule(myTask1, date1);
		timer.schedule(myTask2, date2);
		/*
		 * 	由于myTask1需要5秒执行完任务，所以将要影响myTask2计划任务执行时间，
		 * 		myTask2以此时间为基准，向后延迟5秒。
		 * 	因为Task是被放进队列中的，得一个个运行，等待myTask1运行结束，才会轮到myTask2运行的
		 */
	}
	
}
