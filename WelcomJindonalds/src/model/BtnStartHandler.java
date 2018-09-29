package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MC.Thread.GameRepaintThread;
import controller.JindoController;
import game.util.GameWindowUtil;
import view.GameMenu;
import view.GameView;

public class BtnStartHandler implements ActionListener
{
	GameMenu gameMenu;
	GameView gameView;
	GameRepaintThread gRepaintThread;
	public BtnStartHandler(GameMenu gameMenu, GameView gameView,GameRepaintThread gRepaintThread) 
	{
		this.gRepaintThread=gRepaintThread;
		this.gameMenu = gameMenu;
		this.gameView = gameView;
	}
	public void setgRepaintThread(GameRepaintThread gRepaintThread) 
	{
		this.gRepaintThread = gRepaintThread;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		gameMenu.setVisible(false);
		gameView.setVisible(true);
		if(LoginHandler.reflag)//reflag�� �ٽ� ���� ����
		{
			GameWindowUtil.grtreThread(JindoController.gamePanVO.getGp(), JindoController.gamePanVO.getGm(), JindoController.gamePanVO.getGv());
			//������ �ٽ� �����ϰ�
		}
		else
		{
			gRepaintThread.start(); //�����带  ����
		}
	}
}
