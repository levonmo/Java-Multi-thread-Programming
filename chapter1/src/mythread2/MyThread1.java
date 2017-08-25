package mythread2;

//判断当前的线程是否处于活动的状态
public class MyThread1 extends Thread {

	@Override
	public void run() {
		System.out.println("run=" + this.isAlive());
	}
}
