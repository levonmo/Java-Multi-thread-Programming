package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//执行任务的时间晚于当前的时间:在未来执行的效果
public class ObjectA {
	
	private static Timer timer = new Timer();//将true放进 Timer()中就是守护线程了
	
	static public class MyTask extends TimerTask{

		@Override
		public void run() {
			System.out.println("运行了，时间为:" + new Date() );
		}
	}
	
	public static Timer getTimer(){
		return timer;
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask task = new MyTask();
		
		//这里是定义一个时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-28 22:41:00";
		Date dateRef = sdf.parse(dateString);
		System.out.println("字符串时间:" + dateRef.toLocaleString() + "当前时间" + new Date().toLocaleString());
		
		//这才是真正的计数器，需要两个参数，一个是继承了TimerTask的实现类，一个是日期
		timer.schedule(task, dateRef);
		/*
		 * 程序运行后进程还没有销毁，为什么会出现这样的情况
		 * 	Timer的构造放方法是
		 * 		public Timer(String name){
		 * 			thread.setName(name);
		 * 			thread.start();
		 * 		}
		 * 	
		 * 	查看构造方法可以知道，创建一个Timer就是启动一个新的线程，这个新启动的线程并不是守护线程，它一直在运行	
		 * 
		 * 	下一步将新创建的Timer改成守护线程
		 * 
		 */
	}
	
}
