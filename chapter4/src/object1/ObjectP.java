package object1;

import java.util.concurrent.locks.ReentrantLock;

//查询当前的线程是不是保持此锁定
public class ObjectP {

	private ReentrantLock lock;
	
	public ObjectP(boolean isFair) {
		lock = new ReentrantLock(isFair);
	}
	
	public void method(){
		try {
			System.out.println("该线程是不是锁定了此锁，这是在未上锁之前" + lock.isHeldByCurrentThread());
			lock.lock();
			System.out.println("该线程是不是锁定了此锁,这是在上锁之后的" + lock.isHeldByCurrentThread());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
