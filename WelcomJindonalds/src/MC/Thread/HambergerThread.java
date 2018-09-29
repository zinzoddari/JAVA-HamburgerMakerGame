package MC.Thread;

import java.util.Vector;

import JFood.*;
import controller.JindoController;
import game.util.GameUtill;
import view.GameHamPreView;
import view.GameView;

public class HambergerThread extends Thread
{
	int hamnum; //����ȣ
	GameView gv;
	Food food;
	private int lmitY; //��ᰡ �������� �׿������� ������ǥ ���Ѱ�
	GameHamPreView gp;
	public HambergerThread(int hamnum,GameView gv,GameHamPreView gp)
	{
		lmitY=300-((gv.getUserfoods().size())*30); //������ ������ ����� ����ŭ ����� ���� 30�� ���ϰ� ��ü ȭ�� ���� 300���� ����
		this.hamnum=hamnum;
		this.gv=gv;
		this.gp=gp;
		System.out.println("lmitY:"+lmitY);
		food=GameUtill.habergerImg(hamnum,gv,gv.getUserfoods()); //�ܹ��� �̹����� �ϳ��� �߰��� ��
												//���ÿ� Vector�ȿ��� �߰� ���״�
	}
	
	@Override
	public void run() 
	{
		food.setY(10);//������ ������ ��ᰡ �������� ��ǥ�� ����
		while(true) 
		{
			gp.repaint(); //����
			try 
			{
				food.setLocation(food.getX(), food.getY()); //����� ��ġ ����
				Thread.sleep(50); //0.005�ʵ��� �����带 ����
				food.setY(food.getY()+30);//setY�� ��� ���� 30��ŭ �߰�
				gp.repaint();//����
				
				if(food.getY()>=lmitY) //������ ���� ����� ���̰� ���ѵ� ���̰����� Ŭ ��
				{
					System.out.println("food.getY():"+food.getY());
					gv.repaint(); //����
					break;
				}
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			gp.repaint(); //����
		}
						//������� �ϳ��� üũ�ϸ�/�������� ������ ������ ��� ������ �� ������ �� ���� �� üũ
		if(!GameUtill.bugerCheck(gp.getComFoods(), gv.getUserfoods(), gv.getUserfoods().size()-1)
			||gp.getComFoods().size()<gv.getUserfoods().size())
		{
			GameUtill.resetHam(gv,gp,-1);
			System.out.println("��"+gv.getMoney());
			return;
		}
	}
}
