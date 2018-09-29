package MC.Thread;

import java.util.Vector;

import JFood.*;
import controller.JindoController;
import game.util.GameUtill;
import view.GameHamPreView;
import view.GameView;

public class HambergerThread extends Thread
{
	int hamnum; //재료번호
	GameView gv;
	Food food;
	private int lmitY; //재료가 떨어져서 쌓였을대의 높이좌표 제한값
	GameHamPreView gp;
	public HambergerThread(int hamnum,GameView gv,GameHamPreView gp)
	{
		lmitY=300-((gv.getUserfoods().size())*30); //유저가 선택한 재료의 수만큼 재료의 높이 30을 곱하고 전체 화면 높이 300에서 빼줌
		this.hamnum=hamnum;
		this.gv=gv;
		this.gp=gp;
		System.out.println("lmitY:"+lmitY);
		food=GameUtill.habergerImg(hamnum,gv,gv.getUserfoods()); //햄버거 이미지를 하나씩 추가한 것
												//동시에 Vector안에도 추가 시켰다
	}
	
	@Override
	public void run() 
	{
		food.setY(10);//유저가 선택한 재료가 떨어지는 좌표를 설정
		while(true) 
		{
			gp.repaint(); //갱신
			try 
			{
				food.setLocation(food.getX(), food.getY()); //재료의 위치 설정
				Thread.sleep(50); //0.005초동안 쓰레드를 멈춤
				food.setY(food.getY()+30);//setY에 재료 높이 30만큼 추가
				gp.repaint();//갱신
				
				if(food.getY()>=lmitY) //유저가 쌓은 재료의 높이가 제한된 높이값보다 클 때
				{
					System.out.println("food.getY():"+food.getY());
					gv.repaint(); //갱신
					break;
				}
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			gp.repaint(); //갱신
		}
						//버거재료 하나씩 체크하며/랜덤으로 설정한 버거의 재료 수보다 내 재료수가 더 많을 때 체크
		if(!GameUtill.bugerCheck(gp.getComFoods(), gv.getUserfoods(), gv.getUserfoods().size()-1)
			||gp.getComFoods().size()<gv.getUserfoods().size())
		{
			GameUtill.resetHam(gv,gp,-1);
			System.out.println("돈"+gv.getMoney());
			return;
		}
	}
}
