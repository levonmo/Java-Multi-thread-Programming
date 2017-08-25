package mythread1;

import otherObject.MyObject;

//synchronized方法与锁对象
public class MyThread7 extends Thread{
	
	private MyObject myObject;
	
	public MyThread7(MyObject myObject) {
		this.myObject = myObject;
	}

	@Override
	public void run() {
		super.run();
		myObject.method1();
	}
	
}
