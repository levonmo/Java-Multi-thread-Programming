package mythread2;

import otherObject.PublicVar;

//‘‡∂¡
public class MyThread3 extends Thread {
	
	private PublicVar publicVar;

	public MyThread3(PublicVar publicVar) {
		this.publicVar = publicVar;
	}
	
	@Override
	public void run() {
		super.run();
		publicVar.getValue();
	}

}
