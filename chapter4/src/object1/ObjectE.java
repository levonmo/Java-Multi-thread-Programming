package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用多个Condition实现通知部分线程:错误的用法
public class ObjectE{
	
	private Lock lock = new ReentrantLock();
	
	public Condition condition = lock.newCondition();
	
	public void awaitA(){
		try {
			lock.lock();
			System.out.println("awaitA开始的时间是" + System.currentTimeMillis() + "当前的线程是" + Thread.currentThread().getName());
			condition.await();
			System.out.println("awaitA结束的时间是" + System.currentTimeMillis() + "当前的线程是" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	
	public void awaitB(){
		try {
			lock.lock();
			System.out.println("awaitB开始的时间是" + System.currentTimeMillis() + "当前的线程是" + Thread.currentThread().getName());
			condition.await();
			System.out.println("awaitB结束的时间是" + System.currentTimeMillis() + "当前的线程是" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void signalAll(){
		try{
			lock.lock();
			System.out.println("signalAll的时间是" + System.currentTimeMillis() + "当前线程是" + Thread.currentThread().getName());
			condition.signalAll();
		} finally {
			lock.unlock();
		}
		
	}
	
}
