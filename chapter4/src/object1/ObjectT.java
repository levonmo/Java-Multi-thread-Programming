package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectT {

	private ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void waitMethod(){
		try {
			lock.lock();
			System.out.println("await之前");
			condition.await();
			//执行带这里就进入到阻塞的状态，只有被唤醒后才会运行以下的代码
			System.out.println("await之后");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void waitMethodA(){
		try {
			lock.lock();
			System.out.println("await之前");
			condition.awaitUninterruptibly();
			System.out.println("await之后");
		} finally {
			lock.unlock();
		}
	}
	
}
