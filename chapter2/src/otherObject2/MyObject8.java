package otherObject2;

//将任意对象作为对象监视器，对象监视器必须是同一个对象
public class MyObject8 {

	public void methodA(){
		String anything = new String();//在方法内部定义的就是私有变量，没调用方法一次都会新建一个新的对象出来，把这行代码移上上面看一下效果
		synchronized (anything) {
			try {
				System.out.println(Thread.currentThread().getName() + "线程进入" + "当前时间是" + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + "线程退出" + "当前时间是" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
