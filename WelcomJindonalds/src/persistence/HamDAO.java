package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.HamVO;
import domain.HambergerVO;

public class HamDAO 
{
	Connection con = null;
	
	public List<HamVO> hamAllList()
	{
		con = Cons.getCon(); //이미 static으로 정의가 되어있기 때문에(메모리가 올라가있는 상태) new로 객체를 생성하지 않고도 사용이 가능한 것
		
		List<HamVO> hamAllList = new ArrayList<HamVO>();
		String sql = "SELECT * FROM hamview";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				HamVO vo = new HamVO();
				
				vo.setRecipeNum(rs.getInt("recipenum"));
				vo.setFoodNum(rs.getInt("foodnum"));
				vo.setHamNum(rs.getInt("hamNum"));
				vo.setIndexNum(rs.getInt("indexNum"));
				vo.setFoodName(rs.getString("foodname"));
				vo.setHamPrice(rs.getString("hamprice"));
				
				hamAllList.add(vo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(rs != null)
			{
				try 
				{
					rs.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
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
		
		return hamAllList;
	}
	
	public List<HamVO> hamSelect(int num)
	{
		con = Cons.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<HamVO> list = new ArrayList<HamVO>();
		
		String sql = "SELECT * FROM hamview WHERE hamnum = ? ORDER BY indexnum asc";
		try 
		{
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				HamVO vo = new HamVO();
				
				vo.setRecipeNum(rs.getInt("recipenum"));
				vo.setFoodNum(rs.getInt("foodnum"));
				vo.setHamNum(rs.getInt("hamnum"));
				vo.setIndexNum(rs.getInt("indexNum"));
				vo.setFoodName(rs.getString("foodname"));
				vo.setHamPrice(rs.getString("hamprice"));
				
				list.add(vo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(rs != null)
			{
				try 
				{
					rs.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
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
		return list;
	}
	public List<HambergerVO> hamBegerAllList()

	{
		con = Cons.getCon(); //이미 static으로 정의가 되어있기 때문에(메모리가 올라가있는 상태) new로 객체를 생성하지 않고도 사용이 가능한 것
		
		List<HambergerVO> hamAllList = new ArrayList<HambergerVO>();
		String sql = "SELECT * FROM HAMBURGER";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				HambergerVO vo = new HambergerVO();
				
				
				vo.setHamNum(rs.getInt("hamNum"));
				vo.setHamName(rs.getString("hamName"));
				vo.setHamPrice(rs.getString("hamprice"));
				
				hamAllList.add(vo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(rs != null)
			{
				try 
				{
					rs.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
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
		
		return hamAllList;
	}
	
	public HambergerVO hamBergerOne(int num)
	{
		con = Cons.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		HambergerVO vo=new HambergerVO();
		
		String sql = "SELECT * FROM HAMBURGER WHERE hamnum = ?";
		try 
		{
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			rs.next();
			vo.setHamNum(rs.getInt("hamnum"));
			vo.setHamName(rs.getString("hamName"));
			vo.setHamPrice(rs.getString("hamprice"));
				
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(rs != null)
			{
				try 
				{
					rs.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
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
		
		return vo;
	}
}
