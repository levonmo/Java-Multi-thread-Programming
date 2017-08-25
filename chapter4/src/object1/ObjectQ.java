package object1;

import java.util.concurrent.locks.ReentrantLock;

//作用是查询此锁定是不是由任意的线程保持
public class ObjectQ {

	private ReentrantLock lock ;
	
	public ObjectQ(boolean isFair) {
		lock = new ReentrantLock(isFair);
	}
	
	public void methodA(){
		try {
			System.out.println("此锁是不是由任意的线程保持" + lock.isLocked());
			lock.lock();
			System.out.println("此锁是不是由任意的线程保持" + lock.isLocked());
		} finally {
			lock.unlock();
		}
	}
}
