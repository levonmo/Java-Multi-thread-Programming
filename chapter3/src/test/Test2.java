package test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.print.DocFlavor.STRING;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import mythread1.MythreadA;
import mythread1.MythreadB;
import mythread1.MythreadC;
import object1.ObjectC;
import object1.ObjectE;
import object1.ObjectF;
import object1.ObjectG;
import object1.ObjectH;
import object1.ObjectI;
import object1.ObjectJ;
import object1.ObjectK;
import object1.ObjectL;
import object1.ObjectM;
import object1.ObjectO;

import org.junit.Test;

public class Test2 {

	//生产者/消费者模式实现
	@Test
	public void firstNotify() throws InterruptedException{
		String lock = new String();
		final ObjectC objectC = new ObjectC(lock);
		final ObjectE objectE = new ObjectE(lock);
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				while (true) {
					objectC.setValue();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				super.run();
				while (true) {
					objectE.getValue();
				}
			}
		}; 
		thread2.start();
		thread.start();
		Thread.sleep(200);
	}
	
	
	  
	/*
	 * 多生产者与多消费者:操作值-假死，假死的现象就是线程进入waiting等待状态。如果全部线程都进入了waiting状态，则程序就不再执行任何业务功能了。
	 * 	整个项目呈停止状态，这在是使用生产者与消费者模式时经常遇到的    
	 */
	@Test
	public void p_c_allWait() throws InterruptedException{
		String lock = new String();
		final ObjectF objectF = new ObjectF(lock);
		final ObjectG objectG = new ObjectG(lock);
 		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectF.setValue();
				}
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectG.geValue();
				}
			}
		};
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectF.setValue();
				}
			}
		};
		thread3.setName("C");
		Thread thread4 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectF.setValue();
				}
			}
		};
		thread4.setName("D");
		thread2.setName("B");
		
		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();
		Thread.sleep(500);
		/*
		 * 从打印的信息来看，呈假死状态的进程中所有的线程都呈waiting状态
		 * 	为什么会出现这种情况?当有多个生产者和消费者的时候，当生产者唤醒生产者，消费者唤醒消费者的话，就会出现这种情况了。
		 * 		最后大家都是呈现waiting状态
		 * 
		 * 	解决的办法就是:将生产者与消费者的notify()方法改为notifyAll()方法即可，
		 * 		它的原理就是不光通知同类线程，也包括异类。这样就不会出现假死的状态了
		 */
	}
	
	
	
	//一生产与一消费:操作栈:使生产者向堆栈List对象中放入数据，使消费者从List堆栈中取出数据。List的最大容量是1，实验环境只有一个生产者与一个消费者
	@Test
	public void myStack(){
		ObjectH objectH = new ObjectH();
		final ObjectI objectI = new ObjectI(objectH);
		final ObjectJ objectJ = new ObjectJ(objectH);
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectJ.pushService();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				super.run();
				while (true) {
					objectI.popService();
				}
			}
		};
		thread.start();
		thread2.start();
	}
	
	
	
	//通过管道进入线程间的通信:字节流:用于在不同线程之间传输数据，无需借助于类似临时文件之类的东西
	
	
	
	//方法join的使用:铺垫
	@Test
	public void joinTest1(){
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					// TODO Auto-generated method stub
					super.run();
					int vlaue = (int)(Math.random() * 10);
					System.out.println(vlaue);
					Thread.sleep(vlaue);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		//Thread.sleep(?);
		System.out.println("我想当thread执行完我再执行");
		System.out.println("当是上面的代码sleep()中的值应该写多少?");
		System.out.println("答案是:不确定");
	}
	
	
	//用join()方法解决问题
	@Test
	public void joinTest2() throws InterruptedException{
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					super.run();
					int waitTime = (int)(Math.random() * 10000);
					Thread.sleep(waitTime);
					System.out.println("thread睡眠结束");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread.join();
		System.out.println("主线程执执行完毕");
		/*
		 * 方法join的作用是使所属的线程Z(这里是main线程)对x线程对象正常执行run()方法中的任务，
		 * 而使当前线程Z进行无限期的阻塞作用，要等待线程x销毁后再执行线程z后面的代码
		 * 	
		 * 	方法join具有使线程排队运行的作用，有一些类似同步的运行的效果。join与synchronized的区别是:
		 * 		join在内部使用wait()方法进行等待的，而synchronized是使用"对象监视器"原理进行同步的
		 */
	}
	
	//方法join与异常
	@Test
	public void joinException() throws InterruptedException{
		final Thread threadA = new Thread(){
			@Override
			public void run() {
				super.run();
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					String newString = new String();
					Math.random();
					System.out.println(i);
				}
			}
		};
		
		final Thread threadB = new Thread(){
			@Override
			public void run() {
				try {
					super.run();
					threadA.start();
					threadA.join();
					System.out.println("线程B在run结束了");
				} catch (InterruptedException e) {
					System.out.println("线程B在catch打印了");
					e.printStackTrace();
				}
				
			}
		};
		
		
		threadB.start();
		Thread.sleep(100);
		threadB.interrupt();
		Thread.sleep(100);
		/*
		 * 这说明方法join与interrupt方法如果遇到，则会出现异常。
		 * 	但进程的按钮还是红色，原因是线程threadA还在运行中，线程threadA没有出现异常
		 */
	}
	
	
	
	//方法join(long)的使用
	@Test
	public void joinLong() throws InterruptedException{
		Thread threadA = new Thread(){
			@Override
			public void run() {
				try {
					super.run();
					System.out.println("线程A开始的系统时间是" + System.currentTimeMillis());
					Thread.sleep(4000);
					System.out.println("线程A结束的系统时间是" + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		threadA.start();
		threadA.join(2000);
		System.out.println("主线程执行完毕");
		/*
		 * 主线程等待了两秒
		 */
	}
	
	
	//join(long)与sleep(long)的区别
	@Test
	public void joinAndSleep() throws InterruptedException{
		MythreadB B = new MythreadB();
		MythreadA A = new MythreadA(B);
		MythreadC C = new MythreadC(B);
		A.start();
		Thread.sleep(100);
		C.start();
		Thread.sleep(8000);
		/*
		 * 线程A的run方法中启动了线程B.A已经获取了B对象锁
		 * 	在A的run方法里面需要等待6s,C启动，想要执行B中的同步方法，但是B的对象锁还在A中
		 * 		所以要等待A执行完毕，释放B的对象锁后，C才能执行B中的同步方法
		 * 
		 *		上面实验证明Thread.sleep(Long);方法不释放对象锁
		 *
		 *		把MythreadA中的Thread.sleep(6000); 改为   mythreadB.join();
		 *			时A就释放了对象锁，所以线程C可以执行线程B对象中的同步方法
		 *		说明join(long)有释放锁的功能
		 *			
		 */
	}
	
	
	//类ThreadLocal的使用
	@Test
	public void threadLocal(){
		ObjectK objectK = new ObjectK();
		objectK.test();
		/*
		 * 类ThreadLocal解决的是变量在不同线程间的隔离性，
		 * 	也就是不同线程拥有自己的值，不同线程中的值是可以放进ThreadLocal类中进行保存的
		 */
	}
	
	
	//验证线程变量的隔离性
	@Test
	public void threadLocalA() throws InterruptedException{
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					for (int i = 0; i < 100; i++) {
						ObjectL.t1.set("线程A	" + (i+1));
						 System.out.println("线程A的值" + ObjectL.t1.get());
						 Thread.sleep(100);
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
					for (int i = 0; i < 100; i++) {
						ObjectL.t1.set("线程A	" + (i+1));
						 System.out.println("线程B的值" + ObjectL.t1.get());
						 Thread.sleep(300);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread2.start();
		Thread.sleep(10000);
		/*
		 * 没有线程都向t1对象中set()数据值，但每个线程还是能取出自己的值
		 */
	}
	
	
	//还是上面的ThreadLocal类，实现第一次调用ThreadLocal类的get()方法返回值不是null
	@Test
	public void firstValue(){
		final ObjectM t1 = new ObjectM();
		System.out.println(t1.get());
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				System.out.println(t1.get());
			}
		};
		thread.start();
		
	}
	
	
	//InheritableThreadLocal的使用
	 @Test
	 public void InheritableThreadLocal() throws InterruptedException{
		 Thread thread = new Thread(){
			 @Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					super.run();
					for (int i = 0; i < 10; i++) {
						System.out.println("在ThreadA线程中取值" + ObjectO.t1.get());
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		 };
		 
		 for (int i = 0; i < 10; i++) {
			 System.out.println("Main线程中取值是" + ObjectO.t1.get());
			 Thread.sleep(100);
		 }
		 Thread.sleep(5000);
		 thread.start();
	 }
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
