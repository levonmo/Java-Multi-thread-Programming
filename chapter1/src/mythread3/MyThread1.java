package mythread3;

//能停止的线程，暴力停止，使用stop()方法
public class MyThread1 extends Thread {
	
	private int i = 0;
	
	@Override
	public void run() {
		super.run();
		try {
			while(true){
				i++;
				System.out.println(i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
