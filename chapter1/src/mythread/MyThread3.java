package mythread;

//演示执行start()方法的顺序不代表线程启动的顺序
public class MyThread3 extends Thread {
	private int i;
	
	//创建一个构造器，利用该构造器创建一个新的对象，该对象拥有一个变量i 并赋值
	public MyThread3(int i ) {
		super();
		this.i = i;
	}
	
	//当有一个线程对象的时候，每次  对象.start()都会调用这个run方法，调用start（）方法是异步执行的，cpu会随机选取一个时间出来去调用该线程
	@Override
	public void run() {
		System.out.println(i);
	}
	
}
