import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("1.가입  2.조회  3.삭제 4.수정 >> ");
		Member mem;
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		
		if(choice == 1)
		{	
			System.out.print("이름 >> ");
			String name = s.next();
			System.out.print("나이 >> ");
			int age = s.nextInt();
			System.out.print("memNum >> ");
			String memNum = s.next();
			System.out.print("전화번호 >> ");
			String tel = s.next();
			mem = new Member(name,age,memNum,tel); // DTO 모델, 데이터 저장만 하는 클래스
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);
		}
		else if(choice == 2)
		{
			System.out.print("memNum >> ");
			String memNum = s.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.selectOne(memNum);
			System.out.println("이름/나이/고객번호/전화번호");
			System.out.println(m.getName()+"/"+m.getAge()+"/"+m.getMemNum()+"/"+m.getTel());
		
		}else if(choice == 3) {
			System.out.print("memNum >> ");
			String memNum = s.next();
		MemberDAO dao = new MemberDAO();
		Member m = dao.Delete(memNum);
		System.out.println(memNum+"이 삭제되었습니다");
		
		
		}else if(choice == 4) {
			System.out.print("수정하고 싶은 memNum을 입력해주세요 >> ");
			String memNum = s.next();
			System.out.print("이름 >> ");
			String name = s.next();
			System.out.print("나이 >> ");
			int age = s.nextInt();
			
			System.out.print("전화번호 >> ");
			String tel = s.next();
			
			
		}
	}
	
}
