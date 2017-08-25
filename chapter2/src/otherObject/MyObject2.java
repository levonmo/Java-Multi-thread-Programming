package otherObject;

//在一个类中一个是同步方法，一个不是同步方法
public class MyObject2 {

	private int i = 0;
	
	synchronized public void method1(){
		try {
			i = 50;
			System.out.println("同步方法开始" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("同步方法" + i);
			System.out.println("同步方法结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
	 public void mehtod2(){
		i = 100;
		System.out.println("非同步方法开始" + Thread.currentThread().getName());
		System.out.println("非同步方法开始");
		System.out.println("非同步方法" + i);
	}
}
