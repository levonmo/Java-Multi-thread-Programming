package otherObject2;

import java.util.ArrayList;
import java.util.List;

//设计List集合只有一个元素
public class ObjectB {
	private List list = new ArrayList();
	
	synchronized public void add(String data){
		list.add(data);
	}
	
	synchronized public int getSize(){
		return list.size();
	}
}
