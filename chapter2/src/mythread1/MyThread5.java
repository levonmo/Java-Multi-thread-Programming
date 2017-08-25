package mythread1;

import otherObject.HasPrivateNum;

//实例变量的非线程安全
public class MyThread5 extends Thread {
	
	private HasPrivateNum hasPrivateNum;
	
	public MyThread5(HasPrivateNum hasPrivateNum) {
		this.hasPrivateNum = hasPrivateNum;
	}

	
	@Override
	public void run() {
		hasPrivateNum.addUsername("b");
	}
	
}
