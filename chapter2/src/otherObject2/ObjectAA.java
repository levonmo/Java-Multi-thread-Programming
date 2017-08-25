package otherObject2;
//volatile关键字(3):解决同步死循环
public class ObjectAA extends Thread {

	private boolean isRunning = true;
	
	private boolean isRunning(){
		return isRunning;
	}
	
	public void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("进入run了");
		while (isRunning == true) {
			//这里是无限的循环
		}
		System.out.println("线程被停止了");
	}
	
}
