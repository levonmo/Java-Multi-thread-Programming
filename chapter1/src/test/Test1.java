package test;

import mythread.MyThread1;
import mythread.MyThread2;
import mythread.MyThread3;
import mythread.MyThread4;
import mythread.MyThread5;
import mythread.MyThread6;
import mythread.MyThread8;
import mythread.MyThread9;

import org.junit.Test;

public class Test1 {
	//获取当前线程的名字
/*	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName());
	}
*/	
	//新建一个线程
	@Test
	public void createThread(){
		MyThread1 myThread1 = new MyThread1();
		myThread1.start();
		System.out.println("ending");
		//这个时候是先输出ending在输出线程run方法里面的内容，因为CUP是随机的时间来调用线程中的run方法
	}
	
	//演示线程的随机性
	@Test
	public void randomThread(){
		MyThread2 myThread2 = new MyThread2();
		myThread2.setName("mythread");
		myThread2.start();
		try {
			for(int i=0; i<10; i++){
				int time = (int)Math.random()*1000;
				Thread.sleep(time);
				System.out.println("main=" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 演示线程执行start()方法的顺序并不是线程启动的顺序
	 * 	线程的启动是由cpu决定的，CPU会随机分配的
	 */
	@Test
	public void randomThreadNomatterWhenStart(){
		MyThread3 t1 = new MyThread3(1);
		MyThread3 t2 = new MyThread3(2);
		MyThread3 t3 = new MyThread3(3);
		MyThread3 t4 = new MyThread3(4);
		MyThread3 t5 = new MyThread3(5);
		MyThread3 t6 = new MyThread3(6);
		MyThread3 t7 = new MyThread3(7);
		MyThread3 t8 = new MyThread3(8);
		MyThread3 t9 = new MyThread3(9);
		MyThread3 t10 = new MyThread3(10);
		MyThread3 t11 = new MyThread3(11);
		MyThread3 t12 = new MyThread3(12);
		MyThread3 t13 = new MyThread3(13);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
	}
	
	
	
	//线程安全，实例变量不共享，不共享数据
	@Test
	public void threadSafe(){
		MyThread4 a = new MyThread4("A");
		MyThread4 b = new MyThread4("B");
		MyThread4 c = new MyThread4("C");
		a.start();
		b.start();
		c.start();
		/**
		 * 这里一共创建了三个线程对象，每一个线程都有各自的count变量，
		 * 自己减少自己的count变量的值，这样的情况就是变量不共享，这样的线程是安全的，像那种多个线程访问同一个对象就会引发线程的安全问题
		 * 这里并没有存在多个线程访问同一个对象的同一实例变量
		 */
	}
		
		//线程安全问题:实例变量共享数据
		@Test
		public void threadShareData(){
			//这样就是同一个对象了，多个线程同时访问同一个线程对象
			MyThread5 myThread5 = new MyThread5();
			Thread a = new Thread(myThread5,"A");
			Thread b = new Thread(myThread5,"B");
			Thread c = new Thread(myThread5,"C");
			Thread d = new Thread(myThread5,"D");
			a.start();
			b.start();
			c.start();
			d.start();
			/*	在这里四个线程打印的不是预期的结果(预期的结果应该是逐渐减一的)
			 * 		因为在某些JVM中，count--操作(并不是原子性)，而是分为3步：1.取得原有的值2.计算count-1 3.对i值进行赋值
			 *	因为cpu的执行速度过快，所以在线程执行的时候，第一个取得count值得线程还没有对count进行减操作，第二个线程就取得了count的值，
			 *	第三个线程取得count的值时，线程一和线程二 还没有对count进行减一操作
			 *	所以会引发"非线程安全":主要是指多个线程对同一对象中的同一实例变量进行操作时会出现值被更改
			 *									值不同步的情况，进而影响程序的执行流程(如果是方法里面的私有变量就不会出现线程安全问题)。
			 *	
			 */
			
		}
		
		
		//解决非线程安全
		@Test
		public void threahSafe(){
			MyThread6 myThread6 = new MyThread6();
			Thread a = new Thread(myThread6,"A");
			Thread b = new Thread(myThread6,"B");
			Thread c = new Thread(myThread6,"C");
			Thread d = new Thread(myThread6,"D");
			a.start();
			b.start();
			c.start();
			d.start();
		}
		
		//留意i--与System.out.println的异常，引发的线程安全问题
		@Test
		public void otherException(){
			MyThread8 myThread8 = new MyThread8();
			Thread a = new Thread(myThread8,"A");
			Thread b = new Thread(myThread8,"B");
			Thread c = new Thread(myThread8,"C");
			Thread d = new Thread(myThread8,"D");
			Thread e = new Thread(myThread8,"E");
			a.start();
			b.start();
			c.start();
			d.start();
			e.start();
			/*
			 * 	虽然println()方法在内部是同步的，就是在println()方法的内部加了synchronized关键字
			 * 	但i--的操作却是在进入println之前发生的，所以还是要在run()方法中加上synchronized
			 * 	就是不能以为i--操作在println里面就是具有同步性了
			 * 
			 */
		}
		
		
		//currentThread()方法,返回代码段正在被那个线程调用
		@Test
		public void main(){
			System.out.println(Thread.currentThread().getName());
			/*
			 * 这个main方法正在被一个线程名为main的线程调用
			 */
		}
		
		
		//调用start()与直接调用run方法的区别(1)
		@Test
		public void main1(){
			MyThread9 myThread9 = new MyThread9();
			myThread9.start();
			/*
			 * MyThread9类中的构造函数是被main方法调用的，而run()方法是主动调用的，不是由调用main方法的线程进行调用，而是由cpu进行分配去调用的
			 * 
			 */
		}
		
		
		//调用start()与直接调用run方法的区别(2)
		@Test
		public void main2(){
			MyThread9 myThread9 = new MyThread9();
			myThread9.run();	
			/*
			 * 如果是这样直接调用run方法的话，是由main函数直接调用的(并没有开启一个新的线程)
			 * 而不是由cpu进行随机分配的
			 * 这样就没有用到多线程，程序从开始到结束都是在一个线程上执行的
			 * 
			 */
		}
	
	
}
