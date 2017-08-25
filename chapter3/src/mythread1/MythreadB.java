package mythread1;

public class MythreadB extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			System.out.println("线程B开始");
			Thread.sleep(3000);
			System.out.println("线程B结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void methodA(){
		System.out.println("methodA方法执行了");
	}
	
}
