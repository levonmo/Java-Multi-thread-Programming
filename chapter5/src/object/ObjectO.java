package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//验证schedule方法不具有追赶执行性
public class ObjectO {
	
	private static Timer timer = new Timer();
	
	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("1开始运行了，时间为" + new Date());
			System.out.println("1结束运行了，时间为" + new Date());
		}
	}

	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		
		//定义一个时间出来
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-29 13:26:00";
		Date date = sdf.parse(dateString);
		System.out.println("字符串的时间是" + date.toLocaleString() + "当前时间是" + new Date().toLocaleString());
		timer.schedule(myTask, date, 5000);
		/*
		 * 就是之前过了时间没有执行的循环就不会在执行了，而是按照当前时间每隔5秒执行一次任务
		 * 	而scheduleAtFixedRate就是时间过了，它会计算出过了多少时间，然后将之前没有执行的循环补回来，比如时间过了50s了，它会补十次循环回来
		 */
	}
}
