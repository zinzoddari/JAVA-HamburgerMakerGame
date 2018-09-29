package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jjcompoent.JJButton;
import jjcompoent.JJLabel;

public class GameEndView extends JFrame
{
	public JJLabel labMoneyStr, labMoney, labDefaultMoneyStr, labDefaultMoney, labAddMoneyStr, labAddMoney;
	public JJButton btnCheck;
	public String money = "0";
	public GameEndView() 
	{
		setLayout(null);
		
		JPanel panel = new JPanel();
		gameEndPan(panel);
		
		add(panel);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int sw = d.width;
		int sh = d.height;
		
		int w = 210;
		int h = 325;
		
		int x = (int)(0.5*(sw-w));
		int y = (sh-h)/2;
		
		setTitle("게임결과");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(x, y, w, h);
		setVisible(false);
	}
	
	public void gameEndPan(JPanel panel)
	{
		JJLabel labResult = new JJLabel(this, 300, 30, 33, 20, "====== 결과창 ======");
		
		labMoneyStr = new JJLabel(this, 100, 30, 46, 40, "수입금액");
		labMoneyStr.setHorizontalAlignment(labMoneyStr.CENTER);
		
		labMoney = new JJLabel(this, 100, 30, 46, 60, money + "원");
		labMoney.setHorizontalAlignment(labMoneyStr.CENTER);
		
		JJLabel labResult1 = new JJLabel(this, 300, 30, 33, 80, "==================");
		
		labDefaultMoneyStr = new JJLabel(this, 100, 30, 46, 100, "기존소지금액");
		labDefaultMoneyStr.setHorizontalAlignment(labMoneyStr.CENTER);
		
		labDefaultMoney = new JJLabel(this, 100, 30, 46, 120, money + "원");
		labDefaultMoney.setHorizontalAlignment(labMoneyStr.CENTER);
		
		JJLabel labResult2 = new JJLabel(this, 300, 30, 33, 140, "==================");
		
		labAddMoneyStr = new JJLabel(this, 100, 30, 46, 160, "총 보유 금액");
		labAddMoneyStr.setHorizontalAlignment(labMoneyStr.CENTER);
		
		labAddMoney = new JJLabel(this, 100, 30, 46, 180, money + "원");
		labAddMoney.setHorizontalAlignment(labMoneyStr.CENTER);
		
		JJLabel labResult3 = new JJLabel(this, 300, 30, 33, 200, "==================");
		
		btnCheck = new JJButton(this, 120, 30, 36, 235, "확인");
	}
	
	public static void main(String[] args) 
	{
	}
}
