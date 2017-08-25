package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//TimerTask类的cancel()方法
public class ObjectH {
	
	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("运行了MyTask，时间为" + new Date());
		}
	}
	
	static public class MyTask2 extends TimerTask {
		public void run() {
			System.out.println("运行了MyTask2，时间为" + new Date());
			this.cancel();
		}
	}
	
	

	public static void main(String[] args) throws ParseException {
		MyTask myTask1 = new MyTask();
		MyTask2 myTask2 = new MyTask2();//这里添加了cancel()方法
		
		//定义一个时间
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1 = "2017-07-29 00:39:00";
		String dateString2 = "2017-07-29 00:39:01";
		Date date1 = sdf1.parse(dateString1);
		Date date2 = sdf2.parse(dateString2);
		
		//创建一个定时器
		Timer timer = new Timer();
		timer.schedule(myTask1, date1, 1000);
		timer.schedule(myTask2, date2, 1000);
		/*
		 * TimerTask类的cancel()方法将自身从任务队列中被移除，其他任务不受影响
		 */
	}
}
