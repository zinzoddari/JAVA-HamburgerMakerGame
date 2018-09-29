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
	ArrayList<HambergerVO> HamBergerAllList=new ArrayList<HambergerVO>(); //햄버거 테이블에있는 정보 담은 리스트
	//List<JindoVO> rankList = new ArrayList<JindoVO>(); //구현하지 못한 랭킹 리스트 
	public static int hamStartNum; //햄버거 pk의 첫 라인에 들어가는 번호 -static변수
	public static int hamlastNum; //햄버거 pk의 마지막 라인에 들어가는 번호  -static변수
	public static int selectHamNum; //햄버거 pk의 선택한 번호 -static변수
	public static MemberVO memberInfo; //로그인한 회원의 정보를 담음
	public static GamePanVO gamePanVO=new GamePanVO(); //게임 실행시 패널값의 모든 주소값을 담음
	public JindoController() 
	{
		JindoDAO dao = new JindoDAO(); //DB 쿼리문에 대한 객체 생성
		
		HamDAO hd=new HamDAO(); //햄버거 관련 DAO 객체 생성
		
		HamBergerAllList=(ArrayList<HambergerVO>)hd.hamBegerAllList(); //햄버거 테이블에 있는 정보를 리스트에 담는 작업
		
		hamStartNum=HamBergerAllList.get(0).getHamNum(); //첫번째 번호를 넣어줌
		hamlastNum=HamBergerAllList.get(HamBergerAllList.size()-1).getHamNum(); //햄버거의 마지막 번호를 계산해 넣어 줌
		
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
