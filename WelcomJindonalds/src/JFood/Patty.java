package JFood;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Patty extends Food
{
	public Patty() 
	{	
		this.imgPath="Image/PATTY.png";
		this.name = "��Ƽ";
		this.num = 2;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
