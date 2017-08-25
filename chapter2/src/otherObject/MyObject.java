package otherObject;

//synchronized方法与锁对象
public class MyObject {
	
	synchronized public void method1(){
		try {
			System.out.println("method 开始");
			System.out.println("当前线程是" + Thread.currentThread().getName() + "当前时间是" + System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
