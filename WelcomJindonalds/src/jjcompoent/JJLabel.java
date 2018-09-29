package jjcompoent;

import java.awt.Container;

import javax.swing.JLabel;

public class JJLabel extends JLabel 
{
	public JJLabel(Container container,int width,int height,int x,int y,String msg) 
	{
		setText(msg);
		setBounds(x, y, width, height);
		container.add(this);
		setVisible(true);
	} 
}
