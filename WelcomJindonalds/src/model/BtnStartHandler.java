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
		if(LoginHandler.reflag)//reflag가 다시 시작 여부
		{
			GameWindowUtil.grtreThread(JindoController.gamePanVO.getGp(), JindoController.gamePanVO.getGm(), JindoController.gamePanVO.getGv());
			//쓰레드 다시 생성하고
		}
		else
		{
			gRepaintThread.start(); //쓰레드를  시작
		}
	}
}
