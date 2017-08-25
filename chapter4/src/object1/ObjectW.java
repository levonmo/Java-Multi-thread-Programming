package object1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ObjectW {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void read(){
		try {
			lock.readLock().lock();
			System.out.println("进入了读方法" + Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
	
	
	public void write(){
		try {
			lock.writeLock().lock();
			System.out.println("进入了写方法" + Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}
	
}
