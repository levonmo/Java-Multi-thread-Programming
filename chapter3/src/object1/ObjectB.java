package object1;

import java.util.ArrayList;
import java.util.List;

//使用wait和notify实现前面的  集合元素等于5的时候一个线程退出
public class ObjectB {
	
	private List list = new ArrayList();
	
	public void add(){
		list.add("莫文龙");
	}
	
	public int getSize(){
		return list.size();
	}
}
