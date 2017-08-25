package otherObject2;

//设计List集合只有一个元素的
public class ObjectC {
	public ObjectB addServiceMethod(ObjectB list,String data){
		try {
			synchronized (list) {
				if(list.getSize() < 1){
					Thread.sleep(2000);//模拟从远程花费2秒取回数据
					list.add(data);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
