package otherObject2;

//静态同步方法synchronized方法
public class ObjectI {
	
	synchronized public static void methodA(){
		try {
			System.out.println(Thread.currentThread().getName() + "线程进入");
			Thread.sleep(200);
			System.out.println(Thread.currentThread().getName() + "线程退出");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
