package mythread;

//currentThread()方法
public class MyThread9 extends Thread {
	
	public MyThread9() {
		System.out.println("构造方法打印的线程是" + Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println("run方法打印的线程是" + Thread.currentThread().getName());
	}
}
