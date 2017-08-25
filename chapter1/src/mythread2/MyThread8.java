package mythread2;

//在沉睡中停止
public class MyThread8 extends Thread {
	
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("run开始");
			Thread.sleep(200000);
			System.out.println("run结束");
		} catch (InterruptedException e) {
			System.out.println("在沉睡中被停止了，进入catch	" + this.isInterrupted());
			e.printStackTrace();
		}
	}
	
}
