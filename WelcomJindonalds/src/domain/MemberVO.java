package domain;

public class MemberVO //회원 정보
{
	int no, money;
	String id, pw, name;
	public int getNo() 
	{
		return no;
	}
	public void setNo(int no) 
	{
		this.no = no;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getPw() 
	{
		return pw;
	}
	public void setPw(String pw) 
	{
		this.pw = pw;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getMoney() 
	{
		return money;
	}
	public void setMoney(int money) 
	{
		this.money = money;
	}
}
