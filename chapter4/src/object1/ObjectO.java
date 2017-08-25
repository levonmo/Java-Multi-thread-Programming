package object1;

import java.util.concurrent.locks.ReentrantLock;

public class ObjectO {

	private ReentrantLock lock;
	
	//构造器输入是不是公平锁
	public ObjectO(boolean isFair) {
		lock = new ReentrantLock(isFair);
	}
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("锁的公平情况" + lock.isFair());
		} finally {
			lock.unlock();
		}
		
	}
	
}
