package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import object.ObjectO.MyTask;

//验证scheduleAtFixedRate方法具有追赶执行性
public class ObjectP {
	
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
		timer.scheduleAtFixedRate(myTask, date, 5000);
		
	}

}
