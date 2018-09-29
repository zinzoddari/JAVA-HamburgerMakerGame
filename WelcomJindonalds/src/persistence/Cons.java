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
			//1.JDBC ����̹� �ε��� ���� �� �ذ�
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			System.out.println("JDBC Driver Loading Success");
			
			//2. DB�� ���� (�����ͺ��̽� url, user name, password)�ʿ�
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //localhost ��� 127.0.0.1�� ����
			String username = "scott";
			String password = "tiger";
			
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("DB Connection Loading Success");
		} 
		catch (ClassNotFoundException e) //CheckedException : ���� ��Ű�� �ȿ� �̷� Ŭ������ ������� ���� ó��
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
