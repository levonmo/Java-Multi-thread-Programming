package mythread3;

import otherObject2.MyObject1;

//synchronized·½·¨µÄ±×¶Ë
public class MyThread1 extends Thread {

	private MyObject1 myObject;
	
	public MyThread1(MyObject1 myObject) {
		this.myObject = myObject;
	}

	@Override
	public void run() {
		super.run();
		myObject.doLongTimeTask();
	}
}
