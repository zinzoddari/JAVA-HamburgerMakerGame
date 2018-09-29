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

public class GameRepaintThread extends Thread //전체적인 GameView에 대한 Thread
{
	GameView gv;
	GameHamPreView gp;
	GameMenu gm;
	
	public int num=0; //초
	int profits=0; //수익금
	int origin=0; //기존금액
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
				Thread.sleep(300); //1초동안 쓰레드를 멈추는 것(대기 상태)
				if(num>40) //초가 40초를 넘어갈 때
				{
					profits=gv.getMoney(); //수익금에 대한 값을 gv의 money에 저장
					GameUtill.moneyIcre(JindoController.memberInfo, gv.getMoney()); //DB작업 및 수익금과 기존금액 더함
					origin=JindoController.memberInfo.getMoney(); //기존 금액
					gm.labMoney.setText("잔액:"+JindoController.memberInfo.getMoney()+"원");
						
					reset();
						
					if(!LoginHandler.reflag)
					{
						LoginHandler.reflag=true;
					}
					break;
					}
					else
					{
						gv.timeSecond.setText(40-num+"초");
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
		gv.setVisible(false); //게임창을 끈다
		
		JindoController.gamePanVO.getGev().setVisible(true); //게임 결과창을 보여준다
		JindoController.gamePanVO.getGev().labMoney.setText(profits+"원"); //수익금에 대한 텍스트변경
		JindoController.gamePanVO.getGev().labDefaultMoney.setText(origin+"원"); //기존금액에 대한 텍스트설정
		JindoController.gamePanVO.getGev().labAddMoney.setText(JindoController.memberInfo.getMoney()+"원"); //수익금 + 기존금액에 대한 텍스트변경
		JindoController.gamePanVO.getGv().moneyText.setText("수익금: 0원"); //게임화면 오른쪽에 위치한 돈 초기화
		JindoController.gamePanVO.getGv().keyLocation=1; //게임 재시작시 버튼 처음자리로 초기화
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