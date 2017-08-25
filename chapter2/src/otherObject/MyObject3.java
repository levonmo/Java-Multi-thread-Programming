package otherObject;

//synchronized锁重入
public class MyObject3 {
	
	synchronized public void method1(){
		try {
			System.out.println("method1");
			method2();
			Thread.sleep(1000);
			System.out.println("method1执行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized public void method2() {
		System.out.println("method2");
		method3();
	}

	synchronized public void method3() {
		System.out.println("method3");
	}

}
