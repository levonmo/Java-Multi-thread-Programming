package mythread2;

import otherObject.MyObject9;

//Í¬²½´úÂë¿é:synchronized(this)
public class MyThread8 extends Thread {
	
	private MyObject9 myObject9;

	public MyThread8(MyObject9 myObject9) {
		this.myObject9 = myObject9;
	}
	
	@Override
	public void run() {
		super.run();
		myObject9.method();
	}
}
