package mythread1;

import otherObject.HasSelfPrivateNum;

//方法内部声明一个变量，是不存在"非线程安全"问题的
public class MyThread1 extends Thread{
	
	private HasSelfPrivateNum hasSelfPrivateNum;
	
	public MyThread1(HasSelfPrivateNum hasSelfPrivateNum) {
		this.hasSelfPrivateNum = hasSelfPrivateNum;
	}

	@Override
	public void run() {
		super.run();
		hasSelfPrivateNum.addI("a");
	}
	
}
