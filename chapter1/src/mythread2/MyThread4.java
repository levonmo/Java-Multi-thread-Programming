package mythread2;

//sleep()方法(2)
public class MyThread4 extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("run的this线程开始" + this.currentThread().getName() + System.currentTimeMillis());
			System.out.println("Thread的线程是" + Thread.currentThread().getName());
			System.out.println("run的this线程结束" + this.currentThread().getName() + System.currentTimeMillis());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
