package mythread;

//留意i--与System.out.println的异常
public class MyThread8 extends Thread {
	private int i = 5;
	@Override
	//在println()方法的内部是同步的，但是i--的操作却是在println()方法执行之前进行操作的，所以还是要在run方法加上同步代码块
	synchronized public void run() {
		System.out.println("i=" + (i--) + "当前线程的名字" + Thread.currentThread().getName());
	}
}
