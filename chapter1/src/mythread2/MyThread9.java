package mythread2;

//线程停止(执行了interrupt方法),在执行sleep方法
public class MyThread9 extends Thread{
	
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("run方法开始");
			Thread.sleep(1000);
			System.out.println("run方法结束");
		} catch (InterruptedException e) {
			System.out.println("进入了异常代码块");
			e.printStackTrace();
		}
	}

}
