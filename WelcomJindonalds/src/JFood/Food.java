package JFood;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Food extends JLabel
{
	int x=350, y=30, w=200, h=30;
	
	int vary = 3;
	String name,imgPath;
	boolean power=true;
	ImageIcon icon;
	int num = 0;
	
	public Food() 
	{
		setSize(w, h);
		setLocation(x, y);
		setVisible(true);	
	}
	
	public void setCgImgSize(int imgW,int imgH) //�̹��� ũ�� �ٲٴ� �޼ҵ�
	{
		Image img=icon.getImage(); //icon�� �̹��� ��ü�� img�� ����
		Image reimg=img.getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH); //reimg�� img ��ü�� ������ ����
		ImageIcon ic=new ImageIcon(reimg); // ic�̸��� reimg�� ������ ��ü ����
		this.setIcon(ic); //���ο� ��ü ic�� ������ ����
		this.repaint(); //�̹��� ����(1)
		this.updateUI(); //�̹��� ����(2)
	}

	public int getX() 
	{
		return x;
	}
	public void setX(int x) 
	{
		this.x = x;
	}
	public int getY() 
	{
		return y;
	}
	public void setY(int y) 
	{
		this.y = y;
	}
	public int getW() 
	{
		return w;
	}
	public void setW(int w) 
	{
		this.w = w;
	}
	public int getH() 
	{
		return h;
	}
	public void setH(int h) 
	{
		this.h = h;
	}
	public int getVary() 
	{
		return vary;
	}
	public void setVary(int vary) 
	{
		this.vary = vary;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getImgPath() 
	{
		return imgPath;
	}
	public void setImgPath(String imgPath) 
	{
		this.imgPath = imgPath;
	}
	public boolean isPower() 
	{
		return power;
	}
	public void setPower(boolean power) 
	{
		this.power = power;
	}
	public int getNum() 
	{
		return num;
	}
	public void setNum(int num) 
	{
		this.num = num;
	}
}