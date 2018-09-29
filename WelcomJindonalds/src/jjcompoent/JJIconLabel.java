package jjcompoent;

import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JJIconLabel extends JLabel 
{
	int num;
	String name;
	public JJIconLabel(Container container,int width,int height,int x,int y,String msg) 
	{
		setIcon(new ImageIcon("Image/button.png"));
		setText(msg);
		setBounds(x, y, width, height);
		container.add(this);
		setVisible(true);
	}

}
