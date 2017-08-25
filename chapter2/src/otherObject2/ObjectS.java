package otherObject2;


//¾²Ì¬µÄÄÚÖÃÀà
public class ObjectS {
	
	static private String username;
	static private String password;
	
	public static class PrivateClass{
		private String age;
		private String address;
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		public void printPublicProperty(){
			System.out.println(username + password);
		}
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		ObjectS.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		ObjectS.password = password;
	}
	

}
