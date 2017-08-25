package otherObject2;
//使用Class锁: 两个线程对两个对象实例，结果是同步执行的
public class ObjectK {
	
	synchronized public static void methodA(){
		try {
			System.out.println(Thread.currentThread().getName() + "线程进入");
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + "线程退出");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
