package model;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import MC.Thread.HambergerThread;
import game.util.GameUtill;
import jjcompoent.JJIconLabel;
import view.GameHamPreView;
import view.GameView;

public class GameViewHandler extends KeyAdapter
{
	
	GameView gameView;
	GameHamPreView gameHamPreView;
	ArrayList<JJIconLabel> imgIcon=new ArrayList<JJIconLabel>(); //��ư �̹����� ���� ����Ʈ
	public GameViewHandler(GameView gameView,GameHamPreView gameHamPreView) 
	{
		this.gameHamPreView=gameHamPreView;
		this.gameView = gameView;
		imgIcon=gameView.getImgIcons();
		selectIcon(gameView.keyLocation); //���� ������ ����� ���� ǥ�����ִ� �޼ҵ�
	}
	public void selectIcon(int num)
	{
		for (int i = 0; i < imgIcon.size(); i++)
		{
			if(i+1==num)
			{
				imgIcon.get(i).setBorder(new LineBorder(new Color(255, 0, 0), 3, true));
			}
			else
			{
				imgIcon.get(i).setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch (key) 
		{
		case KeyEvent.VK_RIGHT:
			if(gameView.keyLocation == 7)
			{
				gameView.keyLocation = 1;
			}
			else
			{
				gameView.keyLocation++;
			}
			break;
		case KeyEvent.VK_LEFT:
			if(gameView.keyLocation == 1)
			{
				gameView.keyLocation = 7;
			}
			else
			{
				gameView.keyLocation--;
			}
			break;

		default:
			break;
		}
		
		selectIcon(gameView.keyLocation);
	}
	
	@Override
	public void keyReleased(KeyEvent e) //Ű�� ���� ���� ���õ� ��ᰡ ��������.
	{
		int key = e.getKeyCode();
		
		switch (key) 
		{
		case KeyEvent.VK_ENTER: //���ʹ� �ܹ��� ��ü�� �´��� üũ�� �� ��
			if(GameUtill.bugerFullCheck(gameHamPreView.getComFoods(), gameView.getUserfoods()))
			{
				System.out.println("���ڳ�");
				GameUtill.resetHam(gameView,gameHamPreView,1);
			}
			else
			{
				GameUtill.resetHam(gameView,gameHamPreView,-1);
				System.out.println("Ʋ���ڳ�");
			}
			break;
		case KeyEvent.VK_SPACE: //�ϳ��� üũ���Ѵ�.
			HambergerThread ht=new HambergerThread(GameView.keyLocation, gameView,gameHamPreView);
			ht.start();
			
			System.out.println("gameView.foods.size():"+gameView.getUserfoods().size());
		break;
		
		default:
			break;
		}
	}
}
