package mythread2;

//sleep()方法(1)
public class MyThread3 extends Thread{
	
	@Override
	public void run() {
		try {
			System.out.println("run方法的this线程" + this.currentThread().getName()+ "开始");
			Thread.sleep(2000);
			System.out.println("run方法的this线程" + this.currentThread().getName()+ "结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
