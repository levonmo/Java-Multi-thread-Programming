package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//计划时间早于当前时间:提前运行的效果。如果计划时间早于当前时间，则立即执行任务
public class ObjectF {


	static public class MyTask extends TimerTask{
		public void run() {
			System.out.println("运行了，当前的时间是" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		
		//创建一个时间出来
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-29 00:23:00";
		Date date = sdf.parse(dateString);
		
		//创建一个定时器
		Timer timer = new Timer();
		timer.schedule(myTask, date, 2000);
		/*
		 *	从控制台打印的结果就是
		 *		程序运行后立即执行 TimerTask任务
		 * 
		 */
	}
	
}
