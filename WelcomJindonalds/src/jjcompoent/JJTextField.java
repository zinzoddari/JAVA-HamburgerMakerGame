package jjcompoent;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.JTextField;

public class JJTextField extends JTextField 
{
	public JJTextField(Container container,int width,int height,int x,int y,String msg) 
	{
		setText(msg);
		setLocation(x, y);
		setSize(width, height);
		container.add(this);
		setVisible(true);
	} 
}
