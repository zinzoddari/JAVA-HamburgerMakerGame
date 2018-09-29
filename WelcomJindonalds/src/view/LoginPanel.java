package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jjcompoent.JJButton;
import jjcompoent.JJLabel;
import jjcompoent.JJPasswordField;
import jjcompoent.JJTextField;

public class LoginPanel extends JFrame
{
	JJTextField tfID;
	JJPasswordField tfPW;
	public JJButton btnLogin;
	public JJButton btnJoin;
	JJLabel labID, labPW;
	String pw;
	
	public JJTextField getTfID() 
	{
		return tfID;
	}

	public void setTfID(JJTextField tfID)
	{
		this.tfID = tfID;
	}

	public JJPasswordField getTfPW() 
	{
		return tfPW;
	}

	public void setTfPW(JJPasswordField tfPW) 
	{
		this.tfPW = tfPW;
	}

	public LoginPanel() 
	{
		setLayout(null);
		
		JPanel panel = new JPanel();
		loginPan(panel);
		
		add(panel);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int sw = d.width;
		int sh = d.height;
		
		int w = 480;
		int h = 280;
		
		int x = (int)(0.5*(sw-w));
		int y = (sh-h)/2;
		
		setTitle("로그인");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(x, y, w, h);
		setVisible(true);
	}
	
	public void loginPan(JPanel panel)
	{
		labID = new JJLabel(this, 50, 25, 90, 60, "아이디 :");
		tfID = new JJTextField(this, 170, 25, 140, 60, "");
		
		labPW = new JJLabel(this, 70, 25, 77, 105, "비밀번호 :");
		tfPW = new JJPasswordField(this, 170, 25, 140, 105);
		
		btnLogin = new JJButton(this, 75, 70, 320, 60, "로그인");
		
		btnJoin = new JJButton(this, 316, 25, 80, 150, "아이디가 없으면? 회원가입");
	}
}
