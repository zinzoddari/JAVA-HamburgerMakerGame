package JFood;

import javax.swing.ImageIcon;

public class Letters extends Food 
{
	public Letters() 
	{
		this.imgPath="Image/LETTERS.png";
		this.name = "�����";
		this.num = 6;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
