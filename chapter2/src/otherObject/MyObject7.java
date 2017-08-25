package otherObject;

//同步不具有继承性
public class MyObject7 {
	
	synchronized public void method(){
		try {
			System.out.println("父线程" + Thread.currentThread().getName() + "开始");
			Thread.sleep(2000);
			System.out.println("父线程" + Thread.currentThread().getName() + "结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
