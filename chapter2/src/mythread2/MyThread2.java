package mythread2;

import otherObject.PublicVar;

//‘‡∂¡
public class MyThread2 extends Thread {
	
	private PublicVar publicVar;

	public MyThread2(PublicVar publicVar) {
		this.publicVar = publicVar;
	}
	
	@Override
	public void run() {
		super.run();
		publicVar.setValue("B", "BB");
	}

}
