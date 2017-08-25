package test;

import org.junit.Test;


import other.MyObject;
import other.synchronizedObject.SynchronizedObject;
import other.synchronizedObject.SynchronizedObject2;
import mythread3.MyThread1;
import mythread3.MyThread2;
import mythread3.MyThread3;
import mythread3.MyThread4;
import mythread3.MyThread5;
import mythread3.MyThread6;
import mythread3.MyThread8;
import mythread3.MyThread9;



public class Test3 {

	//能停止的线程，暴力停止，使用stop()方法
	@Test
	public void stop(){
		try {
			MyThread1 myThread1 = new MyThread1();
			myThread1.start();
			Thread.sleep(800);
			myThread1.stop();
			/*
			 * 线程对象myThread1执行stop方法，线程对象myThread1里面run里面的循环立即结束
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//使用stop()方法让线程抛出异常
	@Test
	public void stop2(){
		try {
			MyThread2 myThread2 = new MyThread2();
			myThread2.start();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//使用stop()方法测试释放锁的不良后果
	@Test
	public void stop3(){
		try {
			SynchronizedObject synchronizedObject = new SynchronizedObject();
			MyThread3 myThread3 = new MyThread3(synchronizedObject);
			myThread3.start();
			myThread3.stop();
			System.out.println(synchronizedObject.getUsername()+synchronizedObject.getPassword());
			Thread.sleep(1000);
			/*
			 * 在这时候就会出现数据的不同步，当stop方法执行的时候，
			 * 这时候在SynchronizedObject类中
			 * 		synchronized public void printString(已经加锁了，在这方法里面Thread.sleep(1000)睡了一秒钟)，
			 * 		当main线程执行到stop()方法的时候，myThread3线程还在加锁的方法里面，执行stop(),myThread3对象释放锁，导致数据出错
			 * 			this.username = username;(username赋值了)
			 *			Thread.sleep(1000);(这时候被执行stop方法，线程停止)
			 *			this.password = password;(password没有被赋值)
			 *	
			 *	注：由于stop()方法已经在JDK中被标明是"作废/过期"的方法，显然它在功能上具有缺陷，所以不建议在程序中所使用stop()方法
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//使用return和interrupt在停止线程
	@Test
	public void returnAndInterrupt(){
		try {
			MyThread4 myThread4 = new MyThread4();
			myThread4.start();
			Thread.sleep(10);
			myThread4.interrupt();
			/*
			 * 将方法interrupt()和return结合使用可以使线程停止
			 * 但是还是建议使用"抛异常"的方法来实现线程的停止
			 * 因为在catch块中还可以将抛异常向上抛，使线程停止的事件得以传播
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//暂停线程(suspend)与恢复线程(resume)
	@Test
	public void suspendAndResume(){
		try {
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			
			//A段，暂停线程，线程对象myThread5里面的run方法停止运行
			myThread5.suspend();
			System.out.println("系统时间" + System.currentTimeMillis() + "线程暂停时i=" + myThread5.getI());
			Thread.sleep(2000);
			System.out.println("系统时间" + System.currentTimeMillis() + "线程恢复后i=" + myThread5.getI());
			//恢复线程，线程对象myThread5里面的run方法又开始运行   
			myThread5.resume();
			
			//B段
			Thread.sleep(2000);
			myThread5.suspend();
			System.out.println("系统时间" + System.currentTimeMillis() + "线程暂停时i=" + myThread5.getI());
			Thread.sleep(2000);
			System.out.println("系统时间" + System.currentTimeMillis() + "线程恢复后i=" + myThread5.getI());
			myThread5.resume();
			
			//C段
			Thread.sleep(2000);
			System.out.println("系统时间" + System.currentTimeMillis() + "线程没有暂停时i=" + myThread5.getI());
			Thread.sleep(2000);
			System.out.println("系统时间" + System.currentTimeMillis() + "线程没有恢复时i=" + myThread5.getI());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//suspend与resume方法的缺点--独占  
	@Test
	public void suspendAndResume2(){
		try {
			final SynchronizedObject2 synchronizedObject2 = new SynchronizedObject2();
			Thread thread = new Thread(){
				@Override
				public void run() {
					synchronizedObject2.printString();
				}	
			};
			thread.setName("a");
			thread.start();
			Thread.sleep(1000);
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					System.out.println("能进去吗?");
					synchronizedObject2.printString();
				}
			};
			thread2.start();
			/*
			 * 	当thread这个线程进入SynchronizedObject2.printString()方法是(该方法已经上锁了)，
			 * 		thread在里面进行了暂停，该线程拿到了该方法的锁，一直暂停在里面(并不会释放锁)，别的线程是不可能再次拿到这把锁的，程序就出问题了
			 * 	这种情况就是独占
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//suspend与resume方法的缺点--独占
	@Test
	public void suspendAndResume3(){
		try {
			MyThread6 myThread6 = new MyThread6();
			myThread6.start();
			Thread.sleep(10);
			myThread6.suspend();//线程myThread6正在打印输出，调用暂停，println还在被该线程使用，因为println是加了锁的
			System.out.println("main end...");
			/*
			 * 	myThread6线程一直在打印i输出，突然就被suspend()，暂停了，就是说myThread6还在使用println方法(停在该方法里面)，
			 * 	但是println是加了锁的，所以myThread6线程就一直独占了，别的线程就没有取得这把锁，就没法用println方法
			 * 	所以main线程就没法打印main end输出
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//suspend与resume方法的缺点--数据不同步
	@Test
	public void dataNotSynchronization() throws InterruptedException{
		final MyObject myObject = new MyObject();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject.setUsernameAndPassword("mo", "123");
			}
		};
		thread.setName("a");
		thread.start();
		Thread.sleep(1000);
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject.print();
			}
		};
		thread2.start();
		Thread.sleep(1000);
		System.out.println("main end");
		/*
		 * 	这里就是thread启动向myObject对象注入数据，原来myObject默认的username和password是a和aa的
		 * 	现在注入的数据是mo和123，但是在thread线程注入完username就被暂停了，还没有注入password，所以这样就出现了数据的出错
		 * 
		 */
	}
	

	//yield()方法:放弃当前的cpu资源
	@Test
	public void yield() throws InterruptedException{
		MyThread8 myThread8 = new MyThread8();
		myThread8.start();
		Thread.sleep(100);
		/*
		 * 使用yield()方法的会比不使用的慢很多，因为使用yield()会自动放弃当前的cpu资源
		 * 	将它让给其他的任务去占用cpu执行时间
		 * 但放弃的时间不确定，有可能刚放弃，马上就获得cpu时间片了
		 */
	}

	
	//线程的优先级
	@Test
	public void threadPriority(){
		System.out.println("main线程的优先级是" + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		/*
		 * Thread.currentThread()中的currentThread()方法是静态的，就是不用通过具体的对象进行操作，
		 * 只能有唯一的值，就是说整个程序中currentThread().getPriority()的值是固定的
		 */
		System.out.println("main线程的优先级是" + Thread.currentThread().getPriority());
		MyThread9 myThread9 = new MyThread9();
		myThread9.start();
	}
	
}
