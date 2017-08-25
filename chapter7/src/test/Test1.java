package test;

import object.ObjectA;
import object.ObjectB;
import object.ObjectC;
import object.ObjectD;

import org.junit.Test;

public class Test1 {
	
	
	/*
	 * -
	 * 线程的状态:
	 * 	线程对象在不同的运行时期有不同的状态，状态信息就存在于State枚举类中
	 * 		Thread.State  有几个值:NEW,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING,TERMINATED
	 * 
	 */
	
	
	
	//线程的状态:验证:new，runnable，terminated(结束)
	@Test
	public void state() throws InterruptedException{
		ObjectA t1 = new ObjectA();
		System.out.println("main方法中的状态1" + t1.getState());//这里new了一个线程但是还没有启动，线程的状态就是new
		Thread.sleep(500);
		t1.start();
		Thread.sleep(500);
		System.out.println("main方法中的状态2" + t1.getState());//线程已经是运行结束了，所以该线程的状态是terminated
	}
	
	
	//验证timed_waiting:线程的状态timed_waiting表示线程执行了Thread.sleep()方法，呈等待状态，等待时间到了，继续向下运行
	@Test
	public void timed_waiting() throws InterruptedException{
		Thread thread = new Thread(){
			public void run() {
				try {
					System.out.println("开始睡眠");
					Thread.sleep(5000);
					System.out.println("结束睡眠");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		Thread.sleep(1000);
		System.out.println("main方法总的状态是" + thread.getState());
	}
	
	
	//验证blocked:出现在某一个线程在等待锁的时候
	@Test
	public void blocked() throws InterruptedException{
		final ObjectB objectB = new ObjectB();
		Thread thread1 = new Thread(){
			public void run() {
				objectB.methodA();
			}
		};
		thread1.start();
		Thread.sleep(50);
		Thread thread2 = new Thread(){
			public void run() {
				objectB.methodA();
			}
		};
		thread2.start();
		Thread.sleep(50);
		System.out.println("main方法中thread2的状态" + thread2.getState());
		/*
		 * 线程thread1已经进入了同步方法了，线程thread2等待进入同步方法，这时候线程的状态就是BLOCKED
		 */
	}
	
	
	
	//验证WAITING:是线程执行wait()方法后所处的状态
	@Test
	public void WAITING() throws InterruptedException{
		Thread thread = new Thread(){
			public void run() {
				synchronized ("锁") {
					try {
						"锁".wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		Thread.sleep(50);
		System.out.println("main方法中的线程thread的状态是" + thread.getState());
	}
	
	
	
	
	/*
	 * 线程组:可以把线程归属到某一个线程组中，线程组中可以有线程对象，也可以有线程组，组中还可以有线程
	 * 		作用：可以批量管理线程或线程组对象，有效地对线程或线程组对象进入组织
	 */
	 
	//线程对象关联线程组:1级关联
	@Test
	public void threadArray() throws InterruptedException{
		ObjectC objectC = new ObjectC();
		ObjectD objectD = new ObjectD();
		ThreadGroup threadGroup = new ThreadGroup("莫文龙的线程组");
		Thread thread = new Thread(threadGroup,objectC);
		Thread thread2 = new Thread(threadGroup,objectD);
		thread.start();
		thread2.start();
		Thread.sleep(3000);
		System.out.println("活动的线程数是" + threadGroup.activeCount());
		System.out.println("线程组的名称是" + threadGroup.getName());
		Thread.sleep(5000);
		/*
		 * 控制台打印的信息表示线程组中有里两个线程，并且打印出了线程组的名称
		 */
	}
	
	
	
	//线程组自动归属特性:自动归属就是自动归到当前的线程组中

	
	/*
	 * SimpleDateFormat线程安全
	 * 	主要是负责日期的转化与格式化，但在多线程的环境中，使用此类容易造成数据转换及处理的不准确
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
 