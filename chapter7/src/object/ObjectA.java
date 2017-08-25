package object;

public class ObjectA extends Thread {
	
	public ObjectA() {
		System.out.println("构造方法中状态" + Thread.currentThread().getState());
	}
	
	public void run() {
		System.out.println("run方法中状态" + Thread.currentThread().getState());
	}
	
}

