public class Member {
	private String name;
	private int age;
	private String memNum;
	private String tel;
	public Member(String name, int age, String memNum, String tel) {
		this.name = name;
		this.age = age;
		this.memNum = memNum;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getMemNum() {
		return memNum;
	}
	public String getTel() {
		return tel;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	

}
