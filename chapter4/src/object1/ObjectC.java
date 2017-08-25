package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectC {

	private Lock lock = new ReentrantLock();

	//使用ReentrantLock也可以实现同样的功能，但是要借助Condition对象
	private Condition condition = lock.newCondition();
	
	public void await(){
		try {
			lock.lock();
			System.out.println("A");
			condition.await();
			System.out.println("B");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println("锁释放了");
		}
	}
}
