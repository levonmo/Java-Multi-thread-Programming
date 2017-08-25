package otherObject2;

import java.util.ArrayList;
import java.util.List;

//多个线程调用同一个方法是随机的
public class ObjectA {
	
	private List list = new ArrayList();
	
	synchronized public void add(String username){
		System.out.println("当前线程的名字" + Thread.currentThread().getName() + "执行了add方法");
		System.out.println("当前线程的名字" + Thread.currentThread().getName() + "离开的add方法");
	}
	
	synchronized public int getSize(){
		System.out.println("当前线程的名字" + Thread.currentThread().getName() + "执行了getSize方法");
		int sizeValue = list.size();
		System.out.println("当前线程的名字" + Thread.currentThread().getName() + "退出了getSize方法");
		return sizeValue;
	}

}
