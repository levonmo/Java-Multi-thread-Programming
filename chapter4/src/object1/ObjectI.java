package object1;

import java.util.concurrent.locks.ReentrantLock;

//公平锁
public class ObjectI {
	
	private ReentrantLock lock;
	
	public ObjectI(boolean isFair) {
		//设置是否是公平锁
		lock = new ReentrantLock(isFair);
	}	
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("线程的名称是" + Thread.currentThread().getName() + "获得锁");
		}finally {
			lock.unlock();
		}
	}
}
