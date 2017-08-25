 package mythread3;

import otherObject2.MyObject9;

//再一个例子，this对象与非this对象的对比
public class MyThread3 extends Thread{
	
	private MyObject9 myObject9;
	
	public MyThread3(MyObject9 myObject9) {
		// TODO Auto-generated constructor stub
		this.myObject9 = myObject9;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		myObject9.methodA();
	}
	
}
