package mythread;

//演示创建一个新建线程
public class MyThread1 extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread1 is running");
	}
	
}
