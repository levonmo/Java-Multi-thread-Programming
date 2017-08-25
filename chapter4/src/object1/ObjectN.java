package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectN  {
	
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void waitMethod(){
		try {
			lock.lock();
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
			System.out.println("有没有线程正在等待condition" + "  " + lock.hasWaiters(condition) + "线程的个数是多少" + lock.getWaitQueueLength(condition));
			condition.signalAll();
			System.out.println("有没有线程正在等待condition" + "  " + lock.hasWaiters(condition) + "线程的个数是多少" + lock.getWaitQueueLength(condition));

		}finally {
			
			lock.unlock();
		}
	}
	
}
