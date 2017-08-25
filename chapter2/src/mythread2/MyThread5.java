package mythread2;

import otherObject.MyObject5;

//可重入锁的父子类继承
public class MyThread5 extends Thread {
	
	@Override
	public void run() {
		MyObject5 myObject5 = new MyObject5();
		myObject5.methodSon();
	}

}
