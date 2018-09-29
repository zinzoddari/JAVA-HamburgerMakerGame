package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.JindoController;
import domain.JindoVO;
import game.util.GameWindowUtil;
import persistence.JindoDAO;
import view.GameMenu;
import view.LoginPanel;

public class LoginHandler implements ActionListener
{
	LoginPanel LoginPanel;
	JindoDAO dao;
	GameMenu gameMenu;
	public static boolean reflag=false;
	public LoginHandler(LoginPanel LoginPanel, JindoDAO dao, GameMenu gameMunu) 
	{
		this.LoginPanel = LoginPanel;
		this.dao = dao;
		this.gameMenu = gameMunu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{ 
		JindoVO vo = new JindoVO();
		
		vo.setId(LoginPanel.getTfID().getText());
		vo.setPw(String.copyValueOf(LoginPanel.getTfPW().getPassword()));
		
		System.out.println(vo.getPw());
		JindoController.memberInfo=dao.login(vo, LoginPanel, gameMenu);
		//memberInfo에 로그인 정보를 담음
		gameMenu.setUser(vo);
		gameMenu.getLabId().setText("ID : " + JindoController.memberInfo.getId());
		gameMenu.getLabMoney().setText("MONEY : " + JindoController.memberInfo.getMoney());
		
		LoginPanel.setVisible(false);
	}
}
