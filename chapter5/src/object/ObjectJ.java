package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//Timer的cancel()方法的注意事项:有时候使用该方法不一定会停止任务，而是正常执行
public class ObjectJ {
	
	static int i = 0;
	
	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("正常执行" + i);
		}
	}
	
	public static void main(String[] args) throws ParseException {
		while (true) {
			i++;
			Timer timer = new Timer();
			MyTask myTask = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2017-07-29 00:57:00";
			Date date = sdf.parse(dateString);
			
			timer.schedule(myTask, date);
			timer.cancel();
			/*
			 * 据说这是Timer类中的cancel()方法有时并没有争抢到queue锁，
			 * 	所以TimerTask类中任务继续正常执行
			 */
		}
	}
	
}
