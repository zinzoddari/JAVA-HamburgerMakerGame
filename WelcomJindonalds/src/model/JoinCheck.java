package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.JindoVO;
import persistence.JindoDAO;
import view.JoinPanel;
import view.LoginPanel;

public class JoinCheck implements ActionListener
{

	JoinPanel joinPan;
	JindoDAO dao;
	LoginPanel loginPanel;
	public JoinCheck(JoinPanel joinPan, JindoDAO dao, LoginPanel loginPanel) 
	{
		this.joinPan = joinPan;
		this.dao = dao;
		this.loginPanel =loginPanel;
		System.out.println("»Æ¿Œ");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		JindoVO vo = new JindoVO();
		
		vo.setId(joinPan.tfId.getText());
		vo.setPw(String.copyValueOf(joinPan.tfPw.getPassword()));
		vo.setName(joinPan.tfName.getText());
		
		dao.joinCheck(joinPan, vo, loginPanel);
	}
}
