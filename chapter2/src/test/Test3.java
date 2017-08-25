package test;

import org.junit.Test;
import mythread3.MyThread1;
import mythread3.MyThread2;
import mythread3.MyThread3;
import mythread3.MyThread4;
import otherObject2.MyObject1;
import otherObject2.MyObject2;
import otherObject2.MyObject3;
import otherObject2.MyObject4;
import otherObject2.MyObject5;
import otherObject2.MyObject6;
import otherObject2.MyObject7;
import otherObject2.MyObject8;
import otherObject2.MyObject9;
import otherObject2.ObjectA;
import otherObject2.ObjectB;
import otherObject2.ObjectC;
import otherObject2.ObjectD;
import otherObject2.ObjectE;
import otherObject2.ObjectF;
import otherObject2.ObjectG;
import otherObject2.ObjectH;
import otherObject2.ObjectI;
import otherObject2.ObjectJ;
import otherObject2.ObjectK;
import otherObject2.ObjectL;
import otherObject2.ObjectM;
import otherObject2.ObjectN;
import otherObject2.ObjectO;
import otherObject2.ObjectP;
import otherObject2.ObjectQ;
import otherObject2.ObjectR;
import otherObject2.ObjectR.PrivateClass;
import otherObject2.ObjectS;

public class Test3 {

