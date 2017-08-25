package other.synchronizedObject;

//suspend与resume方法的缺点--独占  
public class SynchronizedObject2 {

	synchronized public void printString(){
		System.out.println("printString方法开始执行");
		if(Thread.currentThread().getName().equals("a")){
			Thread.currentThread().suspend();//该线程暂停
			System.out.println("名称为a的线程永远suspend了");
		}
		System.out.println("printString方法结束");
	}
	
}
