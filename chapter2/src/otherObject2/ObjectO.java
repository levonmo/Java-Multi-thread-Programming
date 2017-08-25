package otherObject2;

//同步synchronized方法无限等待与解决
public class ObjectO {
	
	synchronized public void methodA(){
		System.out.println("方法A开始" + "当前的线程是" + Thread.currentThread().getName());
		boolean falg = true;
		while(falg){
			//这里是无限循环的
		}
		System.out.println("方法A结束" + "当前线程是" + Thread.currentThread().getName());
	}
	
	synchronized public void methodB(){
		System.out.println("方法B开始" + "当前的线程是" + Thread.currentThread().getName());
		System.out.println("方法B结束" + "当前的线程是" + Thread.currentThread().getName());
	}
	
}
