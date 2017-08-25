package object1;

import java.util.ArrayList;
import java.util.List;

//不使用等待/通知机制实现线程间的通信
public class ObjectA {
	
	volatile private List list = new ArrayList();
	
	public void add(){
		list.add("莫文龙");
	}
	
	public int size(){
		return list.size();
	}
	
}
