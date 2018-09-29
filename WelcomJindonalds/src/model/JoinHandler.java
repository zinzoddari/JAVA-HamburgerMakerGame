package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.JindoVO;
import persistence.JindoDAO;
import view.JoinPanel;
import view.LoginPanel;

public class JoinHandler implements ActionListener
{
	LoginPanel LoginPanel;
	JoinPanel joinPanel;
	JindoDAO dao;
	String pw;
	public JoinHandler(LoginPanel LoginPanel,JoinPanel joinPanel, JindoDAO dao) 
	{
		this.LoginPanel = LoginPanel;
		this.joinPanel=joinPanel;
		this.dao = dao;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		joinPanel.setVisible(true);
		LoginPanel.setVisible(false);
	}
}
