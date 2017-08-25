package otherObject2;

//synchronizedc(this) 代码块是锁定当前对象的
public class MyObject4 {

	public void methodA(){
		synchronized (this) {
			System.out.println("异步方法执行" + Thread.currentThread().getName());
		}
		
	}
	
	public void methodB(){
		synchronized (this) {
			System.out.println("同步方法" + Thread.currentThread().getName());
			for(int i=0; i<1000; i++){
				System.out.println(i);
			}
		}
	}
	
}
