import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("1.����  2.��ȸ  3.���� 4.���� >> ");
		Member mem;
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		
		if(choice == 1)
		{	
			System.out.print("�̸� >> ");
			String name = s.next();
			System.out.print("���� >> ");
			int age = s.nextInt();
			System.out.print("memNum >> ");
			String memNum = s.next();
			System.out.print("��ȭ��ȣ >> ");
			String tel = s.next();
			mem = new Member(name,age,memNum,tel); // DTO ��, ������ ���常 �ϴ� Ŭ����
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);
		}
		else if(choice == 2)
		{
			System.out.print("memNum >> ");
			String memNum = s.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.selectOne(memNum);
			System.out.println("�̸�/����/����ȣ/��ȭ��ȣ");
			System.out.println(m.getName()+"/"+m.getAge()+"/"+m.getMemNum()+"/"+m.getTel());
		
		}else if(choice == 3) {
			System.out.print("memNum >> ");
			String memNum = s.next();
		MemberDAO dao = new MemberDAO();
		Member m = dao.Delete(memNum);
		System.out.println(memNum+"�� �����Ǿ����ϴ�");
		}
	}
	
}
