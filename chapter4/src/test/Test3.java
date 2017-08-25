package test;

import object1.ObjectU;
import object1.ObjectV;
import object1.ObjectW;

import org.junit.Test;

public class Test3 {
	
	
	/*
	 * 
	 * 使用ReentrantReadWriteLock类
	 * 	
	 * 		ReentrantLock具有完全互斥排他的效果，即同一时间只有一个线程在执行ReentrantLock.lock()方法后面的任务。
	 * 		这样做谁让保证了实例变量的线程安全性，但效果却是非常的低下。
	 * 		
	 * 	所以在JDK中提供了一种读写锁ReentrantReadWriteLock类，是用它可以加快运行的效率，在某些不需要操作实例变量的方法中，完全可以使用读写锁
	 * 		来提升该方法的代码运行速度
	 * 
	 * 	读写锁表示也有两个锁，一个是读操作相关的锁，也称为共享锁，另一个是写操作相关的锁，也叫排他锁。也就是多个读锁之间不互斥，读锁与写锁互斥，
	 * 		写锁与写锁之间互斥。在没有线程进行写入操作是，进行读取操作的多个线程都可以获取读锁，而进行写入操作的线程只有在获取写锁后才能进行写入操作。
	 * 
	 * 		即多个线程可以同时进行读取操作，但是同一时刻只能有一个线程进行写入操作 
	 * 
	 */
	
	
	//类ReentrantReadWriteLock的使用:读读共享
	@Test
	public void readLock(){
		final ObjectU objectU = new ObjectU();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectU.readLock();
			}
		};
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectU.readLock();
			}
		};
		
		thread.start();
		thread2.start();
		/*
		 * 两个线程几乎同时进入lock()方法和后面的代码，说明在此使用了lock.readLock()读锁可以提高程序的运行效率，
		 * 		允许多个线程同时执行lock()方法后面的代码
		 */
	}
	

	//类ReentrantReadWriteLock的使用:写写互斥
	@Test
	public void writeLock() throws InterruptedException{
		final ObjectV objectV = new ObjectV();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectV.write();
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectV.write();
			}
		};
		thread2.start();
		Thread.sleep(10000);
		/*
		 * 使用写锁代码lock.writeLock()的效果就是同一时间只能有一个线程执行锁里面的方法
		 * 
		 */
	}

	
	//类ReentrantReadWriteLock的使用:读写互斥
	@Test
	public void read_write() throws InterruptedException{
		final ObjectW objectW = new ObjectW();
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectW.read();
			}
		};
		thread.start();
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectW.write();
			}
		};
		thread2.start();
		Thread.sleep(3000);
		/*
		 * 此实验说明"读写"是互斥的，只有线程进入了同一个对象的读锁，另一个线程想进入这个对象的写锁，
		 * 		必须要等到读锁释放锁，写锁才能获取该对象的写锁
		 * 
		 * 同理"写读"也是互斥的，只有"读读"是异步，非互斥的
		 */
	}
	
	
}
