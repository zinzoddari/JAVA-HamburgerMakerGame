package domain.game;

import view.GameEndView;
import view.GameHamPreView;
import view.GameMenu;
import view.GameView;

public class GamePanVO //���ӿ��� ����� �� �ִ� ��ü�� ��� ����
{
	GameView gv;
	GameHamPreView gp;
	GameMenu gm;
	GameEndView gev;
	public GameEndView getGev() 
	{
		return gev;
	}
	public void setGev(GameEndView gev) 
	{
		this.gev = gev;
	}
	public GameView getGv() 
	{
		return gv;
	}
	public void setGv(GameView gv) 
	{
		this.gv = gv;
	}
	public GameHamPreView getGp() 
	{
		return gp;
	}
	public void setGp(GameHamPreView gp) 
	{
		this.gp = gp;
	}
	public GameMenu getGm() 
	{
		return gm;
	}
	public void setGm(GameMenu gm) 
	{
		this.gm = gm;
	}
}
