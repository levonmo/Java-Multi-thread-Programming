package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 方法schedule(TimerTask task,Date firstTime,long period)
 * 	该方法的作用是在指定的日期之后，按指定的间隔周期性地无限循环地执行某一任务
 * 		1.计划时间晚于当前时间:在未来执行的效果
 */
public class ObjectE {

	static public class MyTask extends TimerTask{
		public void run() {
			System.out.println("运行了，时间为" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		
		//定义一个时间出来
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-29 00:16:00";
		Date dateTime = sdf.parse(dateString);
				
		//定义一个定时器
		Timer timer = new Timer();
		timer.schedule(myTask, dateTime, 2000);
		/*
		 * 从运行的结果来看主要定时器的时间到了，
		 * 	就会按照给定的时间间隔x秒，每隔x秒执行一次TimerTask任务，并且无期限的重复执行任务
		 */
	}
}
