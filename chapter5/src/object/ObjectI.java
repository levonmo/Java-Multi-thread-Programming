package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//Timer类的cancel()方法:与TimerTask中的不同，Timer类中的作用是将任务队列中的全部任务清空
public class ObjectI {

	private static Timer timer = new Timer();
	
	static public class MyTask1 extends TimerTask {
		public void run() {
			System.out.println("运行了，时间为" + new Date());
			timer.cancel();
		}
	}
	
	static public class MyTask2 extends TimerTask{
		public void run() {
			System.out.println("运行了，时间为" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask1 myTask1 = new MyTask1();
		MyTask2 myTask2 = new MyTask2();
		
		//定义一个时间
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1 = "2017-07-29 00:49:00";
		String dateString2 = "2017-07-29 00:49:01";
		Date date1 = sdf1.parse(dateString1);
		Date date2 = sdf2.parse(dateString2);
			
		timer.schedule(myTask1, date1, 1000);
		timer.schedule(myTask2, date2, 1000);
		/*
		 * Timer类中的cancel()方法的作用是将任务队列中的全部任务清空
		 * 	全部任务被清除，并且进程被销毁，按钮红色变灰色
		 */
	}
	
}
