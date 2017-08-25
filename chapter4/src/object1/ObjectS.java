package object1;

import java.util.concurrent.locks.ReentrantLock;

//tryLock():作用就是仅在调用的是锁定未被另一个线程保持的情况下，才获取该锁定
public class ObjectS {
	
	public ReentrantLock lock = new ReentrantLock();
	
	public void waitMethod(){
		if (lock.tryLock()) {
			System.out.println("线程" + Thread.currentThread().getName() + "获取锁");
		}else {
			System.out.println("线程" + Thread.currentThread().getName() + "没有获取锁");
		}
	}

}
