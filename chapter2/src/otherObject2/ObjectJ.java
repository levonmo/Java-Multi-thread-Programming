package otherObject2;

//验证:synchronized+static与synchronized+非static不是同一把锁
public class ObjectJ {

	
	synchronized public static void methodStatic(){
		try {
			System.out.println(Thread.currentThread().getName() + "线程进入同步静态方法"); 
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + "线程退出同步静态方法");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void methodNoStatic(){
		try {
			System.out.println(Thread.currentThread().getName() + "线程进入同步非静态方法"); 
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + "线程退出同步非静态方法");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
