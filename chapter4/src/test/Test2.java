package test;

import object1.ObjectM;
import object1.ObjectN;
import object1.ObjectO;
import object1.ObjectP;
import object1.ObjectQ;
import object1.ObjectR;
import object1.ObjectS;
import object1.ObjectT;

import org.junit.Test;

public class Test2 {

	//方法boolean hasQueuedThread(Thread thread):的作用是查询指定线程是否正在等待获取此锁
	@Test
	public void hasQueuedThread() throws InterruptedException{
		final ObjectM objectM = new ObjectM();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objectM.waitMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread.sleep(500);
		
		Thread thread2 = new Thread(runnable);
		thread2.start();
		Thread.sleep(500);
		
		System.out.println(objectM.lock.hasQueuedThread(thread));//thread是否在等待这把锁，thread已经拿到了该锁 ，所以不存在等待
		System.out.println(objectM.lock.hasQueuedThread(thread2));//该锁已经被线程thread拿到了，thread2是正在等待这把锁，所以是true
		System.out.println(objectM.lock.hasQueuedThreads());//和上面一样，也是在等待thread拿到的那把锁
	}
	
	
	//方法boolean hasWaiters(Condition condition):作用是查询是否有线程正在等待与此锁有关的condition条件
	@Test
	public void hasWaiters() throws InterruptedException{
		final ObjectN objectN = new ObjectN();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objectN.waitMethod();
			}
		};
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}
		Thread.sleep(1000);
		objectN.notityMethod();
		/*
		 * 第一个输出是所有线程都在等待，因为十个线程都启动了都执行了condition.await();这一行代码，所有十个线程都在等待着
		 * 	第二个输出为零是因为执行了condition.signalAll();这一行代码，所有线程都被唤醒了，就没有正在等待的condition
		 */
	}
	
	
	//方法boolean isFair():作用是判断是不是公平锁
	@Test
	public void isFair(){
		final ObjectO objectO = new ObjectO(true);//这里可以将锁的公平性改为false
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				objectO.methodA();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		/*
		 * 在默认的情况下。ReentreantLock类使用的是公平锁
		 */
	}
	
	
	//方法boolean isHeldByCurrentThread():作用是查询当前的线程是不是保持此锁定
	@Test
	public void isHeldByCurrentThread(){
		final ObjectP objectP = new ObjectP(true);
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectP.method();
			}
		};
		thread.start();
	}
	
	
	//方法boolean isLocked()的作用是查询此锁定是否由任意线程保持
	@Test
	public void isLockes(){
		final ObjectQ objectQ = new ObjectQ(true);
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectQ.methodA();
			}
		};
		thread.start();
	}
	
	
	//方法lockInterruptibly():如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常
	@Test
	public void lockInterruptibly() throws InterruptedException{
		final ObjectR objectR = new ObjectR();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objectR.waitMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread.sleep(500);
		Thread thread2 = new Thread(runnable);
		thread2.start();
		thread2.interrupt();//这里线程B被中断了
		System.out.println("main end");
		Thread.sleep(5000);
		/*
		 * 第一次代码代码为lock.lock()时候，线程B被中断了，但是还是能正常执行
		 * 	修改代码为lock.lockInterruptibly()时候，线程B被中断了(就是调用interrupt())，
		 * 		当线程B执行lock.lockInterruptibly()这一行代码的时候，就会判断线程B是不是已经被中断了，如果没有则获取锁定
		 * 			如果已经中断了，则会抛出异常
		 */
	}
	
	
	//方法boolean tryLock()的作用是:仅在调用时锁定未被另一个线程保持的情况下，才获取该锁定
	@Test
	public void tryLock(){
		final ObjectS objectS = new ObjectS();
		Runnable runnable = new Runnable() {
			public void run() {
				objectS.waitMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		/*
		 * thread2在调用tryLock()方法的时候，thread是已经获得了锁，
		 * 	所以thread2没有获得锁
		 */
	}
	
	
	 //方法awaitUninterruptibly()的使用,
	@Test
	public void awaitUninterruptibly() throws InterruptedException{
		final ObjectT objectT = new ObjectT();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				objectT.waitMethod();
			}
		};
		thread.start();
		Thread.sleep(1000);
		thread.interrupt();
		/*
		 * 运行一次后把上面的代码objectT.waitMethod();改为objectT.waitMethodA();
		 * 	再看两次运行的结果有什么不同
		 */
	}
	
}
