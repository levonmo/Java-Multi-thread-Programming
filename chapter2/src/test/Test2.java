package test;

import mythread2.MyThread2;
import mythread2.MyThread3;
import mythread2.MyThread4;
import mythread2.MyThread5;
import mythread2.MyThread7;
import mythread2.MyThread8;
import mythread3.MyThread1;

import org.junit.Test;

import otherObject.MyObject6;
import otherObject.MyObject8;
import otherObject.MyObject9;
import otherObject.PublicVar;
import otherObject2.MyObject1;

public class Test2 {

	//脏读
	@Test
	public void dataChange(){
		try {
			PublicVar publicVar = new PublicVar();
			MyThread2 myThread2 = new MyThread2(publicVar);
			myThread2.setName("第一个设值线程");
			MyThread3 myThread3 = new MyThread3(publicVar);
			myThread3.setName("第二个取值线程");
			myThread2.start();
			myThread3.start();
			Thread.sleep(1000);
			/*
			 * 像这种情况就是脏读，需要在赋值时使用了同步(synchronized),但在取值时有可能出现一些意想不到的意外，
			 * 	这就是脏读:在读取实例变量时，此值已经被其他线程更改过了，或者是在赋值的时候还没有完全赋值(还有些值没有赋完)
			 * 	别的线程就进行读取了
			 * 
			 *  解决的方法就是在取值的方法中加上synchronize就行
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//synchronized锁重入
	@Test
	public void synchronizedEntry(){
		try {
			MyThread4 myThread4 = new MyThread4();
			myThread4.start();
			Thread.sleep(4000);
			/*
			 * 	可重入锁:自己可以再次获取自己的内部锁。
 			 * 		比如有一个线程对象获得了某个对象的锁，此时这个对象锁还没有释放，当想再次获取这个对象的锁时还是可以获取的，如果没有不可重入锁的话，就会造成死锁。
			 * 			比如一个对象有一个同步方法，该A同步方法里面还有一个B同步方法，
			 * 				这时候想执行里面的B同步方法时，就不需要等待A方法执行完毕。B同步方法可以直接执行
			 */
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
	}

	//可重入锁的父子类继承
	@Test
	public void synchronizedFatherAndSon(){
		try {
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			Thread.sleep(2000);
			/*
			 * 结论：当存在父子类继承关系是，子类是完全可以通过"可重入锁"调用父类的同步方法
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//出现异常，锁自动释放
	@Test
	public void exceptionNoSynchronized(){
		final MyObject6 myObject6 = new MyObject6();
		Thread a = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject6.method1();
			}
		};
		a.setName("a");
		Thread b = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject6.method1();
			}
		};
		b.setName("b");
		a.start();
		b.start();
		/*
		 * 	结论:线程a出现异常并释放锁，线程b进入方法正常打印，实验的结论就是出现异常的锁被自动释放了
		 *
		 */
	}
	
	
	//同步不具有继承性
	@Test
	public void synchronizedNoExtends(){
		try {
			final MyObject8 myObject8 = new MyObject8();
			Thread thread = new Thread(){
				@Override
				public void run() {
					super.run();
					myObject8.method();
				}
			};
			thread.setName("a");
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					super.run();
					myObject8.method();
				}
			};
			thread2.setName("b");
			thread.start();
			thread2.start();
			Thread.sleep(10000);
			/*
			 * 结论:当父类中有一个同步方法是，子类是不能继承父类的同步方法，
			 * 		所以还得在子类的方法中添加synchronized关键字
			 * 
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//使用同步代码块
	@Test
	public void synchronizedThis(){
		try {
			MyObject9 myObject9 = new MyObject9();
			MyThread7 myThread7 = new MyThread7(myObject9);
			myThread7.setName("a");
			MyThread8 myThread8 = new MyThread8(myObject9);
			myThread8.setName("b");
			myThread7.start();
			myThread8.start();
			Thread.sleep(6000);
			/*
			 * 当两个并发线程访问同一个对象object中的synchronized(this)同步代码块是，一段时间内只能有一个线程被执行
			 * 	另一个线程必须等待当前线程执行完这个代码块才能执行该代码块
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
 