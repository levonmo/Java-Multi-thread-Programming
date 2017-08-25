package otherObject2;

//使用不同的锁对象来解决同步方法无限等待问题
public class ObjectP {
	
	Object object1 = new Object();
	
	public void methodA(){
		synchronized (object1) {
			System.out.println(Thread.currentThread().getName() + "线程进入了methodA方法");
			boolean falg = true;
			while(falg){
				//这里是无限循环
			}
			System.out.println(Thread.currentThread().getName() + "线程退出了methodA方法");
		}
	}
	
	Object object2 = new Object();
	
	public void methodB(){
		synchronized (object2) {
			System.out.println(Thread.currentThread().getName() + "线程进入了方法B");
			System.out.println(Thread.currentThread().getName() + "线程退出了方法B");
		}
	}
}
