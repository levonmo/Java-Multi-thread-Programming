package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//任务执行的时间被延迟
public class ObjectG {
	
	static public class MyTask extends TimerTask {
		public void run() {
			try {
				System.out.println("运行了，当前时间为" + new Date());
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		
		//定义一个时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-29 00:30:00";
		Date date = sdf.parse(dateString);
		
		//创建一个计数器
		Timer timer = new Timer();
		timer.schedule(myTask, date, 1000);
		/*
		 * 任务被延迟了，但还是一个一个的执行
		 */
	}

}
