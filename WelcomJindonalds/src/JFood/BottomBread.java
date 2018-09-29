package JFood;

import javax.swing.ImageIcon;

public class BottomBread extends Food 
{ //Food를 상속 받았기 때문에 음식 재료들이 이러한 변수를 가질 수 있는 것
	public BottomBread() 
	{	
		this.imgPath="Image/BOTTOMBREAD.png";
		
		this.name = "아래빵";
		this.num = 1;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