	//使用同步方法的弊端
	@Test
	public void synchronizedNoGood() throws InterruptedException{
		MyObject1 myObject1 = new MyObject1();
		MyThread1 myThread1 = new MyThread1(myObject1);
		myThread1.setName("a");
		MyThread2 myThread2 = new MyThread2(myObject1);
		myThread2.setName("b");
		myThread1.start();
		myThread2.start();
		Thread.sleep(6000);
	}
	
	
	//同步代码块，一半同步一半异步
	@Test
	public void synchronizedAndNoSynchronized() throws InterruptedException{
		final MyObject2 myObject2 = new MyObject2();
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject2.method();
			}
		};
		thread1.setName("a");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				myObject2.method();
			}
		};
		thread2.setName("b");
		thread1.start();
		thread2.start();
		Thread.sleep(1000);
		/*
		 * 	两个线程访问同一对象，可以是一半同步，一半异步，
		 * 		其中同步还可以和异步交叉，但是同步本身不能交叉，当一个线程进入同步代码块就不能有其他线程再进入该代码块 
		 */
	}
	
	
	//synchronized代码块间的同步性
	@Test
	public void synchronizedBlock() throws InterruptedException{
		final MyObject3 myObject3 = new MyObject3();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject3.methodA();
			}
		};
		thread.setName("a");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject3.methodB();
			}
		};
		thread2.setName("b");
		thread.start();
		thread2.start();
		Thread.sleep(7000);
		/*
		 * 结论:当一个线程访问一个对象的同步代码块时，其他的线程不能就访问该对象的其他同步代码块，访问将被阻塞
		 * 		，说明synchronized使用的"对象监视器"是一个
		 * 
		 */
	}
	
	
	//验证同步synchronized(this)代码块是锁定当前对象的
	@Test
	public void synchronizedWholeObject() throws InterruptedException{
		final MyObject4 myObject4 = new MyObject4();
		Thread thread = new Thread(){
			public void run() {
				super.run();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				myObject4.methodA();
			}
		};
		thread.setName("a");
		Thread thread2 = new Thread(){
			public void run() {
				super.run();
				myObject4.methodB();
			}
		};
		thread2.setName("b");
		thread.start();
		thread2.start();
		Thread.sleep(2000);
		/*
		 * 		MyObject4对象methodA和methodB方法里面都加了代码块
		 * 			和synchronized方法一样，synchronized(this)代码块也是锁定当前对象的
		 * 		当有一个线程占有该代码块的锁，就是占有该对象的所有代码块的锁了，其他线程也不能访问该对象的其他代码块
		 * 		其他线程想进入就要拿到锁的线程释放锁，
		 * 		
		 * 		
		 */
	}
	
	
	//将任意对象作为对象监视器
	@Test
	public void main() throws InterruptedException{
		final MyObject5 myObject5 = new MyObject5();
		Thread thread = new Thread(){
			public void run() {
				super.run();
				myObject5.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			public void run() {
				super.run();
				myObject5.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(3000);
		/*
		 * 	java支持锁非this对象:格式是synchronized(非this对象)(非this对象一般是实例变量及参数)
		 * 		锁非this对象的优点:如果在一个类中有多个synchronized同步方法，这时候虽然能实现同步，
		 * 		但会受到阻塞，所以会影响运行的效率。但是如果使用同步代码块锁给this对象，
		 * 		synchronized(非this对象)与程序中的synchronized方法和synchronized(this)代码块是异步的
		 * 		不与其他锁this同步方法去抢this锁，可以大大提高效率
		 * 
		 * 		anything就是对象监视器
		 * 
		 */
	}
	
	
	//同步方法与同步方法代码块会相互阻塞
	@Test
	public void synchronizedAndNoSynchronizd() throws InterruptedException{
		final MyObject6 myObject6 = new MyObject6();
		Thread thread = new Thread(){
			public void run() {
				super.run();
				myObject6.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			public void run() {
				super.run();
				myObject6.methodB();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(6000);
		/*
		 * 结论:同步方法与同步代码块是一样的(都是拿到对象的锁)，
		 * 		都是一样锁着整个对象，当一个线程拿到了对象锁，那么无论是同步方法还是同步代码块 其他线程都是无法进入的
		 */
	}
	
	
	//私有变量是线程安全
	@Test
	public void privateVariableSafe() throws InterruptedException{
		final MyObject7 myObject7 = new MyObject7();
		Thread thread = new Thread(){
			public void run() {
				super.run();
				myObject7.methodA();
			}
		};
		thread.setName("a");
		Thread thread2 = new Thread(){
			public void run() {
				super.run();
				myObject7.methodA();
			}
		};
		thread2.setName("b");
		thread.start();
		Thread.sleep(1000);
		thread2.start();
		Thread.sleep(2000);
		/*
		 * 结论:私有变量是线程安全的
		 * 
		 */
	}

	
	//将任意对象作为对象监视器，对象监视器必须是同一个对象
	@Test
	public void synchronizedMustOneObject(){
		try {
			final MyObject8 myObject8 = new MyObject8();
			Thread thread = new Thread(){
				public void run() {
					super.run();
					myObject8.methodA();
				}
			};
			thread.setName("a");
			Thread thread2 = new Thread(){
				public void run() {
					super.run();
					myObject8.methodA();
				}
			};
			thread2.setName("b");
			thread.start();
			thread2.start();
			Thread.sleep(4000);
			/*
			 * 结论:
			 * 		使用synchronized(非this对象)同步代码块的话，对象监视器必须是同一个对象。
			 * 			如果不是同一个对象监视器，那么运行的结果就是异步了，就会交叉
			 * 
			 * 	这个例子，使用的对象监视器是一个方法内的变量，是一个私有变量，当两个线程去访问时都不是同一个了，
			 * 		所以运行的结果就会交叉
			 * 	
			 * 	但是在这里我不明白，为什么不同的线程访问同一个对象的私有变量不同，当两个线程访问的时候，一个对象的其中的一个方法里面怎么会有不用的变量值
			 * 
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//再一个例子，this对象与非this对象的对比，拿到的是不用的锁，所以这两个是异步的
	@Test
	public void thisAndNoThis(){
		MyObject9 myObject9 = new MyObject9();
		MyThread3 myThread3 = new MyThread3(myObject9);
		myThread3.setName("a");
		MyThread4 myThread4 = new MyThread4(myObject9);
		myThread4.setName("b");
		myThread3.start();
		myThread4.start();
		/*
		 * 由于对象的监视器不同(一个是this，一个是anything(非this))，所以运行的结果就是异步的
		 */
	}
	
	
	
	//多个线程调用同一个方法是随机的
	@Test
	public void randomThread(){
		try {
			final ObjectA objectA = new ObjectA();
			Thread thread = new Thread(){
				public void run() {
					super.run();
					for(int i=0; i<100; i++){
						objectA.add("线程A执行" + (i+1));
					}
				}
			};
			thread.setName("A");
			Thread thread2 = new Thread(){
				public void run() {
					super.run();
					for(int i=0; i<100; i++){
						objectA.add("线程B执行" + (i+1));
					}
				}
			};
			thread2.setName("B");
			thread.start();
			thread2.start();
			Thread.sleep(6000);
			/*
			 * 	从运行结果来看，同不方法中的代码是同步打印的，当前线程的"执行"和"退出"是成对出现的
			 * 	但是线程A和线程B的执行是异步的，这就又可能出现"脏读"的环境。由于线程执行方法的顺序不确定，
			 * 	所以当A和B两个线程执行带有分支判断的方法时，就会出现逻辑上的错误，有可能出现脏读
			 * 
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//模拟A和B两个线程执行带有分支判断的方法时，出现脏读，这里是要设计一个list只装一个元素的
	@Test
	public void misData(){
		try {
			final ObjectC objectC = new ObjectC();
			final ObjectB list = new ObjectB();
			Thread thread = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectC.addServiceMethod(list, "A内容");
				}
			};
			thread.setName("A线程");
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectC.addServiceMethod(list, "B内容");
				}
			};
			thread2.setName("B线程");
			thread.start();
			thread2.start();
			Thread.sleep(3000);
			System.out.println("输出的list元素个数" + list.getSize());
			/*
			 * 上面的设计集合是只装一个元素的，但还没有方法的逻辑时，又有一个线程跑进入，导致数据出错
			 * 	
			 * 	修改代码:在
			 * 	
			 * 	synchronized (list) {
			 *		if(list.getSize() < 1){
			 *			Thread.sleep(2000);//模拟从远程花费2秒取回数据，出错的原因就是线程还在这里，还没有执行list.add，
			 *							//	又有一个线程跑进行，导致list数据出错
			 *			list.add(data);
			 *		}
			 *	}
			 *		
			 *		加了synchronized (list)就可以对方法进行加锁，  
			 *	
			 * 
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//synchronized(非this对象x)，格式的写法是将x对象本身作为"对象监视器"，当多个线程同时执行synchronized(x)同步代码块是呈同步效果
	@Test
	public void synchronizedThisX() throws InterruptedException{
		final ObjectD objectD = new ObjectD();
		final ObjectE objectE = new ObjectE();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				objectE.methodA(objectD);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectE.methodA(objectD);
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(6000);
		/*
		 * 	结论:如果使用同一个"对象监视器"，那多个线程执行c(X){}同步代码块时呈同步效果
		 */
	}
	
	
	//使用不同的"对象监视器"
	@Test
	public void synchronizedThisXA() throws InterruptedException{
		final ObjectD objectD = new ObjectD();
		final ObjectD objectD2 = new ObjectD();
		final ObjectE objectE = new ObjectE();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				objectE.methodA(objectD);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectE.methodA(objectD2);
			}
		};
		thread2.setName("B");
		thread2.start();
		thread.start();
		Thread.sleep(6000);
		/*
		 * 结论:多个线程执行不同的"对象监视器"，是不同步的
		 */
	}
	
	
	
	//当同步代码块中 synchronized(非this的X)，而X中也有同步方法，则同步代码块中的synchronized(非this的X){代码}要与X中的同步方法同步
	@Test
	public void aa() throws InterruptedException{
		final ObjectF objectF = new ObjectF();
		final ObjectG objectG = new ObjectG();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectG.methodA(objectF);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectG.methodA(objectF);
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(6000);
	}
	
	
	
	//其他线程执行X对象方法里面的synchronized(this)代码块
	@Test
	public void synchronizedOtherThread() throws InterruptedException{
		final ObjectH objectH = new ObjectH();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectH.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectH.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(1000);
		/*
		 * 结论:当其他的线程执行x对象里面的同步方法也是呈现同步的效果的
		 * 
		 */
	}
	
	
	//静态同步synchronized方法，在static方法上加上synchronized代码块
	@Test
	public void staticSynchronized() throws InterruptedException{
		final ObjectI objectI = new ObjectI();
		final ObjectI objectI2 = new ObjectI();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectI.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectI2.methodA();
			}
		};
		thread2.setName("B");
		thread2.start();
		thread.start();
		Thread.sleep(2000);
		/*
		 * 结论:
		 * 		synchronized关键字加到static静态方法上是给Class类上锁的，
		 * 		而synchronized关键字加到非static上非静态上是给对象上锁的
		 * 		
		 * 		synchronized+static 是一把类锁，对所有的对象都起作用的
		 */
	}
	
	
	//验证:synchronized+static 与 synchronized+非static 不是同一把锁
	@Test
	public void staitcOrNoStatic() throws InterruptedException{
		final ObjectJ objectJ = new ObjectJ();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectJ.methodStatic();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectJ.methodNoStatic();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(2000);
		/*
		 * 		两个线程对同一个对象的两个方法(一个是static的同步方法，一个是非static的同步方法)，结果是异步执行
		 * 
		 * 结论:synchronized+static 与 synchronized+非static 不是同一把锁
		 * 
		 * 		synchronized+static
		 * 			 是一把Class锁，对所有的对象实例都是有效的
		 * 
		 * 		synchronized+非static	
		 * 			是一把对象锁，只对一个对象是有效的，而这个只是锁住一个对象
		 * 
		 */
	}
	
	
	//使用Class锁: 两个线程对两个对象实例，结果是同步执行的
	@Test
	public void TwoThreadSynchronizedStaitc() throws InterruptedException{
		final ObjectK objectK = new ObjectK();
		final ObjectK objectK2 = new ObjectK();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectK.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectK2.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(2000);
		/*
		 *	结论: 有两个线程对两个是两个实例变量进行操作，
		 *		使用的是Class锁，但是执行的结果还是同步的
		 * 
		 * 		就是Class锁 锁定的是Class字节码，是对于所有的对象，而不是针对某一个实例对象而言的，
		 * 			对于所有的对象，用到synchronized+static都是同步执行的
		 */
	}
	

	
	//同步synchronized(class)代码块
	@Test
	public void synchronizedClass() throws InterruptedException{
		final ObjectL objectL = new ObjectL();
		final ObjectL objectL2 = new ObjectL();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectL.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectL2.methodB();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(2000);
		/*
		 *	结论:对synchronized(class)也是一样的，因为class字节码是杜独一无二的，
		 *		所以synchronized(class)对于所有的线程所有的对象都是一样的，无论是有多少个线程或者是对象，都是异步执行的
		 */
	}
	
	
	//数据类型String的常量池特性(1)
	@Test
	public void aboutString(){
		String a = "aa";
		String b = "aa";
		System.out.println(a == b);
		/*
		 * 		在jvm具有String常量池缓存的功能，所以打印的结果是true
		 */
	}
	
	
	//数据类型String的常量池特性(2):synchronized同步块的使用
	@Test
	public void synchronizedString() throws InterruptedException{
		final ObjectM objectM = new ObjectM();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectM.methodA("AA");
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectM.methodA("AA");
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(10000);
		/*
		 * 	出现这种情况就是因为String的两个值都是AA，两个线程具有相同的，所以造成B线程不能执行，
		 * 		这就是String常量池带来的问题，所以在大多数的情况，同步synchronized()代码块都不使用String作为锁的对象
		 * 			而是使用其他的，比如new Object()实例化一个Object对象，但是它并没有放进缓存中
		 * 
		 */
	}
	
	
	//使用new Object()来作为同步代码块的对象
	@Test
	public void otherObjectAsSynchronized() throws InterruptedException{
		final ObjectN objectN = new ObjectN();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectN.methodA(new Object());
			}
		}; 
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectN.methodA(new Object());
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(5000);
	}
	
	
	//同步synchronized方法无限等待与解决
	@Test
	public void synchronizedAlway() throws InterruptedException{
		final ObjectO objectO = new ObjectO();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectO.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectO.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(6000);
		/*
		 * 线程A获得了锁，但是进入死循环，线程B是永远得不到运行的机会，
		 * 		锁死了，可以使用同步代码块来解决这样的问题
		 * 
		 */
	}

	
	
	//解决上面的问题,使用不同的锁对象来解决同步方法无限等待问题,使用同步代码块来解决线程的死锁问题
	@Test
	public void userOtherObject() throws InterruptedException{
		final ObjectP objectP = new ObjectP();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectP.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectP.methodB();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(5000);
		/*
		 * 这样使用不同的对象来对同一个对象的不同的同步方法进行同步就不会出现死循环，导致其他线程不能进入的问题了
		 * 
		 */
	}
	
	
	//多线程的死锁问题,就是不同的线程都在等待一个根本不可能被释放的锁,这会造成线程的"假死"现象
	@Test
	public void deadLock() throws InterruptedException{
		ObjectQ objectQ = new ObjectQ();
		objectQ.setFlag("a");
		Thread thread = new Thread(objectQ);
		thread.start();
		Thread.sleep(100);
		objectQ.setFlag("b");
		Thread thread2 = new Thread(objectQ);
		thread2.start();
		/*
		 * 	java线程死锁是一个经典的多线程问题，因为不同的线程都在等待根本不可能被释放的锁，从而导致所有的任务都无法继续完成
		 * 		死锁是程序设计的bug，在设计程序时就要避免双方互相持有对方的锁的情况，
		 * 
		 * 		本实验使用synchronized嵌套的代码来实现死锁，其实不使用synchronized嵌套也会出现死锁的现象
		 * 			与嵌套没有关系，不要被代码的结构误导了，只要是互相等到对方释放的锁就有可能出现四锁
		 * 
		 */
	}
	
	
	//内置类与静态内置类
	
	//简答的内置类测试
	@Test
	public void simpleInnerClass(){
		ObjectR objectR = new ObjectR();
		objectR.setUsername("aa");
		objectR.setPassword("bb");
		System.out.println(objectR.getUsername() + " " + objectR.getPassword());
		PrivateClass privateClass = objectR.new PrivateClass();//如果内部类与测试的代码不在同一个包下，那么需要将该内部类的内置声明改为public
		privateClass.setAge("22");
		privateClass.setAddress("珠海");
		System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
		/*
		 * 想要实例化内置类必须要使用如下的代码:
		 * 				PrivateClass privateClass = objectR.new PrivateClass();
		 */
	}
}
      