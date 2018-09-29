package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import JFood.Food;
import JFood.Onion;
import game.util.GameUtill;
import jjcompoent.JJIconLabel;
import jjcompoent.JJLabel;

public class GameView extends JFrame 
{
	public final static int BOTTOMBREAD=1;
	public final static int PATTY=2;
	public final static int TOMATO=3; 
	public final static int CHEESE=4;
	public final static int ONION=5;
	public final static int LETTERS=6;
	public final static int TOPBREAD=7;

	int money=0;
	
	public ArrayList<JJIconLabel> imgIcons=new ArrayList<JJIconLabel>();
	
	Vector<Food> userfoods=new Vector<Food>();
	
	GamePeoPlePan gpp;
	
	public JJLabel moneyText=null;
	public JJLabel timeSecond=null;
	
	JJLabel npcCh=null;
	
	public JJLabel getNpcCh() 
	{
		return npcCh;
	}
	public void setNpcCh(JJLabel npcCh) 
	{
		this.npcCh = npcCh;
	}
	public JJLabel getMoneyText() 
	{
		return moneyText;
	}
	public ArrayList<JJIconLabel> getImgIcons() 
	{
		return imgIcons;
	}
	public void setImgIcons(ArrayList<JJIconLabel> imgIcons) 
	{
		this.imgIcons = imgIcons;
	}
	public void setMoney(int money) 
	{
		this.money = money;
	}
	public int getMoney() 
	{
		return money;
	}
	public Vector<Food> getUserfoods() 
	{
		return userfoods;
	}
	public void setUserfoods(Vector<Food> userfoods) 
	{
		this.userfoods = userfoods;
	}
	
	public static int keyLocation = 1;
	
	public GameView() 
	{
		setLayout(null);
			
		JPanel panel = new JPanel();
		gameViewPan(panel);
			
		moneyText=new JJLabel(this, 300, 50, 360, 10, "수입금 : 0원");
	    moneyText.setHorizontalAlignment(moneyText.RIGHT);
	    
	    timeSecond=new JJLabel(this, 300, 50, 360, 30, "");
	    timeSecond.setHorizontalAlignment(timeSecond.RIGHT);
	    
	    JJLabel JJpostion=new JJLabel(this, 100, 100, 150,120, "");
	    ImageIcon ic=new ImageIcon("Image/position.png"); 
	    JJpostion.setIcon(ic);
	    
		add(panel);
			
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int sw = d.width;
		int sh = d.height;
			
		int w = 700;
		int h = 515;
			
		int x = (int)(0.5*(sw-w));
		int y = (sh-h)/2;
			
		npcCh=new JJLabel(this, 200, 200, 10, 160,"");
			
		GameUtill.cgImagPan(npcCh);
		
		setTitle("진도날드 게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(x, y, w, h);
		setVisible(false);
	}

	public void gameViewPan(JPanel panel) 
	{	
		for (int i = 0; i < 7; i++) 
		{
			JJIconLabel lab = new JJIconLabel(this, 90, 90, 20+i*90, 370, "");
			lab.setIcon(new ImageIcon("Image/btn" + (i+1) + ".png"));
			imgIcons.add(lab);
		}
	}
	
	public void clearUserFood(Vector<Food> userFood)
	{
		for (int i = 0; i < userFood.size(); i++) 
		{
			userFood.get(i).setVisible(false);
		}
		userFood.clear(); //내가 선택한 재료들이 담긴 Vector 데이터 삭제
		this.repaint();
	}
}
