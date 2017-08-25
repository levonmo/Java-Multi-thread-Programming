package object1;

import java.util.concurrent.locks.ReentrantLock;

public class ObjectJ {
	
	private ReentrantLock lock = new ReentrantLock();
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("mehtodA方法开始  getHoldCount=" + lock.getHoldCount());
			methodB();
		} finally {
			lock.unlock();
		}
	}

	public void methodB() {
		try{
			lock.lock();
			System.out.println("methodB方法开始  getHoldCount=" + lock.getHoldCount());
			methodC();
		} finally {
			lock.unlock();
		}
	}

	public void methodC() {
		try{
			lock.lock();
			System.out.println("methodC方法开始  getHoldCount=" + lock.getHoldCount());
		} finally {
			lock.unlock();
		}
	}
	
	
	
}
