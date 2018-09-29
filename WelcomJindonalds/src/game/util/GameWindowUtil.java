package game.util;

import MC.Thread.GameRepaintThread;
import domain.game.GamePanVO;
import view.GameEndView;
import view.GameHamPreView;
import view.GameMenu;
import view.GameView;

public class GameWindowUtil //���� ȭ�鿡 ���� �޼ҵ带 ������ ��
{
	public static void grtreThread(GameHamPreView gameHamPreView,GameMenu gameMenu,GameView gameView)
	{
		GameRepaintThread rt=new GameRepaintThread(gameView, gameHamPreView, gameMenu); // �����带 �ٽ� ����
		rt.start(); // �ٽ� ������ �����带 ����
	}
	
	public static void setGameVo(GamePanVO vo,GameMenu gm,GameView gv,GameHamPreView gp,GameEndView gev)
	{//��ü�� ����
		vo.setGm(gm);
		vo.setGp(gp);
		vo.setGv(gv);
		vo.setGev(gev);
	}
}
