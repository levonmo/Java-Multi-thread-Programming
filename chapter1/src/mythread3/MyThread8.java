package mythread3;

//yield()方法:放弃当前的cpu资源
public class MyThread8 extends Thread {
	
	@Override
	public void run() {
		long begin = System.currentTimeMillis();
		for(int i=0; i<500; i++){
			Thread.yield();//
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		long totalTime =end - begin;
		System.out.println("用时" + totalTime);
		
	}
	
}
