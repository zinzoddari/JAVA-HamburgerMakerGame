package game.util;

import MC.Thread.GameRepaintThread;
import domain.game.GamePanVO;
import view.GameEndView;
import view.GameHamPreView;
import view.GameMenu;
import view.GameView;

public class GameWindowUtil //게임 화면에 대한 메소드를 정의한 것
{
	public static void grtreThread(GameHamPreView gameHamPreView,GameMenu gameMenu,GameView gameView)
	{
		GameRepaintThread rt=new GameRepaintThread(gameView, gameHamPreView, gameMenu); // 쓰레드를 다시 생성
		rt.start(); // 다시 생성한 쓰레드를 실행
	}
	
	public static void setGameVo(GamePanVO vo,GameMenu gm,GameView gv,GameHamPreView gp,GameEndView gev)
	{//객체를 담음
		vo.setGm(gm);
		vo.setGp(gp);
		vo.setGv(gv);
		vo.setGev(gev);
	}
}
