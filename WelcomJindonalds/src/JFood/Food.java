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
	
	public void setCgImgSize(int imgW,int imgH) //이미지 크기 바꾸는 메소드
	{
		Image img=icon.getImage(); //icon의 이미지 객체를 img에 대입
		Image reimg=img.getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH); //reimg에 img 객체의 정보를 대입
		ImageIcon ic=new ImageIcon(reimg); // ic이름에 reimg의 정보로 객체 생성
		this.setIcon(ic); //새로운 객체 ic로 아이콘 설정
		this.repaint(); //이미지 갱신(1)
		this.updateUI(); //이미지 갱신(2)
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