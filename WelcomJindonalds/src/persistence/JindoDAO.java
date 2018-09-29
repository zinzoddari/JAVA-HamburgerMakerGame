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
	
	/*public List<JindoVO> rankCheck() ------ 시간 부족으로 구현 X
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
				JOptionPane.showMessageDialog(LoginPanel, "아이디나 비밀번호를 확인 해 주세요");
			}
			else
			{
				System.out.println("로그인성공");
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
	            System.out.println("아이디가 없습니다.");
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
	               
	               JOptionPane.showMessageDialog(joinPanel, "회원가입을 축하합니다."); /**/
	               
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
	            JOptionPane.showMessageDialog(joinPanel, "아이디 중복입니다.");
	            
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
