package mythread3;

//线程的优先级
public class MyThread9 extends Thread {
	
	@Override
	public void run() {
		System.out.println("thread1的线程" + this.getPriority());
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				System.out.println("thread2的线程" + this.getPriority());
			}
		};
		thread2.start();
	}
}
