package otherObject2;

//当其他线程执行x对象方法里面的synchronized(this)代码块的时候也是呈现同步的效效果
public class ObjectH {

	public void methodA(){
		synchronized (this) {
			try {
				System.out.println("进入当前的系统时间是" + System.currentTimeMillis() + "当前的线程是" + Thread.currentThread().getName());
				Thread.sleep(500);
				System.out.println("退出当前的系统时间是" + System.currentTimeMillis() + "当前的时间是" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
