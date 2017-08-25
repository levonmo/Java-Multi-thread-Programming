package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectG {

	private ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	private boolean hasValue = false;
	
	public void set(){
		try {
			lock.lock();
			while (!hasValue) {
				condition.await();
			}
			System.out.println("¥Ú”°°Ô");
			hasValue = true;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void get(){
		try {
			lock.lock();
			while (hasValue) {
				condition.await();
			}
			System.out.println("¥Ú”°°Ô°Ô");
			hasValue = false;
			condition.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
}
