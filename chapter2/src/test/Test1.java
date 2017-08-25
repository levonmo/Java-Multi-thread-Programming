package test;

import mythread1.MyThread1;
import mythread1.MyThread2;
import mythread1.MyThread4;
import mythread1.MyThread5;
import mythread1.MyThread6;
import mythread1.MyThread7;
import mythread1.MyThread8;
import mythread1.MyThread9;

import org.junit.Test;

import otherObject.HasPrivateNum;
import otherObject.HasSelfPrivateNum;
import otherObject.MyObject;
import otherObject.MyObject2;


public class Test1 {

	//方法内部声明一个变量，是不存在"非线程安全"问题的
	@Test
	public void hasSelfPrivateNum() throws InterruptedException{
		HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
		MyThread1 myThread1 = new MyThread1(hasSelfPrivateNum);
		myThread1.start();
		MyThread2 myThread2 = new MyThread2(hasSelfPrivateNum);
		myThread2.start();
		Thread.sleep(20);
	}
	
	
	//实例变量的非线程安全
	@Test
	public void hasSelfPrivateNum2(){
		try {
			HasPrivateNum hasPrivateNum = new HasPrivateNum();
			MyThread4 myThread1 = new MyThread4(hasPrivateNum);
			myThread1.start();
			MyThread5 myThread2 = new MyThread5(hasPrivateNum);
			myThread2.start();
			Thread.sleep(2000);
			/*
			 * 	在这里myThread1启动，注入了a，然后根据逻辑输出i=50就睡了，
			 * 		但这时候myThread2也启动了，注入了b，根据逻辑应该i=100，所以上面的i=50就被该为i=100了
			 * 		i被改为100了，myThread1睡醒后再次打印i的值就被改为100了
			 * 
			 * 	解决方法:在addUsername()方法前面加上关键字synchronized就可以了
			 * 
			 * 	实验结论:在两个线程访问同一个对象中的同步方法时一定是线程安全的。
			 */
		} catch (InterruptedException e) {
			//当被中断的时候抛出异常
			e.printStackTrace();
		}
	}
	
	
	//多个锁多个对象
	@Test
	public void manyLock(){
		try {
			//这里新建两个对象，就是互不相关了，一个对象有独自的一把锁
			HasPrivateNum hasPrivateNum1 = new HasPrivateNum();
			HasPrivateNum hasPrivateNum2 = new HasPrivateNum();
			MyThread4 myThread4 = new MyThread4(hasPrivateNum1);
			myThread4.start(); 
			MyThread5 myThread5 = new MyThread5(hasPrivateNum2);
			myThread5.start();
			Thread.sleep(2000);
			/*
			 * 输出的先后顺序是交叉的，当myThread4注入后打印了一个i，就进入了睡眠，
			 * 	但是这使线程myThread5注入的b也输出了一个i，但myThread4进入的方法不是已经加锁了吗?
			 * 	b还怎么进入，所以synchronized关键字锁的是对象，而不是一段代码
			 *		多个对象就会有多把锁
			 */
		} catch (InterruptedException e) {//睡眠被中断的话，就会抛出异常进入catch块
			e.printStackTrace();
		}
	}
	
	
	//synchronized方法与锁对象
	@Test
	public void methodAndLock(){
		try {
			MyObject myObject = new MyObject();
			MyThread6 myThread6 = new MyThread6(myObject);
			myThread6.setName("a");
			myThread6.start();
			MyThread7 myThread7 = new MyThread7(myObject);
			myThread7.setName("b");
			myThread7.start();
			Thread.sleep(2000);
			/*
			 * 调用关键字synchronized声明的方法一定是排队运行的
			 * 	记住"共享"两个字，只有共享资源的读写访问才需要同步化，如果不是共享资源，那么根本没有同步的必要
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//在一个类中一个是同步方法，一个不是同步方法
	@Test
	public void oneIsSynchronizedOtherIsNO(){
		try {
			MyObject2 myObject2 = new MyObject2();
			MyThread8 myThread8 = new MyThread8(myObject2);
			myThread8.setName("a");
			myThread8.start();
			MyThread9 myThread9 = new MyThread9(myObject2);
			myThread9.setName("b");
			myThread9.start();
			Thread.sleep(2000);
			/*
			 *	结论:同一个对象中，有同步方法和非同步方法，当一个线程拿到了这个对象的同步方法的锁时，其他线程也可以进入该对象的非同步方法
			 *		在设计程序的时候也要注意，有时候实例变量 同步方法 与 非同步方法 会容易出现脏读
			 *		
			 *		就是说:当对同一个对象进行操作时，有一个线程在对同步方法进行读写(这里是指对实例变量进行读写)
			 *				这时候又有另一个线程进行该对象的非同步方法(同样是对同一实例变量进行读写)，但这时同步方法还没有执行结束，
			 *				非同步方法就把该实例变量的值修改了，然后同步方法再读取该值的时候就不是原来想要读取的值了
			 * 
			 * 		解决方法:
			 * 			如果真的是要两个方法要对同一对象的同一实例变量就行操作的时候，两个方法都要加上synchronized
			 * 
			 * 		结论:
			 * 			1.A线程先持有object对象的Lock锁，B线程可以以异步的方式调用object对象中的synchronized类型的方法
			 * 			2.A线程先持有object对象的Lock，B线程如果想访问object对象中其他的synchronized类型的方法则需要等待，也就是同步。
			 * 				(通俗点说就是:一个线程拿到了一个对象的锁，则拿到了该对象所有synchronized类型方法的锁，
			 * 				其他线程不能访问任何该对象加synchronized的方法，
			 * 					也可以换一种说法，对于同一个对象，无论有多少synchronized类型的方法，但这个对象只有一把锁，一但某一线程拿到了
			 * 					则其他线程不可能再次拿到锁)
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
