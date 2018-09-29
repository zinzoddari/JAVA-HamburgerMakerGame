package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.JindoVO;
import domain.MemberVO;
import view.GameMenu;
import view.JoinPanel;
import view.LoginPanel;

public class JindoDAO 
{
	LoginPanel LoginPanel;
	JoinPanel joinPanel;
	GameMenu gameMenu;
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
	
	/*public List<JindoVO> rankCheck() ------ �ð� �������� ���� X
	  {
	      Connection con = getCon();
	      
	      List<JindoVO> rankList = new ArrayList<JindoVO>();
	      
	      String sql = "SELECT * FROM (SELECT * FROM MEMBER) WHERE ROWNUM <=3 ORDER BY MONEY DESC";
	      try 
	      {
	         PreparedStatement pstmt = con.prepareStatement(sql);
	         
	         ResultSet rs = pstmt.executeQuery();
	         while(rs.next())
	         {
	            JindoVO vo = new JindoVO();
	            
	            vo.setId(rs.getString("id"));
	            vo.setMoney(rs.getString("money"));
	            
	            rankList.add(vo);
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } 
	      catch (SQLException e) 
	      {
	         e.printStackTrace();
	      }
	      return rankList;
	   }*/
	   
	public MemberVO login(JindoVO vo, LoginPanel LoginPanel, GameMenu gameMenu)
	{
		MemberVO memberVO=new MemberVO();
		Connection con = getCon();
		String sql = "SELECT * FROM member WHERE id = ? and pw = ?";
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next())
			{
				this.LoginPanel = LoginPanel;
				JOptionPane.showMessageDialog(LoginPanel, "���̵� ��й�ȣ�� Ȯ�� �� �ּ���");
			}
			else
			{
				System.out.println("�α��μ���");
				this.gameMenu = gameMenu;
				memberVO.setId(rs.getString("id"));
				memberVO.setMoney(rs.getInt("money"));
				memberVO.setName(rs.getString("name"));
				memberVO.setNo(rs.getInt("no"));
				memberVO.setPw(rs.getString("pw"));
				
				gameMenu.setVisible(true);
			}
			rs.close();
			pstmt.close();
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return memberVO;
	}
	
	public void joinCheck(JoinPanel joinPanel, JindoVO vo, LoginPanel loginPanel) /**/
	{
	      Connection con = getCon();
	      
	      String sql = "SELECT * FROM member WHERE id = ?";
	      try 
	      {
	         PreparedStatement pstmt = con.prepareStatement(sql);
	         
	         pstmt.setString(1, vo.getId());
	         
	         ResultSet rs = pstmt.executeQuery();
	         
	         if(!rs.next())
	         {
	            System.out.println("���̵� �����ϴ�.");
	            String sql1 = "INSERT INTO MEMBER "
	                     + "VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, 0)";
	            
	            try 
	            {
	               PreparedStatement pstmt1 = con.prepareStatement(sql1);
	               
	               pstmt1.setString(1, vo.getId());
	               pstmt1.setString(2, vo.getPw());
	               pstmt1.setString(3, vo.getName());
	               
	               pstmt1.executeQuery();
	               
	               pstmt1.close();
	               
	               JOptionPane.showMessageDialog(joinPanel, "ȸ�������� �����մϴ�."); /**/
	               
	               joinPanel.setVisible(false); /**/
	               loginPanel.setVisible(true); /**/
	            } 
	            catch (SQLException e) 
	            {
	               e.printStackTrace();
	            }
	         }
	         else
	         {
	            this.joinPanel = joinPanel;
	            JOptionPane.showMessageDialog(joinPanel, "���̵� �ߺ��Դϴ�.");
	            
	            joinPanel.tfId.setText("");
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } 
	      catch (SQLException e) 
	      {
	         e.printStackTrace();
	      }
	   }
	
}
