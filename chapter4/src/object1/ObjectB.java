package object1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectB {
	
	private Lock lock = new ReentrantLock();
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("方法A开始" + "当前线程是" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("方法A结束" + "当前线程是" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
	}
	
	public void methodB(){
		try {
			lock.lock();
			System.out.println("方法B开始" + "当前线程是" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("方法B结束" + "当前线程是" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			//在这里记得要释放锁
			lock.unlock();
		}
	}
	
	
}
