package test;

import object1.ObjectA;
import object1.ObjectB;

import org.junit.Test;

public class Test1 {

	//wait/notify的引入:不使用等待/通知机制实现线程间的通信，在这里也添加了volatile关键字
	@Test
	public void twoThreadTransData() throws InterruptedException{
		final ObjectA list = new ObjectA();
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						list.add();
						System.out.println("添加了" + ( i + 1 ) + "个元素");
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				try {
					while (true) {
						if (list.size() == 5) {
							System.out.println("集合的元素为5，线程要退出");
							throw new InterruptedException();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread2.start();
		Thread.sleep(9000);
		/*
		 * 
		 * 虽然两个线程实现了通信，但是有一个弊端就是，线程thread2语句轮询机制来检测某一个条件，这样会很浪费cpu的资源
		 * 	如果轮询的时间间隔很小，有可能取不到想要的数据。
		 * 		所以就需要有一种机制实现减少cpu的资源浪费
		 * 			而且还可以实现线程间的通信
		 * 
		 */
	}
	
	
	
	//等待/通知机制的实现:wait使线程停止运行，而Notify可以使停止的线程继续运行
	@Test
	public void waitAndNotify(){
		try {
			String string = new String("");
			string.wait();
			/*
			 *	出现对象的原因是没有"对象监视器"，也就是该方法没有同步加锁 
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//使用wait
	@Test
	public void useWait(){
		try {
			String lock = new String();
			System.out.println("syn上面");
			synchronized (lock) {
				System.out.println("syn第一行");
				lock.wait();
				System.out.println("wait下面的代码");
				/*
				 * 线程在执行lock.wait();就停止了没有执行下面的代码了，但是线程并没有停止
				 */
			}
			System.out.println("syn下面");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	//使用notify
	@Test
	public void notifyTest() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				System.out.println("线程A的syn上面的代码");
				synchronized (lock) {
					try {
						System.out.println("wait上一行代码");
						lock.wait();
						System.out.println("wait下一行代码");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				System.out.println("线程B的syn上面的代码");
				synchronized (lock) {
						System.out.println("notify上一行代码");
						lock.notify();
						System.out.println("notify下一行代码");
				}
			}
		};
		thread.start();
		Thread.sleep(500);
		thread2.start();
		/*
		 * 	thread首先被执行，进入等待状态，释放对象锁
		 * 		thread2后来进入获得lock对象锁，唤醒在沉睡的thread，但没有立刻释放锁，而是thread2运行结束后，
		 * 			释放对象锁，thread获取对象锁，继续运行以下的代码
		 */
	}
	
	
	//使用wait和notify实现前面的  集合元素等于5的时候一个线程退出
	@Test
	public void test() throws InterruptedException{
		final ObjectB list = new ObjectB();
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				synchronized (lock) {
					try {
						if (list.getSize() != 5) {
							System.out.println("wait上一行代码");
							lock.wait();
							System.out.println("wait下一行代码");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				synchronized (lock) {
					try {
						for (int i = 0; i < 10; i++) {
							list.add();
							if(list.getSize() == 5){
								lock.notify();
								System.out.println("已发出通知");
							}
							System.out.println("已添加了" + (i+1) + "个元素");
							Thread.sleep(50);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		Thread.sleep(500);
		thread2.start();
		Thread.sleep(3000);
		/*
		 * 	lock.wait()的下一行最后才输出，这就是说明了，执行了notify()方法的对象，并不会直接释放锁，而是等待该同步方法执行完
		 * 		才会释放锁，才会继续执行wait以下的代码
		 * 
		 * 	notify()方法可以随机唤醒等待队列中等待同一共享资源的"一个"线程，并使线程退出等待队列，进入可运行状态，
		 * 		也就是notify()方法仅通知"一个"线程
		 * 
		 */
	}
	
	
	
	//方法wait()锁释放与notify()锁不释放
	@Test
	public void waitReleaseLock(){
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("线程一wait上面的代码");
						lock.wait();
						System.out.println("线程一wait下面的代码");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("线程二wait上面的代码");
						lock.wait();
						System.out.println("线程二wait下面的代码");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread2.start();
		/*
		 * 	输出有两行代码，都是wait上面的代码，也就是说，线程一执行了wait之前的代码后，执行wait就进入了wait状态，释放了对象锁
		 * 		之后线程二获取了对象锁，同样也是执行wait上面的代码
		 */
	}
	
	
	
	//方法wait()锁释放与notify()锁不释放
	@Test
	public void notifyHoldLock() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("wait上面的代码");
						lock.wait();
						System.out.println("wait后面的代码");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				synchronized (lock) {
					System.out.println("notify上面的代码");
					lock.notify();
					System.out.println("notif后面的代码");
				}
			}
		};
		thread.start();
		thread2.start();
		/*
		 * thread线程执行了wait()，lock的对象锁释放，thread2线程获得了lock的对象锁，执行了notify()(thread被唤醒)，
		 * 		但thread2不会立刻释放对象锁，等待线程thread2执行完代码后，释放对象锁，thread重新获得对象锁
		 * 
		 * 	实验说明:必须执行完notify()方法所在的同步synchronized代码块后才释放锁
		 */
	}
	
	
	//当interrupt方法遇到wait方法
	@Test
	public void waitInterruptException() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					synchronized (lock) {
						System.out.println("wait前面的代码");
						lock.wait();
						System.out.println("wait后面的代码");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("出现异常了，因为呈wait状态的线程被中断了");
				}
			}
		};
		thread.start();
		Thread.sleep(50);
		thread.interrupt();
		/*
		 * 当线程呈wait()状态时，调用线程对象的interrupt()方法会出现java.lang.InterruptedException异常
		 */
	}
	
	
	//只通知一个线程
	@Test
	public void notifyOneThread() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("线程1前");
						lock.wait();
						System.out.println("线程1后");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("线程2前");
						lock.wait();
						System.out.println("线程2后");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("线程3前");
						lock.wait();
						System.out.println("线程3后");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread4 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				synchronized (lock) {
					System.out.println("notify前");
					lock.notify();
//					lock.notify();
//					lock.notify();
//					lock.notifyAll();//唤醒所有wait中的线程
					System.out.println("notify后");
				}
			}
		};
		thread.start();
		thread2.start();
		thread3.start();
		Thread.sleep(500);
		thread4.start();
		/*
		 * 方法notify()仅随机唤醒一个线程
		 * 	当调用notify()方法n次时，会唤醒n的wait中的线程个数
		 */
	}
	
	
	
	//方法wait(long)的使用:等待某一时间内是否有线程对其唤醒，如果超过这个时间则会自动唤醒
	@Test
	public void waitHasParam() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("wait前");
						lock.wait(2000);
						System.out.println("wait后");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
//		Thread.sleep(2500);
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				synchronized (lock) {
					System.out.println("notify前");
					lock.notify();
					System.out.println("notify后");
				}
			}
		};
		thread2.start();
		Thread.sleep(1000);
	}
}
