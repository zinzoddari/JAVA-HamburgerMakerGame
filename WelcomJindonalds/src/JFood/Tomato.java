package JFood;

import javax.swing.ImageIcon;

public class Tomato extends Food
{
	public Tomato() 
	{
		this.imgPath="Image/TOMATO.png";
		this.name = "≈‰∏∂≈‰";
		this.num = 3;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
