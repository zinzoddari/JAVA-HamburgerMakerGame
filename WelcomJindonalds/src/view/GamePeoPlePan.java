package view;

import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePeoPlePan extends JLabel
{
	int x=5,y=150,w=200,h=200;
	
	public GamePeoPlePan(Frame frame) 
	{
		setVisible(true);
		frame.add(this);
		setBounds(x, y, w, h);
	}

}
