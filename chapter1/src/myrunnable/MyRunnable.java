package myrunnable;

//实现runnable接口，创建一个新线程类。当一个类已经有一个父类了，这时候就不能直接使用继承Thread类了来开启一个新的线程，java不支持多继承，所以要实现runnable接口
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("running");
	}

}
