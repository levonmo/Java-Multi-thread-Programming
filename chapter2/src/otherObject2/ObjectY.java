package otherObject2;

//volatile关键字(1):无法停止的线程
public class ObjectY {

	private boolean isContinuePrint = true;
	private boolean isContinuePrint(){
		return isContinuePrint;
	}
	public void setContinuePrint(boolean isContinuePrint) {
		this.isContinuePrint = isContinuePrint;
	}
	
	public void printStringMethod(){
		try {
			while(isContinuePrint){
				System.out.println("当前的线程是" + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
