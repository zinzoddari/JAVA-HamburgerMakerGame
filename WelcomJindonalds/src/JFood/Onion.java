package JFood;

import javax.swing.ImageIcon;

public class Onion extends Food 
{
	public Onion() 
	{
		this.imgPath="Image/ONION.png";
		this.name = "¾çÆÄ";
		this.num = 5;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
