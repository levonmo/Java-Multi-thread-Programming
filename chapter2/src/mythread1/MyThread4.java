package mythread1;

import otherObject.HasPrivateNum;

//实例变量的非线程安全
public class MyThread4 extends Thread {
	
	private HasPrivateNum hasPrivateNum;
	
	public MyThread4(HasPrivateNum hasPrivateNum) {
		this.hasPrivateNum = hasPrivateNum;
	}

	
	@Override
	public void run() {
		hasPrivateNum.addUsername("a");
	}
	
}
