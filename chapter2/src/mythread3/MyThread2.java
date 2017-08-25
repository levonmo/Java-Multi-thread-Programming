package mythread3;

import otherObject.MyObject;
import otherObject2.MyObject1;

//synchronized·½·¨µÄ±×¶Ë
public class MyThread2 extends Thread {

	private MyObject1 myObject;
	
	public MyThread2(MyObject1 myObject) {
		this.myObject = myObject;
	}

	@Override
	public void run() {
		super.run();
		myObject.doLongTimeTask();
	}
}
