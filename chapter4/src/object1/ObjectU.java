package object1;

import java.util.concurrent.locks.ReentrantReadWriteLock;
//∂¡À¯
public class ObjectU {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void readLock(){
		try {
			lock.readLock().lock();
			System.out.println("ªÒ»°¡À∂¡À¯" + Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.readLock().lock();
		}
	}
	
}