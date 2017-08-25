package otherObject;

//同步代码块:不同的线程同时对同一对象的同步代码块进行访问
public class MyObject9 {
	
	public void method(){
		synchronized(this){
			try {
				System.out.println("线程" + Thread.currentThread().getName() + "开始执行同步代码块");
				Thread.sleep(2000);
				System.out.println("线程" + Thread.currentThread().getName() + "结束执行同步代码块");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
