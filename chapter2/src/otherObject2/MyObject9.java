package otherObject2;

//this对象与非this对象
public class MyObject9 {

	private String anything = new String();
	
	//A方法是同步方法
	synchronized public void methodA(){
		System.out.println(Thread.currentThread().getName() + "线程进入");
		System.out.println(Thread.currentThread().getName() + "线程退出");
	}
	
	
	//方法B是非this对象的同步代码块
	public void methodB(){
		synchronized (anything) {
			System.out.println(Thread.currentThread().getName() + "线程进入");
			System.out.println(Thread.currentThread().getName() + "线程退出");
		}
	}
	
}
