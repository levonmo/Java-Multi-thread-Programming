package object;

/*
 * 方法scheduleAtFixedRate(TimerTask task,Date firstTime,long period)的测试
 * 	方法schedule和scheduleAtFixedRate都是会顺序来执行的，所以不用考虑非线程安全的情况	
 * 		主要的区别就是不延时的情况:
 * 			使用schedule方法:不延时，下一次任务执行时间的参考的是上一次任务的"开始"时的时间来计算
 * 			使用scheduleAtFixedRate方法:不延时，下一次任务执行时间的参考的是上一次任务的"结束"时的时间来计算
 * 
 * 		延时的情况则没有区别:也就是使用schedule和scheduleAtFixedRate方法都是如果执行任务的时间被延时了，
 * 						那么下一次任务的执行时间参考的是上一次任务的"结束"时的时间来计算
 * 
 */
public class ObjectN {
	//就不进行测试了
	//在这里可以分四种情况讨论:schedule延时和不延时，scheduleAtFixedRate延时和不延时 
}
