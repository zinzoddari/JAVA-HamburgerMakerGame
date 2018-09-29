package controller;


import java.util.ArrayList;
import java.util.List;

import MC.Thread.GameRepaintThread;
import domain.HamVO;
import domain.HambergerVO;
import domain.JindoVO;
import domain.MemberVO;
import domain.game.GamePanVO;
import game.util.GameUtill;
import game.util.GameWindowUtil;
import model.BtnStartHandler;
import model.EndBtnHandler;
import model.GameViewHandler;
import model.JoinCheck;
import model.JoinHandler;
import model.LoginHandler;
import persistence.HamDAO;
import persistence.JindoDAO;
import view.GameEndView;
import view.GameHamPreView;
import view.GameMenu;
import view.GameView;
import view.JoinPanel;
import view.LoginPanel;

public class JindoController 
{
	ArrayList<HambergerVO> HamBergerAllList=new ArrayList<HambergerVO>(); //�ܹ��� ���̺��ִ� ���� ���� ����Ʈ
	//List<JindoVO> rankList = new ArrayList<JindoVO>(); //�������� ���� ��ŷ ����Ʈ 
	public static int hamStartNum; //�ܹ��� pk�� ù ���ο� ���� ��ȣ -static����
	public static int hamlastNum; //�ܹ��� pk�� ������ ���ο� ���� ��ȣ  -static����
	public static int selectHamNum; //�ܹ��� pk�� ������ ��ȣ -static����
	public static MemberVO memberInfo; //�α����� ȸ���� ������ ����
	public static GamePanVO gamePanVO=new GamePanVO(); //���� ����� �гΰ��� ��� �ּҰ��� ����
	public JindoController() 
	{
		JindoDAO dao = new JindoDAO(); //DB �������� ���� ��ü ����
		
		HamDAO hd=new HamDAO(); //�ܹ��� ���� DAO ��ü ����
		
		HamBergerAllList=(ArrayList<HambergerVO>)hd.hamBegerAllList(); //�ܹ��� ���̺� �ִ� ������ ����Ʈ�� ��� �۾�
		
		hamStartNum=HamBergerAllList.get(0).getHamNum(); //ù��° ��ȣ�� �־���
		hamlastNum=HamBergerAllList.get(HamBergerAllList.size()-1).getHamNum(); //�ܹ����� ������ ��ȣ�� ����� �־� ��
		
		LoginPanel loginPan = new LoginPanel();
		
		JoinPanel joinPan = new JoinPanel();
		
		GameMenu gameMenu = new GameMenu(loginPan);
		
		GameView gameView = new GameView();
		
		GameEndView gameEndView=new GameEndView();
		EndBtnHandler endBtnHandler=new EndBtnHandler();
		
		GameHamPreView gameHamPreView=new GameHamPreView(gameView);
		
		LoginHandler loginHandler = new LoginHandler(loginPan, dao, gameMenu);
		
		JoinCheck joinCheck = new JoinCheck(joinPan, dao, loginPan);
		JoinHandler joinHandler = new JoinHandler(loginPan, joinPan, dao);
		
		loginPan.btnLogin.addActionListener(loginHandler);
		
		loginPan.btnJoin.addActionListener(joinHandler);
		joinPan.btnJoin.addActionListener(joinCheck);
		
		gameEndView.btnCheck.addActionListener(endBtnHandler);
		
		GameRepaintThread gRThread=new GameRepaintThread(gameView,gameHamPreView,gameMenu);
		
		GameViewHandler gameViewHandler = new GameViewHandler(gameView,gameHamPreView);
		gameView.addKeyListener(gameViewHandler);
		
		BtnStartHandler btnStartHandler = new BtnStartHandler(gameMenu, gameView,gRThread);
		
		gameMenu.btnStart.addActionListener(btnStartHandler);
		
		GameWindowUtil.setGameVo(gamePanVO, gameMenu, gameView, gameHamPreView,gameEndView);
	}
	
	
	public static void main(String[] args) 
	{
		JindoController jd=new JindoController();
	}
}
