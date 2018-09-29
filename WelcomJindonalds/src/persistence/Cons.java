package persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cons 
{
	public static Connection getCon()
	{
		Connection con = null;
		try  
		{
			//1.JDBC 드라이버 로딩을 먼저 해 준것
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			System.out.println("JDBC Driver Loading Success");
			
			//2. DB와 연결 (데이터베이스 url, user name, password)필요
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //localhost 대신 127.0.0.1도 가능
			String username = "scott";
			String password = "tiger";
			
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("DB Connection Loading Success");
		} 
		catch (ClassNotFoundException e) //CheckedException : 만약 패키지 안에 이런 클래스가 없을까봐 예외 처리
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
