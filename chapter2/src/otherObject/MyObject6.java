package otherObject;

//出现异常，锁自动释放
public class MyObject6 {

	synchronized public void method1(){
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("a线程开始抛异常");
			System.out.println("抛出异常的时间是" + System.currentTimeMillis());
			int i = 0/0;//抛出异常
			System.out.println("抛出异常了，b线程执行了，这一段字应该看不到了");
		} else {
			System.out.println("线程" + Thread.currentThread().getName() + "进入了,当前时间是" + System.currentTimeMillis());
		}
	}
	
	
}
