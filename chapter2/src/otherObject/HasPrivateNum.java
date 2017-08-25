package otherObject;

//实例变量的非线程安全
public class HasPrivateNum {
	
	private int i = 0;
	
	//加上该关键字就可以实现线程安全了，去掉synchronized看看效果
	synchronized public void addUsername(String username) {
		try {
			if (username.equals("a")) {
				i = 50;
				System.out.println(username + "输出" + i);
				Thread.sleep(1000);//让线程在这睡一会，造成数据的出错
				System.out.println(username + "输出" + i);
			} else {
				 i = 100;
				 System.out.println(username + "输出" + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
