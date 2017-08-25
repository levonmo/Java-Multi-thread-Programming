package mythread;

//线程安全问题:共享数据，几个线程可以访问同一变量
public class MyThread5 extends Thread {
	private int count = 12;
	
	@Override
	public void run() {
		super.run();
		count--;
		System.out.println("由" + Thread.currentThread().getName() + "计算得结果为" + count);
		//每一个线程都可以执行run方法一次就是可以对count进行一次减法操作
	}
	
}
