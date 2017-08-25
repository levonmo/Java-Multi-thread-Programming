package object1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectA {
	
	private Lock lock = new ReentrantLock();
	
	public void methodA(){
		lock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("当前线程是" + Thread.currentThread().getName() + "打印的值是" + i);
		}
		lock.unlock();
	}
	
}
