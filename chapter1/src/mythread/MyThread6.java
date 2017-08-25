package mythread;

//解决“非线程安全问题”
public class MyThread6 extends Thread{
	private int count = 5;

	/*	
	 *	这里使用synchronized关键字，是多个线程执行run方法时，排队的方式进行处理，
	 *	一个线程想要调用run方法，必须要拿到这把锁
	 *	当一个线程调用run前，首先判断run方法有没有被上锁，有的话证明其他线程已经拿到了这把锁
	 *	证明有其他线程正在调用该方法，要等待拿到这把锁的线程调用结束才能执行run方法，释放锁对象才能到下一个线程执行
	 *	
	 *	synchronized可以在任意对象和方法上进行加锁
	 *
	 */
	synchronized public void run() {
		super.run();
		count--;
		System.out.println("由:" + Thread.currentThread().getName() + "计算得count=" + count);
	}
	
}
