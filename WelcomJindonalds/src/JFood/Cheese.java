package JFood;

import javax.swing.ImageIcon;

public class Cheese extends Food 
{
	public Cheese() 
	{
		this.imgPath="Image/CHEESE.png";
		this.name = "ДЎБо";
		this.num = 4;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
