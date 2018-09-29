package MC.Thread;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.JindoController;
import domain.MemberVO;
import game.util.GameUtill;
import model.GameViewHandler;
import model.LoginHandler;
import view.GameEndView;
import view.GameHamPreView;
import view.GameMenu;
import view.GameView;
import view.LoginPanel;

public class GameRepaintThread extends Thread //��ü���� GameView�� ���� Thread
{
	GameView gv;
	GameHamPreView gp;
	GameMenu gm;
	
	public int num=0; //��
	int profits=0; //���ͱ�
	int origin=0; //�����ݾ�
	public GameRepaintThread(GameView gv,GameHamPreView gp,GameMenu gm)
	{
		this.gp=gp;
		this.gv=gv;
		this.gm=gm;
	}
	
	@Override
	public void run() 
	{
		System.out.println("GameRepaintThread start");
		while (true) 
		{
			try 
			{
				Thread.sleep(300); //1�ʵ��� �����带 ���ߴ� ��(��� ����)
				if(num>40) //�ʰ� 40�ʸ� �Ѿ ��
				{
					profits=gv.getMoney(); //���ͱݿ� ���� ���� gv�� money�� ����
					GameUtill.moneyIcre(JindoController.memberInfo, gv.getMoney()); //DB�۾� �� ���ͱݰ� �����ݾ� ����
					origin=JindoController.memberInfo.getMoney(); //���� �ݾ�
					gm.labMoney.setText("�ܾ�:"+JindoController.memberInfo.getMoney()+"��");
						
					reset();
						
					if(!LoginHandler.reflag)
					{
						LoginHandler.reflag=true;
					}
					break;
					}
					else
					{
						gv.timeSecond.setText(40-num+"��");
					}
					num++;
				} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void reset()
	{
		gv.setVisible(false); //����â�� ����
		
		JindoController.gamePanVO.getGev().setVisible(true); //���� ���â�� �����ش�
		JindoController.gamePanVO.getGev().labMoney.setText(profits+"��"); //���ͱݿ� ���� �ؽ�Ʈ����
		JindoController.gamePanVO.getGev().labDefaultMoney.setText(origin+"��"); //�����ݾ׿� ���� �ؽ�Ʈ����
		JindoController.gamePanVO.getGev().labAddMoney.setText(JindoController.memberInfo.getMoney()+"��"); //���ͱ� + �����ݾ׿� ���� �ؽ�Ʈ����
		JindoController.gamePanVO.getGv().moneyText.setText("���ͱ�: 0��"); //����ȭ�� �����ʿ� ��ġ�� �� �ʱ�ȭ
		JindoController.gamePanVO.getGv().keyLocation=1; //���� ����۽� ��ư ó���ڸ��� �ʱ�ȭ
		for(int i=0;i<JindoController.gamePanVO.getGv().imgIcons.size();i++)
		{
			if(i+1==JindoController.gamePanVO.getGv().keyLocation)
			{
				JindoController.gamePanVO.getGv().imgIcons.get(i).setBorder(new LineBorder(new Color(255, 0, 0), 3, true));
			}
			else
			{
				JindoController.gamePanVO.getGv().imgIcons.get(i).setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			}
		}
	}
}