package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.JindoVO;
import jjcompoent.JJButton;
import jjcompoent.JJLabel;

public class GameMenu extends JFrame
{
	JindoVO loginUser;
	LoginPanel loginPan;
	public JJLabel labId, labMoney;
	public JJButton btnStart;
	public GameMenu(LoginPanel loginPan) 
	{
	
		this.loginPan = loginPan;
		setLayout(null);
		
		JPanel panel = new JPanel();
		gamePan(panel, loginUser, loginPan);
		
		add(panel);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int sw = d.width;
		int sh = d.height;
		
		int w = 300;
		int h = 158;
		
		int x = (int)(0.5*(sw-w));
		int y = (sh-h)/2;
		
		setTitle("메인메뉴");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(x, y, w, h);
	}

	public JJLabel getLabId() 
	{
		return labId;
	}

	public void setLabId(JJLabel labId) 
	{
		this.labId = labId;
	}

	public JJLabel getLabMoney() 
	{
		return labMoney;
	}

	public void setLabMoney(JJLabel labMoney) 
	{
		this.labMoney = labMoney;
	}

	public void setUser(JindoVO loginUser)
	{
		this.loginUser = loginUser;
	}
	
	public void gamePan(JPanel panel, JindoVO loginUser, LoginPanel loginPan) 
	{
		labId = new JJLabel(this, 100, 100, 90, -20, "");
		labId.setHorizontalAlignment(labId.CENTER);
		
		labMoney = new JJLabel(this, 100, 100, 90, 0, "");
		labMoney.setHorizontalAlignment(labId.CENTER);
		
		btnStart = new JJButton(this, 100, 30, 90, 70, "게임 시작");
		btnStart.setHorizontalAlignment(btnStart.CENTER);
	}
}
