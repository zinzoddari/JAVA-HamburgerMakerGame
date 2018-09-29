package JFood;

import javax.swing.ImageIcon;

public class Letters extends Food 
{
	public Letters() 
	{
		this.imgPath="Image/LETTERS.png";
		this.name = "¾ç»óÃß";
		this.num = 6;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
