package mythread;

//线程安全，实例变量不共享
public class MyThread4 extends Thread {
	
	private int count = 5;
	
	public MyThread4(String name) {
		super();
		this.setName(name);//设置线程的名称
	}
	
	@Override
	public void run() {
		super.run();
		while (count > 0) {
			count--;
			System.out.println("由" + Thread.currentThread().getName() + "计算的 count=" + count);
		}
	}
	
}
