package otherObject2;
//volatile关键字(4):使用volatile关键字
public class ObejctAC extends Thread {
	
	volatile private boolean isRunning = true;
	public boolean isRunning(){
		return isRunning;
	}
	
	public void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("进入了run方法");
		while (isRunning) {
			//这里进行无限的循环
		}
		System.out.println("线程被停止了");
	}
}
