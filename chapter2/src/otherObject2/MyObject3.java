package otherObject2;

//同步代码块间的同步性
public class MyObject3 {

	//同步代码块
	public void methodA(){
		try {
			synchronized (this) {
				System.out.println("同步代码块开始" + "由线程" + Thread.currentThread().getName() + "执行");
				Thread.sleep(3000);
				System.out.println("同步代码块结束" + "由线程" + Thread.currentThread().getName() + "执行");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//同步代码块，没有睡眠
	public void methodB(){
		synchronized (this) {
			System.out.println("同步代码块开始" + "由线程" + Thread.currentThread().getName() + "执行");
			System.out.println("同步代码块结束" + "由线程" + Thread.currentThread().getName() + "执行");
		}
	}
	
}
