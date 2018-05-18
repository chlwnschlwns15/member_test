import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {


	public void insert(Member mem) {
		// JDBC ����ϱ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		// 1. ����̹� �ε�
		try { //try���� ���ܰ� �ɸ� �� ���� ���� �޼ҵ带 �ۼ�.
			  //catch���� ���ܹ߻��� ���� �� ��
			Class.forName("oracle.jdbc.driver.OracleDriver"); // class Class ��.. ����ƽ���� ����Ǿ��־ ��ü���� ���ص���.
			//2. Ŀ�ؼ��ϱ� //�����ͺ��̽��� ����
			con = DriverManager.getConnection(url, user, password);	
			//3. SQL ���� �غ��ϱ�.
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mem.getName());
			psmt.setInt(2, mem.getAge());
			psmt.setString(3, mem.getMemNum());
			psmt.setString(4, mem.getTel());
			//4. �����ϱ�
			int num = psmt.executeUpdate(); // ��ȯ�� int ������ �� �� �������� �� �� ���̳� �ش� �������� �������� ������.
			System.out.println(num);
			
			//5. �۾��� ������ �� ������ ���������. ������ ��������.
			psmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL ���� �� ������ �߻�.");
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
			String sql = "SELECT * FROM MEMBER WHERE MEMNUM = ?"; // ? <- �� ���� �츮�� �Ѱܿ� �Ű������� �� ����.
			psmt = con.prepareStatement(sql);
			psmt.setString(1,memNum);           // sql ���忡 �������� �޾Ƽ� Ư�� ����ѹ��� �������ڴٰ� ������.
			rs = psmt.executeQuery();         // Select ������ �ش� �������� ������Ѿ���
			//4. ResultSet ��ü���� ������ ��������   <- Select ���� ������ <- ���̺� ������ �����Ͱ� �������. rs��;
			rs.next();
			String name = rs.getString(1);  // ���⼭ ���ϴ� 1���� ���̺� ����. 1.name 2.age 3.memnum 4.tel
			int age = rs.getInt(2);
			String memnum2 = rs.getString(3);
			String tel = rs.getString(4);		
			m = new Member(name,age,memnum2,tel);
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL ���� �� ������ �߻�.");
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
	
	public Member Delete(String Memnum) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		// 1. ����̹� �ε�
		try { //try���� ���ܰ� �ɸ� �� ���� ���� �޼ҵ带 �ۼ�.
			  //catch���� ���ܹ߻��� ���� �� ��
			Class.forName("oracle.jdbc.driver.OracleDriver"); // class Class ��.. ����ƽ���� ����Ǿ��־ ��ü���� ���ص���.
			//2. Ŀ�ؼ��ϱ� //�����ͺ��̽��� ����
			con = DriverManager.getConnection(url, user, password);	
			//3. SQL ���� �غ��ϱ�.
			String sql = "Delete MEMBER WHERE MEMNUM = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Memnum);
			//4. �����ϱ�
			int num = psmt.executeUpdate(); // ��ȯ�� int ������ �� �� �������� �� �� ���̳� �ش� �������� �������� ������.
			System.out.println(num);
			
			//5. �۾��� ������ �� ������ ���������. ������ ��������.
			//psmt.close();
			//con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL ���� �� ������ �߻�.");
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

		

		return m;
		
		
	}
	
	
	public Member Update(String name, int age, String tel, String memNum) {	// JDBC ����ϱ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		// 1. ����̹� �ε�
		try { //try���� ���ܰ� �ɸ� �� ���� ���� �޼ҵ带 �ۼ�.
			  //catch���� ���ܹ߻��� ���� �� ��
			Class.forName("oracle.jdbc.driver.OracleDriver"); // class Class ��.. ����ƽ���� ����Ǿ��־ ��ü���� ���ص���.
			//2. Ŀ�ؼ��ϱ� //�����ͺ��̽��� ����
			con = DriverManager.getConnection(url, user, password);	
			//3. SQL ���� �غ��ϱ�.
			String sql = "UPDATE MEMBER SET NAME = ?, AGE = ?, TEL =? WHERE MEMNUM = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, age);
			psmt.setString(3, tel);
			psmt.setString(4, memNum);
			//4. �����ϱ�
			int num = psmt.executeUpdate(); // ��ȯ�� int ������ �� �� �������� �� �� ���̳� �ش� �������� �������� ������.
			System.out.println(num);
			
			//5. �۾��� ������ �� ������ ���������. ������ ��������.
			psmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL ���� �� ������ �߻�.");
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

		return m;
	}

	
	

	

}
