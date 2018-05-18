import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {


	public void insert(Member mem) {
		// JDBC 사용하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		// 1. 드라이버 로딩
		try { //try에는 예외가 걸릴 것 같은 것을 메소드를 작성.
			  //catch에는 예외발생시 진행 할 것
			Class.forName("oracle.jdbc.driver.OracleDriver"); // class Class 임.. 스테틱으로 선언되어있어서 객체생성 안해도됨.
			//2. 커넥션하기 //데이터베이스와 연결
			con = DriverManager.getConnection(url, user, password);	
			//3. SQL 문장 준비하기.
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mem.getName());
			psmt.setInt(2, mem.getAge());
			psmt.setString(3, mem.getMemNum());
			psmt.setString(4, mem.getTel());
			//4. 실행하기
			int num = psmt.executeUpdate(); // 반환이 int 형으로 한 번 실행했을 때 몇 번이나 해당 문구들이 실행한지 돌려줌.
			System.out.println(num);
			
			//5. 작업이 끝났을 때 연결을 끊어줘야함. 실행한 역순으로.
			psmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 실행 중 문제가 발생.");
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}						
		}
		
	}

	public Member selectOne(String memNum) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Member m = null;
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			con = DriverManager.getConnection(url, user, password);	
			String sql = "SELECT * FROM MEMBER WHERE MEMNUM = ?"; // ? <- 이 값을 우리가 넘겨온 매개변수로 쓸 것임.
			psmt = con.prepareStatement(sql);
			psmt.setString(1,memNum);           // sql 문장에 조건절을 달아서 특정 멤버넘버만 가져오겠다고 선언함.
			rs = psmt.executeQuery();         // Select 구문은 해당 구문으로 실행시켜야함
			//4. ResultSet 객체에서 데이터 꺼내오기   <- Select 구문 때문에 <- 테이블 구조로 데이터가 들어있음. rs에;
			rs.next();
			String name = rs.getString(1);  // 여기서 말하는 1번은 테이블 구조. 1.name 2.age 3.memnum 4.tel
			int age = rs.getInt(2);
			String memnum2 = rs.getString(3);
			String tel = rs.getString(4);		
			m = new Member(name,age,memnum2,tel);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 실행 중 문제가 발생.");
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(psmt!=null) psmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}						
		}		
		return m;
	}
	
	public void Delete(String Memnum) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		// 1. 드라이버 로딩
		try { //try에는 예외가 걸릴 것 같은 것을 메소드를 작성.
			  //catch에는 예외발생시 진행 할 것
			Class.forName("oracle.jdbc.driver.OracleDriver"); // class Class 임.. 스테틱으로 선언되어있어서 객체생성 안해도됨.
			//2. 커넥션하기 //데이터베이스와 연결
			con = DriverManager.getConnection(url, user, password);	
			//3. SQL 문장 준비하기.
			String sql = "Delete MEMBER WHERE MEMNUM = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Memnum);
			//4. 실행하기
			int num = psmt.executeUpdate(); // 반환이 int 형으로 한 번 실행했을 때 몇 번이나 해당 문구들이 실행한지 돌려줌.
			System.out.println(num);
			
			//5. 작업이 끝났을 때 연결을 끊어줘야함. 실행한 역순으로.
			//psmt.close();
			//con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 실행 중 문제가 발생.");
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}

		

		
		
		
	}
	
	
	public void Update(String name, int age, String tel, String memNum) {	// JDBC 사용하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		// 1. 드라이버 로딩
		try { //try에는 예외가 걸릴 것 같은 것을 메소드를 작성.
			  //catch에는 예외발생시 진행 할 것
			Class.forName("oracle.jdbc.driver.OracleDriver"); // class Class 임.. 스테틱으로 선언되어있어서 객체생성 안해도됨.
			//2. 커넥션하기 //데이터베이스와 연결
			con = DriverManager.getConnection(url, user, password);	
			//3. SQL 문장 준비하기.
			String sql = "UPDATE MEMBER SET NAME = ?, AGE = ?, TEL =? WHERE MEMNUM = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, age);
			psmt.setString(3, tel);
			psmt.setString(4, memNum);
			//4. 실행하기
			int num = psmt.executeUpdate(); // 반환이 int 형으로 한 번 실행했을 때 몇 번이나 해당 문구들이 실행한지 돌려줌.
			System.out.println(num);
			
			//5. 작업이 끝났을 때 연결을 끊어줘야함. 실행한 역순으로.
			psmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 실행 중 문제가 발생.");
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}

		
	}

	

}
