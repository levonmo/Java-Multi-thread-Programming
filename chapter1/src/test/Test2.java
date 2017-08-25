package test;

import mythread2.MyThread1;
import mythread2.MyThread2;
import mythread2.MyThread3;
import mythread2.MyThread4;
import mythread2.MyThread5;
import mythread2.MyThread6;
import mythread2.MyThread7;
import mythread2.MyThread8;
import mythread2.MyThread9;

import org.junit.Test;

public class Test2 {

	
	/*
	 * 判断当前的线程是否处于活动的状态
	 * 		isAlive()方法可以判断当前线程是否已经启动没有
	 */
	@Test
	public void isAlive() throws InterruptedException{
		MyThread1 myThread1 = new MyThread1();
		System.out.println("线程还没有启动" + myThread1.isAlive());
		myThread1.start();
//		Thread.sleep(1000);
		System.out.println("线程已经启动了" + myThread1.isAlive());
		/*
		 * 如果在线程执行时，给当前主线程睡眠一会，那么myThread1就已经把run方法的代码执行完毕了，
		 * 		run方法执行完毕，线程死亡为false(假如加上注释代码的话)
		 */
	}
	
	//如果将线程对象以构造参数的方式传递给Thread对象，进行strat()前后进行测试
	@Test
	public void threadAndThis(){
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		System.out.println("thread线程是否活跃" + thread.isAlive());
		//这时候新建的线程还没有调用start方法
		thread.setName("a");
		thread.start();
		System.out.println("thread线程是否活跃" + thread.isAlive());
	}
	
	
	//sleep()方法(1)
	@Test
	public void sleep(){
		MyThread3 myThread3 = new MyThread3();
		System.out.println("begin" + System.currentTimeMillis());
		myThread3.run();
		System.out.println("end" + System.currentTimeMillis());
		/*
		 * 直接调用run方法的话，里面都是使用main线程的，没有使用到多线程(还是main线程执行) 
		 * 		是同步执行的，代码是一行一行的执行，直接调用run方法，main线程会进入run方法里面，执行完里面的代码再跳出来，在执行以下的代码
		 * 			只有等待run方法里面的内容调用完毕才可以继续调用下面代码
		 */
	}
	
	
	//sleep()方法(1)
	@Test
	public void sleep2(){
		MyThread4 myThread4 = new MyThread4();
		System.out.println("begin" + System.currentTimeMillis());
		myThread4.start();
		System.out.println("end" + System.currentTimeMillis());
		/*
		 * 这就跟上面完全不一样了，是异步执行的，main方法执行之间的代码，新开启的线程也是执行自己的代码，这就是开启一个新的线程了
		 */
	}
	
	
	//getId()方法
	@Test
	public void getId(){
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + "  " + currentThread.getId());
	}
	
	
	//使用interrupt()方法并不能使线程停止
	public static void main(String[] args) {
		try {
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			Thread.sleep(2000);
			myThread5.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
	
	
	//interrupted()方法
	@Test
	public void interrupted(){
		try {
			MyThread6 myThread6 = new MyThread6();
			myThread6.start();
			Thread.sleep(10);
			/*	interrupt()这个方法是用来停止线程的，但interrupt()的效果并不像for+break语句那样
			 * 	马上就能停止，调用interrupt()方法只是当前线程中打了一个停止的标记，并不是真的停止线程
			 */
			myThread6.interrupt();
			System.out.println("是否停止1" + myThread6.interrupted());
			System.out.println("是否停止2" + myThread6.interrupted());
			/*
			 * 这控制台上面看，线程并没有停止，因为这个interrupted()方法是测试当前线程是否停止（是指运执行这段代码的线程，这里是main线程执行这段代码）
			 * 	运行这段代码是main线程，这个线程始终都没有停止过，所以打印两个false
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//interrupted()方法(2)
	@Test
	public void interrupted2(){
		//interrupt()这个方法是停止线程，但不是真的是停止该线程，而是在当前的线程中打了一个停止的标记
		Thread.currentThread().interrupt();//执行完这段代码，当前线程就打了一个停止标记
		System.out.println("是否已经停止1" + Thread.interrupted());
		System.out.println("是否已经停止2" + Thread.interrupted());
		/*	是否已经停止1true
		 * 	是否已经停止2false
		 * 
		 * 	出现这种情况是因为，在第一行代码中，当前的线程是已经标记停止了的，  
		 * 	第二次为false的原因是:interrupted()方法具有清楚状态的功能(就是把标记停止的状态清除)
		 * 		所以第二次调用interrupted()的返回值是false(就是没有被标记停止)
		 */
	}
	
	//isInterrupted()方法
	@Test
	public void isInterrupted(){
		try {
			MyThread6 myThread6 = new MyThread6();
			myThread6.start();
			
			/*	这里为什么要睡一会，我的理解是因为主线程(就是main线程)可能已经执行完毕了
			 * 	虽然新建的线程对象还没执行完毕，但是main线程已经执行完毕了,程序已经关闭(可能是因为单元测试就将程序停止)
			 * 	所以让主线程睡一会，有充分的时间让新建的线程对象去执行他们的线程
			 */
			
			Thread.sleep(20);
			myThread6.interrupt();//线程中断
			System.out.println("线程是否中断1" + myThread6.isInterrupted());
			System.out.println("线程是否中断2" + myThread6.isInterrupted());
			/*	这两个方法的解析：
			 * 		1.this.interrupted():测试当前线程是否已经是中断状态，执行后具有将状态标志置清除为false的功能
			 * 		2.this.isInterrupted():测试线程Thread对象是否已经是中断状态，但不清除状态标志
			 * 
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//能停止的线程:异常法
	@Test
	public void exceptionInterrupted(){
		try {
			MyThread7 myThread7 = new MyThread7();
			myThread7.start();
			Thread.sleep(2000);
			myThread7.interrupt();
			/*
			 * interrupt()该方法可以对该线程进行标记，标记着中断状态，你可以利用该中断状态去处理线程。该方法不会直接令该线程中断
			 * 		但是可以利用这个标记，进行判断，然后决定如何停止线程
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//在沉睡中停止
	@Test
	public void sleepInterrupted(){
		try {
			MyThread8 myThread8 = new MyThread8();
			myThread8.start();
			Thread.sleep(200);
			myThread8.interrupt();//这里进行标记停止，但是这个要标记的这个线程还在沉睡中，进行标记就会抛出异常
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main方法结束");
		/*
		 * 如果在sleep状态下停止某一线程会抛出异常，并清除停止状态值，变成false
		 */
	}
	
	//线程停止(执行了interrupt方法),在执行sleep方法
	@Test
	public void beginInterrupteAfterSleep() throws InterruptedException{
		MyThread9 myThread9 = new MyThread9();
		myThread9.start();
		myThread9.interrupt();
		System.out.println("main方法结束");
		/*
		 * 线程中断后再睡的话，会抛出异常
		 */
	}
	
	
}
