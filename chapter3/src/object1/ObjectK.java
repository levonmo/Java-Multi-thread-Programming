package object1;

//线程变量
public class ObjectK {
	
	public static ThreadLocal t1 = new ThreadLocal();
	
	public void test(){
		if (t1.get() == null) {
			System.out.println("从未放过值");
			t1.set("我的值");
		}
		System.out.println(t1.get());
	}
	
}
