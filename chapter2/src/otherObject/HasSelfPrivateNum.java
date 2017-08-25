package otherObject;

//方法内部声明一个变量，是不存在"非线程安全"问题的
public class HasSelfPrivateNum {

	public void addI(String username){
		//这个变量是在方法里面的，每个对象都是独一无二的拥有，所以不存在"非线程安全"问题
		int num = 0;
		if(username.equals("a")){
			num = 50;
			System.out.println("a你好，num的值是" + num);
		} else{
			num = 100;
			System.out.println("other你好，num的值是" + num);
		}
	}
}
