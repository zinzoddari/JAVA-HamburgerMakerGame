package JFood;

import javax.swing.ImageIcon;

public class BottomBread extends Food 
{ //Food�� ��� �޾ұ� ������ ���� ������ �̷��� ������ ���� �� �ִ� ��
	public BottomBread() 
	{	
		this.imgPath="Image/BOTTOMBREAD.png";
		
		this.name = "�Ʒ���";
		this.num = 1;
		this.icon=new ImageIcon(this.imgPath);
		setIcon(this.icon);
	}
}
