package otherObject2;

//synchronized(Class)代码块
public class ObjectL {

	public void methodA(){
		synchronized (ObjectL.class) {
			try {
				System.out.println(Thread.currentThread().getName() + "线程进入methodA方法");
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + "线程退出methodA方法");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void methodB(){
		synchronized (ObjectL.class) {
			System.out.println(Thread.currentThread().getName() + "线程进入methodB方法");
			System.out.println(Thread.currentThread().getName() + "线程退出methodB方法");
		}
	}
	
}
