package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jjcompoent.JJButton;
import jjcompoent.JJLabel;
import jjcompoent.JJPasswordField;
import jjcompoent.JJTextField;

public class JoinPanel extends JFrame
{
	JJLabel labId, labPw, labName;
	public JJTextField tfId;
	public JJTextField tfName;
	public JJPasswordField tfPw;	
	public JJButton btnJoin;
	String pw;
	public JoinPanel() 
	{
		setLayout(null);
		
		JPanel panel = new JPanel();
		joinPan(panel);
		
		add(panel);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int sw = d.width;
		int sh = d.height;
		
		int w = 300;
		int h = 315;
		
		int x = (int)(0.5*(sw-w));
		int y = (sh-h)/2;
		
		setTitle("회원가입");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(x, y, w, h);
		setVisible(false);
	}
	
	//Default는 같은 패키지에서만 접근 가능
	//다른 패키지에서 사용하기 위해서 get/set 설정
	public JJLabel getLabId() 
	{
		return labId;
	}

	public void setLabId(JJLabel labId) 
	{
		this.labId = labId;
	}

	public JJLabel getLabPw() 
	{
		return labPw;
	}

	public void setLabPw(JJLabel labPw) 
	{
		this.labPw = labPw;
	}

	public JJLabel getLabName() 
	{
		return labName;
	}

	public void setLabName(JJLabel labName) 
	{
		this.labName = labName;
	}

	public JJTextField getTfId() 
	{
		return tfId;
	}

	public void setTfId(JJTextField tfId) 
	{
		this.tfId = tfId;
	}

	public JJTextField getTfName() 
	{
		return tfName;
	}

	public void setTfName(JJTextField tfName) 
	{
		this.tfName = tfName;
	}

	public JJPasswordField getTfPw() 
	{
		return tfPw;
	}

	public void setTfPw(JJPasswordField tfPw) 
	{
		this.tfPw = tfPw;
	}

	public String getPw() 
	{
		return pw;
	}

	public void setPw(String pw) 
	{
		this.pw = pw;
	}

	public void joinPan(JPanel panel)
	{
		labId = new JJLabel(this, 60, 20, 65, 50, "아이디 : ");
		tfId = new JJTextField(this, 120, 20, 115, 50, "");
		
		labPw = new JJLabel(this, 80, 20, 52, 100, "비밀번호 : ");
		tfPw = new JJPasswordField(this, 120, 20, 115, 100);
		pw=String.copyValueOf(tfPw.getPassword());
		
		labName = new JJLabel(this, 60, 20, 78, 150, "이름 : ");
		tfName = new JJTextField(this, 120, 20, 115, 150, "");
		
		btnJoin = new JJButton(this, 185, 25, 50, 200, "회원가입");
	}
}
