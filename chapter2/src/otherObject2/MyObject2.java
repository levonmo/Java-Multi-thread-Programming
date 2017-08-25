package otherObject2;

//同步代码块，一半同步一半异步
public class MyObject2 {

	public void method(){
		for(int i=0; i<10; i++){
			System.out.println("线程" + Thread.currentThread().getName() + "异步输出" + i);
		}
		synchronized (this) {
			for(int i=0; i<10; i++){
				System.out.println("线程" + Thread.currentThread().getName() + "同步输出" + i);
			}
		}
	}
	
}
