package otherObject2;

public class ObjectF {

	synchronized public void mehtodA(){
		try {
			System.out.println("同步方法" + Thread.currentThread().getName() + "线程进入");
			Thread.sleep(1000);
			System.out.println("同步方法" + Thread.currentThread().getName() + "线程退出");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
