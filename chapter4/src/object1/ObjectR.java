package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectR {

	public ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void waitMethod(){
		try {
//			lock.lock();
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				System.out.println("线程" + Thread.currentThread().getName() + "进入catch");
				e.printStackTrace();
			}
			System.out.println("lock开始" + "当前的线程是" + Thread.currentThread().getName() );
			for (int i = 0; i < 10000000; i++) {
				String string = new String();
				Math.random();
			}
			System.out.println("lock结束" + "当前的线程是" + Thread.currentThread().getName() );
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}
	
}
