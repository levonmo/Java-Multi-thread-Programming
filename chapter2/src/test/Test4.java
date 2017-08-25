package test;

import java.util.Iterator;

import org.junit.Test;

import otherObject2.ObejctAC;
import otherObject2.ObjectAA;
import otherObject2.ObjectAC;
import otherObject2.ObjectAD;
import otherObject2.ObjectAE;
import otherObject2.ObjectS;
import otherObject2.ObjectS.PrivateClass;
import otherObject2.ObjectT.classA;
import otherObject2.ObjectU.ClassB;
import otherObject2.ObjectU.ClassC;
import otherObject2.ObjectV;
import otherObject2.ObjectW;
import otherObject2.ObjectX;
import otherObject2.ObjectY;
import otherObject2.ObjectZ;

public class Test4 {

	//静态的内置类
	@Test
	public void staticClass(){
		ObjectS objectS = new ObjectS();
		objectS.setUsername("AA");
		objectS.setPassword("BB");
		System.out.println(objectS.getUsername() + " " + objectS.getPassword());
		PrivateClass privateClass = new PrivateClass();
		privateClass.setAge("22");
		privateClass.setAddress("珠海");
		System.out.println(privateClass.getAddress() + privateClass.getAge());
	}
	
	
	//内置类与同步:实验一:内置类有两个同步方法，但使用的是不同的锁
	@Test
	public void twoMethodUserDifferentLock() throws InterruptedException{
		final classA classA = new classA();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classA.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classA.methodB();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(9000);
		/*
		 * 结论:内置类中，不同的同步方法使用不同的锁，打印的结果是异步的
		 * 
		 */
	}
	
	
	//内置类与同步:实验2
	@Test
	public void testb() throws InterruptedException{
		final ClassB classB = new ClassB();//当一个内置类与测试的程序不在一个包上，就要内置的类声明为public
		final ClassC classC = new ClassC();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classB.methodA(classC);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classB.methodB();
			}
		};
		thread2.setName("B");
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classC.methodB();
			}
		};
		thread3.setName("C");
		thread.start();
		thread2.start();
		thread3.start();
		Thread.sleep(7000);
		/*
		 * 结论就是:
		 * 		B进入ClassB中的methodB方法
		 *		C进入ClassC中的methodB方法，时候就开始打印数字的
		 *		
		 *			但是A没有第一时间进入ClassB中的methodA方法，是因为methodA是用synchronized(ClassC)上锁，是一把Class锁，
		 *			而ClassC中的methodB方法也是同步方法，这时候线程C拿到了这把锁，所以线程A只有等待线程C释放这把锁的才能拿到，
		 * 
		 */
	}
	
	
	
	//锁对象的改变
	@Test
	public void lockObjectChange() throws InterruptedException{
		final ObjectV objectV = new ObjectV();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectV.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectV.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		Thread.sleep(50);
		thread2.start();
		Thread.sleep(500);
		/*
		 * 在将任何数据类型作为同步锁的时候，需要注意的是，是否有多个线程同时持有锁对象，
		 * 	如果同时持有相同的锁对象，则这些线程之间就是同步的，如果是分别获取锁对象，则这些线程之间就是异步的
		 * 		
		 * 	还要注意的是:	
		 * 		只要对象不变，即使对象的属性被改变，运行的结果还是同步的
		 * 
		 */
	}
	
	
	
	//只要对象不变，即使是对象的属性被改变，运行的结果还是同步的
	@Test
	public void newPropertiesLockOne() throws InterruptedException{
		final ObjectX objectX = new ObjectX();
		final ObjectW objectW = new ObjectW();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectW.methodA(objectX);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectW.methodA(objectX);
			}
		};
		thread2.setName("B");
		thread2.start();
		Thread.sleep(300);
		thread.start();
		Thread.sleep(3000);
		/*
		 * 	在这里，B线程首先进入了ObjectW中的methodA方法，同步代码块中绑定的是ObjectX对象，
		 * 		但是在thread2进入去之后，将ObjectX中的username属性改了，但是就是改了，thread还是无法进入该同步代码块
		 * 			
		 * 	所以只要是对象没有改变，即使是对象的属性发生个改变，运行的结果还是同步的
		 * 
		 */
	}
	
	
	//volatile关键字(1):无法停止的线程
	@Test
	public void volatileA(){
		ObjectY objectY = new ObjectY();
		objectY.printStringMethod();
		System.out.println("我要停止它");
		objectY.setContinuePrint(false);
		/*
		 * 线程是无法停止下来的，
		 * 		原因主要是main线程一直在处理while()循环，导致程序不能继续执行后面的代码。解决的办法是使用多线程技术(看下面的代码)
		 */
	}
	
	
	//volatile关键字(2):解决同步死循环
	@Test
	public void sotpLoop() throws InterruptedException{
		ObjectZ objectZ = new ObjectZ();
		new Thread(objectZ).start();
		Thread.sleep(1000);
		System.out.println("我要停止它");
		objectZ.setContinue(false);
		/*
		 * 但当上面的代码的格式运行在-server服务器模式中64-bit的jvm上时，
		 * 	会出现死循环。
		 * 		解决的办法就是使用volatile关键字
		 * 			volatile关键字的作用就是强制从公共堆栈中取得变量的值，而不是从线程私有数据栈中取得变量的值
		 */
	}
	
	
	
	//volatile关键字(3):解决同步死循环
	@Test
	public void solveInfiniteLoop() throws InterruptedException{
		ObjectAA objectAA = new ObjectAA();
		objectAA.start();
		Thread.sleep(1000);
		objectAA.setRunning(false);
		System.out.println("已经赋值为false了");
		Thread.sleep(1000);
		/*
		 * 在这里win结合JDK64的环境中 是可以停止这个死循环的
		 * 	
		 * 	但是只要配置Eclipse中JVM的运行参数为-service
		 * 		代码System.out.println("线程被停止了");就不会被执行
		 * 			因为在启动objectAA.start();线程的时候，变量private boolean isRunning = true;
		 * 			存在于公共堆栈及线程的私有堆栈中。
		 * 			在jvm被设置为-service模式时为了线程的效率，线程一直在私有的堆栈中取得isRunning的值是true。
		 * 			而代码objectAA.setRunning(false);；虽然被执行了，更新的却是公共堆栈中的isRunning变量值false，
		 * 				所以一直就是死循环
		 * 
		 * 	这个问题其实就是私有堆栈中的值与公共堆栈中的值不同步造成的
		 * 		解决这样的问题就要使用volatile关键字了，它的只要作用就是当线程访问isRunning这个变量时，
		 * 			强制性从公共堆栈中取值
		 * 
		 */
	}
	
	
	
	//volatile关键字(4):使用volatile关键字
	@Test
	public void useVolatile() throws InterruptedException{
		ObejctAC obejctAC = new ObejctAC();
		obejctAC.start();
		Thread.sleep(1000);
		obejctAC.setRunning(false);
		Thread.sleep(1000);
		/*
		 * 和上面的程序比较就是多了一个volatile关键字，但是却可以中断run方法里面的死循环
		 * 
		 * 	通过使用volatile关键字，强制的从公共内存中读取变量的值
		 * 	使用volatile关键字增加了实例变量在多个线程之间的可见性。
		 * 		但是最致命的缺点就是不支持原子性
		 * 
		 * 	volatile和synchronized进行一下比较
		 * 		1.关键字volatile是线程同步的轻量级实现，所以volatile性能肯定是比synchronized要更好
		 * 			，并且volatile只能修饰于变量，而synchronized可以修饰方法，以及代码块，随着jdk新版本的发布。
		 * 			synchronized关键字在执行效率上得到很大的提高，在开发中使用synchronized关键字的比率还是很大的。
		 * 		2.多线程访问volatile不会发生阻塞，而synchronized会出现阻塞
		 * 		3.volatile能保证数据的可见性，但不能保证原子性，而synchronized可以保证原子性，也可以间接保证可见性，
		 * 			因为它会将私有内存和公共内存中的数据做同步。
		 * 		4.再次重申一下，关键字volatile解决的是变量在多线程之间的可见性；而synchronized解决的是多线程之间访问资源的同步性
		 * 
		 * 		线程安全包含原子性和可见性两个方面，java的同步机制都是围绕着两个方面来确保线程安全的。
		 */
	}
	
	
	//volatile非原字性的特征
	@Test
	public void volatileThread(){
		//线程数组
		ObjectAC[] objectAC = new ObjectAC[100];
		
		for (int i = 0; i < 100; i++) {
			objectAC[i] = new ObjectAC();
		}
		
		for (int i = 0; i < 100; i++) {
			objectAC[i].start();
		}
		/*
		 *  因为  count++  这一行代码是分三个步骤来完成的
		 *  	1.从内存中取出count的值
		 *  	2.计算count的值
		 *  	3.将count的值写到内存中去
		 *  
		 *  	上面之所以出现数据的脏读可以就是因为，多个线程同时执行了count++这一行代码，
		 *  		但是有的线程执行+1的操作，还没有写入内存中就其他的线程就已经又进入了count++，所以就会出现脏读
		 *  
		 *  	关键字volatile主要的使用场合是在多线程中可以感知实例变量被更改了，
		 *  		并且可以获取最新的值使用，也就是用多线程读取共享变量时可以获取最新的值使用
		 *  	
		 *  	关键字volatile提示线程每次从共享内存中读取变量，而不是从私有内存中读取，这样就保证了同步数据的可见性
		 *  		但在这里需要注意的是:如果修改实例变量中的数据，如果是i++,也就是i=i+1，则这样的操作其实并不是一个原子操作4
		 *  			也就是非线程安全的
		 *  
		 *  
		 *  上面例子解决的办法就是在count++那加上同步锁
		 */
	}
	
	
	/*
	 * 使用原子类对i++进行操作，除了在i++操作是使用synchronized关键字实现同步外，还可以使用AtomicInteger原子类进行实现
	 * 	原子操作是不能分割的整体，没有其他的线程能够中断或检查正在原子操作中的变量(原子在计算的过程中，其他的线程是不可能进入的)，
	 * 		一个原子类型就是一个原子操作可用的类型，它可以在没有锁的情况下做到线程安全
	 */
	@Test
	public void atomicInteger(){
		ObjectAD objectAD = new ObjectAD();
		Thread thread = new Thread(objectAD);//new Thread();构造器中可以是一个实现Running接口的，也可以是继承了Thread类的
		thread.start();
		Thread[] threadArray =  new Thread[100];
		for (int i = 0; i < 100; i++) {
			threadArray[i] = new Thread(objectAD);
		}
		for (int i = 0; i < 100; i++) {
			threadArray[i].start();
		}
	}
	
	
	
	//synchronized代码块有volatile同步功能(1):停不下的循环
	@Test
	public void synchronizedUpdateNewData() throws InterruptedException{
		final ObjectAE objectAE = new ObjectAE();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectAE.runMethod();
			}
		};
		thread.setName("A");
		Thread.sleep(60);
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectAE.stopMethod();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(600);
		System.out.println("已经发起了停止的指令");
		/*
		 * 如果是使用-service服务器模式于运行这个项目就会出现死循环
		 * 	得到这个结果是各个线程的数据值没有可视性造成的
		 * 		而关键字synchronized可以具有可视性
		 * 
		 * 	更改代码在while循环里面加上一把锁就可以了
		 * 	
		 * 		synchronized可以保证同一时刻，只有一个线程可以执行一个方法或某一个代码块。
		 * 			它包含两个特征:互斥性和可见性。同步synchronized不仅可以解决一个线程看到对象处于不一致的状态，
		 * 				还可以保证进入同步方法或者是同步代码块的每个线程，都可以由同一个锁保护之前所有的修改效果
		 * 
		 * 	学习多线程，要着重"外练互斥，内修可见"。这是掌握多线程，学习多线程并发的重要技术点 
		 * 	
		 */
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
