package jjcompoent;

import java.awt.Container;
import javax.swing.JButton;

public class JJButton extends JButton
{
	public JJButton(Container container,int width,int height,int x,int y,String msg) 
	{
		setText(msg);
		setBounds(x, y, width, height);
		container.add(this);
		setVisible(true);
	} 
}

