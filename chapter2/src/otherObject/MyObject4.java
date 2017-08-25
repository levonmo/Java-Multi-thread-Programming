package otherObject;

//可重入锁的父子类继承
public class MyObject4 {
	public int i = 100;
	
	synchronized public void methodFather(){
		i--;
		System.out.println("methodFather  i=" + i);
	}
}
