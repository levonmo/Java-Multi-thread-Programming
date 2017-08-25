package otherObject;

//同步不具有继承性
public class MyObject8 extends MyObject7{
	
	//去掉synchronized试试效果
	synchronized public void method(){
		try {
			System.out.println("子线程" + Thread.currentThread().getName() + "开始");
			Thread.sleep(2000);
			System.out.println("子线程" + Thread.currentThread().getName() + "结束");
			super.method();//调用父类的method方法
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
