package mythread1;

public class MythreadA extends Thread  {
	
	private MythreadB mythreadB;
	
	public MythreadA(MythreadB mythreadB) {
		this.mythreadB = mythreadB;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			synchronized (mythreadB) {
				mythreadB.start();
				Thread.sleep(6000);
				mythreadB.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
