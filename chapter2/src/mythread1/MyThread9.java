package mythread1;

import otherObject.MyObject2;

//在一个类中一个是同步方法，一个不是同步方法
public class MyThread9 extends Thread {

	private MyObject2 myObject2;
	
	public MyThread9(MyObject2 myObject2) {
		this.myObject2 = myObject2;
	}
	
	@Override
	public void run() {
		super.run();
		myObject2.mehtod2();//mehtod2是非同步方法
	}
}
