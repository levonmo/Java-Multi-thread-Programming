package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectL {

	private ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void await(){
		 try {
			lock.lock();
			 System.out.println("线程进入await方法" + Thread.currentThread().getName());
			 condition.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		 
	}
	
	
	public void notityMethod(){
		try {
			lock.lock();
			System.out.println("有" + lock.getWaitQueueLength(condition) + "线程正在等待condition");
		} finally {
			lock.unlock();
		}
		
	}
	
}
