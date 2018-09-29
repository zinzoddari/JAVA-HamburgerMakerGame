package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberVO;

public class MemberDAO 
{
	 Connection con = null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	 
	public MemberDAO() 
	{
		con=Cons.getCon();
	}
	
	public void updateMember(MemberVO vo) //vo를 매개변수로 주면 알아서 변경이 된다.
	{
		String sql="UPDATE MEMBER SET id=?,pw=?,name=?,money=? where no=?";
		
		try 
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(3, vo.getName());
			pstmt.setString(2, vo.getPw());
			pstmt.setInt(4, vo.getMoney());
			pstmt.setInt(5, vo.getNo());
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(pstmt != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
