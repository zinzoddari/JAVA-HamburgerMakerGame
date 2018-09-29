package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;

import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import JFood.Food;
import controller.JindoController;
import domain.HamVO;
import game.util.GameUtill;
import persistence.HamDAO;

public class GameHamPreView extends Panel //�մ��� ���ϴ� �ܹ��Ű� �ߴ� â
{
	Vector<Food> comFoods=new Vector<Food>();
	
	int x=10,y=10,w=150,h=150;
	int price;
	
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	
	Panel pan;
	public GameHamPreView(JFrame frame) 
	{
		super(null);
		setVisible(true);
		frame.add(this);
		setBounds(x, y, w, h);
		GameUtill.randomSelectHamNum();
		preViewSeting(this, JindoController.selectHamNum, comFoods);
		
		repaint();
	}
	
	public Vector<Food> getComFoods() 
	{
		return comFoods;
	}
	
	public void setComFoods(Vector<Food> comFoods) 
	{
		this.comFoods = comFoods;
	}
	
	public void preViewSeting(Panel con,int select,Vector<Food> comFoods)
	{
		comFoods.clear(); //���͸� �����
		ArrayList<HamVO> comBurger=new ArrayList<HamVO>(); //���� �ܹ��� ������ ���� ����Ʈ
		HamDAO dao=new HamDAO();
		comBurger=(ArrayList<HamVO>)dao.hamSelect(select); //DB����
		
		for (int i = 0; i < comBurger.size(); i++) //�ܹ��� �̹��� �̸� ���
		{
			GameUtill.habergerImg(comBurger.get(i).getFoodNum(), con, comFoods);
			System.out.println(comFoods.get(i).getName());
			
			comFoods.get(i).setCgImgSize(100, 20);
			comFoods.get(i).setBounds(x, 100-(comFoods.size()*15),100,20);
		}
		
		setPrice(Integer.parseInt(comBurger.get(0).getHamPrice()));
		System.out.println("price:="+getPrice());
	}
	
	//������ - ������ �� ����� �ٽ� ����
	public void nextPreViewSeting(Panel con,int select,Vector<Food> comFoods)
	{
		for (int i = 0; i < comFoods.size(); i++) 
		{
			comFoods.get(i).setVisible(false);
		}	
		
		preViewSeting(con, select, comFoods);
	}
}
