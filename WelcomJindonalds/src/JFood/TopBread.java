package JFood;

import javax.swing.ImageIcon;

public class TopBread extends Food 
{
	public TopBread() 
	{
		this.imgPath="Image/TOPBREAD.png";
		this.name = "À­»§";
		this.num = 7;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
