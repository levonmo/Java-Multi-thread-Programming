package test;

import java.util.concurrent.locks.ReentrantLock;

import object1.ObjectA;
import object1.ObjectB;
import object1.ObjectC;
import object1.ObjectD;
import object1.ObjectE;
import object1.ObjectF;
import object1.ObjectG;
import object1.ObjectH;
import object1.ObjectI;
import object1.ObjectJ;
import object1.ObjectK;
import object1.ObjectL;

import org.junit.Test;

//Lock的使用
public class Test1 {

	//使用ReentrantLock实现同步:测试一
	@Test
	public void reentrantLockTest(){
		final ObjectA objectA = new ObjectA();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectA.methodA();
			}
		};
		thread.setName("A");
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectA.methodA();
			}
		};
		thread2.setName("B");
		
		
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectA.methodA();
			}
		};
		thread3.setName("C");
		
		thread.start();
		thread2.start();
		thread3.start();
		/*
		 * 从运行的结果来看，当前线程打印完毕之后将锁进行释放，其他线程才可以继续打印。
		 * 	线程打印的数据是分组打印的，因为当前线程已经持有锁了，但线程之间的打印顺序是随机的
		 * 
		 */
	}
	
	
	
	//使用ReentrantLock实现同步:测试二
	@Test
	public void reentrantLockTest2() throws InterruptedException{
		final ObjectB objectB = new ObjectB();
		final ObjectC objectC = new ObjectC();
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				objectB.methodA();
			}
		};
		thread.setName("A");
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				objectB.methodA();
			}
		};
		thread2.setName("B");
		
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				objectB.methodB();
			}
		};
		thread3.setName("C");
		
		Thread thread4 = new Thread(){
			@Override
			public void run() {
				objectB.methodB();
			}
		};
		thread4.setName("D");

		thread.start();
		thread2.start();
		Thread.sleep(1000);
		thread3.start();
		thread4.start();
		
		Thread.sleep(10000);
	}
	
	
	//使用Condition实现等待/通知:错误用法与解决，是jdk5中出现的技术
	@Test
	public void useConditionWaitNotifyError(){
		final ObjectC objectC = new ObjectC();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectC.await();
			}
		};
		thread.start();
		/*
		 * 
		 * 使用condition.await()方法调用之前必须要调用lock.lock()代码获取同步监视器，否则就会抛出异常
		 * 		调用condition.await()方法使当前执行任务idea线程进入了waiting状态
		 * 
		 */
	}
	
	
	//正确使用Condition实现等待/通知
	@Test
	public void useConditionWaitNotifyOk() throws InterruptedException{
		final ObjectD objectD = new ObjectD();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectD.await();
			}
		};
		thread.start();
		Thread.sleep(3000);
		objectD.signal();
		/*
		 * 成功实现等待和通知的机制
		 * 	Object类中的wait()方法相当于Condition类中的await()方法
		 * 	Object类中的wait(long timeout)方法相当于Condition类中的await(long time,TimeUnit unit)方法
		 * 	Object类中的notify()方法相当于Condition类中的signal()方法
		 * 	Object类中的notifyAll()方法相当于Condition类中的signal()方法
		 * 
		 * 	调用signal()方法之前也是要进行同步的
		 */
	}
	
	
	
	//使用多个Condition实现通知部分线程:错误的用法
	@Test
	public void mustUseMoreCondition_error() throws InterruptedException{
		final ObjectE objectE = new ObjectE();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectE.awaitA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectE.awaitB();
			}
		};
		thread2.setName("B");
		
		thread.start();
		thread2.start();
		
		Thread.sleep(3000);
		
		objectE.signalAll();
		/*
		 * 程序运行后，线程A和线程B都被唤醒了
		 * 	如果想要单独唤醒部分线程该怎么处理，这时就有必要使用多个Condition对象了，
		 * 		也就是Conditionn对象可以唤醒部分指定线程，有助于提升程序的运行效率。
		 * 
		 */
	}
	
	
	
	//使用多个Condition实现通知部分线程:正确的用法
	@Test
	public void mustUseMoreCondition_OK() throws InterruptedException{
		final ObjectF objectF = new ObjectF();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectF.awaitA();
			}
		};
		thread.setName("A");
	
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectF.awaitB();
			}
		};
		thread2.setName("B");
		
		thread.start();
		thread2.start();
		
		Thread.sleep(3000);
		
		objectF.signalAll_A();
		/*
		 * 	程序运行后，只有线程A被唤醒了
		 * 		通过这个实验可以得知，使用ReentrantLock对象可以唤醒指定种类的线程，这是控制部分线程行为的方便方式
		 */
	}
	
	
	
	//实现生产者/消费者模式:一对一交替打印
	@Test
	public void conditionTest(){
		final ObjectG objectG = new ObjectG();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		};
	}
	
	
	
	//实现生产者/消费者模式:多对多交替打印
	@Test
	public void conditionTestManyToMany() throws InterruptedException{
		final ObjectH objectH = new ObjectH();
		Thread[] threadA = new Thread[1000];
		Thread[] threadB = new Thread[1000];
		for (int i = 0; i < 1000; i++) {
			threadA[i] = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectH.set();
				}
			};
			threadB[i] = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectH.get();
				}
			};
			threadA[i].start();
			threadB[i].start();
		}
		Thread.sleep(2000);
		/*
		 * 看不懂
		 * 
		 */
	}
	
	
	//公平锁与非公平锁
	@Test
	public void fair_noFair(){
		final ObjectI objectI = new ObjectI(true);//把这里设置为false就是非公平锁
		Runnable runnable = new Runnable(){
			@Override
			public void run() {
				System.out.println("线程运行了" + Thread.currentThread().getName());
				objectI.methodA();
			}
		};
		
		Thread[] thread = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
		/*
		 *	公平锁与非公平锁:锁Lock分为"公平锁"和"非公平锁"，公平锁表示获取锁的顺序是按照线程加载的顺序来分配的
		 *		即先来先得。
		 *	而非公平锁就是随机的 	lock = new ReentrantLock(true/false);/true就是公平锁，false就是非公平锁
		 * 
		 */
	}
	
	
	
	//方法int getHoldCount():保持查询当前线程保持此锁定的个数，也就是调用lock()方法的次数
	@Test
	public void getHoldCount(){
		ObjectJ objectJ = new ObjectJ();
		objectJ.methodA();
	}
	
	
	//方法int getQueueLength():返回正等待获取此锁的线程估计数
	@Test
	public void getQueueLength() throws InterruptedException{
		final ObjectK objectK = new ObjectK();
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectK.methodA();
				}
			};
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}
		Thread.sleep(500);
		System.out.println("当前想要获取锁的线程个数有" + objectK.lock.getQueueLength());
		
	}
	
	
	//方法int getWaitQueueLength(Condition condition) 的作用是返回等待与此锁定给定条件的Condition的线程的估计数
	@Test
	public void getWaitQueueLength() throws InterruptedException{
		final ObjectL objectL = new ObjectL();
		Runnable runnable = new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objectL.await();
			}
		};
		Thread[] thread = new Thread[10];
		
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(runnable);
		}
		
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
		
		Thread.sleep(1000);
		objectL.notityMethod();
		
	}
	
		
	
	
	
	
}
 