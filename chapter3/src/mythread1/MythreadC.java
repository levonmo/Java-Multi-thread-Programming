package mythread1;

public class MythreadC extends Thread {
	
	private MythreadB mythreadB;
	
	public MythreadC(MythreadB mythreadB) {
		this.mythreadB = mythreadB;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		mythreadB.methodA();
	}
	
}
