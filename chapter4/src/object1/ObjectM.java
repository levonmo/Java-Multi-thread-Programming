package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectM  {

	public ReentrantLock lock = new ReentrantLock();
	
	public Condition condition = lock.newCondition();//Condition()这个对象只要是用来实现等待和通知的机制的
	
	public void waitMethod(){
		try {
			lock.lock();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
}
