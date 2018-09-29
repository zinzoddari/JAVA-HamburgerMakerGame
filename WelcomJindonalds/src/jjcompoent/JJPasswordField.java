package jjcompoent;

import java.awt.Container;

import javax.swing.JPasswordField;

public class JJPasswordField extends JPasswordField 
{
	public JJPasswordField(Container container,int width,int height,int x,int y) 
	{
		setBounds(x, y, width, height);
		container.add(this);
		setVisible(true);
	} 
}
