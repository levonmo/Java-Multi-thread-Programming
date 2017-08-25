package mythread2;

import otherObject.MyObject3;

//synchronizedËøÖØÈë
public class MyThread4 extends Thread{
	
	@Override
	public void run() {
		super.run();
		MyObject3 myObject3 = new MyObject3();
		myObject3.method1();
	}

}
