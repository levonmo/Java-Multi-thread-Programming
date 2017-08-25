package mythread1;

import otherObject.MyObject2;

//在一个类中一个是同步方法，一个不是同步方法
public class MyThread8 extends Thread {

	private MyObject2 myObject2;
	
	public MyThread8(MyObject2 myObject2) {
		this.myObject2 = myObject2;
	}
	
	@Override
	public void run() {
		super.run();
		myObject2.method1();//method1是同步方法
	}
}
