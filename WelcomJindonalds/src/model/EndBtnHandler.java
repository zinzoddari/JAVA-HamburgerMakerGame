package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.JindoController;
import game.util.GameUtill;

public class EndBtnHandler implements ActionListener
{
	
	public EndBtnHandler() 
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	  JindoController.gamePanVO.getGev().setVisible(false);
	  JindoController.gamePanVO.getGm().setVisible(true);
	 
	  GameUtill.resetHam(JindoController.gamePanVO.getGv(), JindoController.gamePanVO.getGp(), 0);
	  //초기화(이미지)
	}
}
