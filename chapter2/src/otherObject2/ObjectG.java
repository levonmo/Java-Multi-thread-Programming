package otherObject2;

public class ObjectG {

	public void methodA(ObjectF objectF){
		synchronized (objectF) {
			try {
				System.out.println("同步代码块" + Thread.currentThread().getName() + "线程进入");
				Thread.sleep(1000);
				System.out.println("同步代码块" + Thread.currentThread().getName() + "线程退出");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
