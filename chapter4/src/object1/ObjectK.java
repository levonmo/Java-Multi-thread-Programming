package object1;

import java.util.concurrent.locks.ReentrantLock;

public class ObjectK {
	
	public ReentrantLock lock = new ReentrantLock();
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("当前的线程是进入" + Thread.currentThread().getName());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
