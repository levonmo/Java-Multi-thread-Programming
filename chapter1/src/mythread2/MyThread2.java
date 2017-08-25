package mythread2;

//如果将线程对象以构造参数的方式传递给Thread对象，进行strat()启动时
public class MyThread2 extends Thread{

	public MyThread2() {
		System.out.println("构造器开始");
		System.out.println("Thread的线程名字" + Thread.currentThread().getName());
		System.out.println("Thread线程是否活跃" + Thread.currentThread().isAlive());
		System.out.println("this线程的名字" + this.getName());
		System.out.println("this线程是否活跃" + this.isAlive());
		System.out.println("构造器结束");
	}
	
	@Override
	public void run() {
		System.out.println("run方法开始");
		System.out.println("Thread的线程名字" + Thread.currentThread().getName());
		System.out.println("Thread线程是否活跃" + Thread.currentThread().isAlive());
		System.out.println("this线程的名字" + this.getName());
		System.out.println("this线程是否活跃" + this.isAlive());
		System.out.println("run结束");
	}
	
	
}
