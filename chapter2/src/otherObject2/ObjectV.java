package otherObject2;

//锁对象的改变
public class ObjectV {

	private String lock = "123";
	
	public void methodA(){
		synchronized (lock) {
			try {
				System.out.println(Thread.currentThread().getName() + "线程进入" );
				lock = "456";
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + "线程退出" );
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
}
