package otherObject2;
//volatile关键字(2):解决同步死循环
public class ObjectZ implements Runnable{

	private boolean isContinue = true;
	
	public boolean isContinue(){
		return isContinue;
	}
	
	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}


	public void printStringMethod(){
		try {
			while (isContinue) {
				System.out.println("当前的线程是" + Thread.currentThread().getName());
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.printStringMethod();
	}
	

}
