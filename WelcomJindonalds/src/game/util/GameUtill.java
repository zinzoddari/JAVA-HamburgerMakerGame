package game.util;

import java.awt.Color;
import java.awt.Container;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JFood.BottomBread;
import JFood.Cheese;
import JFood.Food;
import JFood.Letters;
import JFood.Onion;
import JFood.Patty;
import JFood.Tomato;
import JFood.TopBread;
import controller.JindoController;
import domain.MemberVO;
import persistence.MemberDAO;
import view.GameHamPreView;
import view.GameView;

public class GameUtill //본격적으로 게임에 필요한 메소드들
{
	public static Food habergerImg(int num, Container con, Vector<Food> foods) //foods에 num에 맞는 객체를 생성하고, 객체를 넣어준다. 
	{							//햄버거 재료 번호									
		Food food=null;
		//Food를 상속받았기 때문에 food에 각기 다른 이름으로 넣어 객체들을 하나로 묶어주었다.
		switch (num) 
		{
		case GameView.BOTTOMBREAD: 
			BottomBread bt=new BottomBread();
			food=bt;
		break;
		case GameView.CHEESE: 
			Cheese ch=new Cheese();
			food=ch;
		break;
		case GameView.LETTERS:
			Letters lt=new Letters();
			food=lt;
		break;
		case GameView.ONION:
			Onion on=new Onion();
			food=on;
		break;
		case GameView.PATTY: 
			Patty pt=new Patty();
			food=pt;
		break;
		case GameView.TOMATO: 
			Tomato tm=new Tomato();
			food=tm;
		break; 	
		case GameView.TOPBREAD:
			TopBread tp=new TopBread();
			food=tp;
		break; 	
		default:
			break;
		}
		
		con.add(food); //콘테이너에 food를 담음
		
		foods.add(food); //food의 Vector에 담음
		return food;
	}
										//랜덤으로 나온 버거		//유저가 직접 선택한 재료	//순서
	public static Boolean bugerCheck(Vector<Food> comHam,Vector<Food> userBuger,int index)
	{//미리 보기로나온 버거의 재료 위치와 내가 누른 버거가 동일한가 여부 체크
		Boolean ck=false; 
		if(comHam.get(index).getNum()==userBuger.get(index).getNum())
		{
			System.out.println("맞아");
			ck=true;
		}
		else
		{
			System.out.println("틀려");
			ck=false;
		}
		
		return ck;
	}
	
	/*public static Boolean bugerlastCheck(Vector<Food> comHam,Vector<Food> userBuger)
	{
		Boolean ck=false;
		if(comHam.size()==userBuger.size())
		{
			ck=true;
		}
		else
		{
			ck=false;
		}
		return ck;
	}*/
	
	public static Boolean bugerFullCheck(Vector<Food> comHam,Vector<Food> userBuger)
	{//버거의 전체 재료를 검사
		Boolean ck=true;
		if(comHam.size()!=userBuger.size()) //사이즈가 틀리면 false
		{
			return false;
		}
		for (int i = 0; i < comHam.size(); i++) 
		{
			if(comHam.get(i).getNum()!=userBuger.get(i).getNum()) //사이즈가 맞지만, 재료의 위치가 틀리면 false
			{
				return false;
			}
		}
		return ck;
	}
								//최소값  	~	최대값
	public static int randomNum(int minNum,int maxNum) //랜덤인수
	{
		return (int)(Math.random()*(maxNum-minNum+1))+minNum;
	}
	
	public static void randomSelectHamNum() //랜덤인수를 통해 햄버거 번호를 랜덤으로 선택하는 것
	{
		JindoController.selectHamNum=GameUtill.randomNum(JindoController.hamStartNum, JindoController.hamlastNum);
	}
	
	public static void resetHam(GameView gv,GameHamPreView gp,int plus) 
	{//게임이 끝나고나서, 다시 게임을 시작할때 초기화 하기 위한 메소드
		gv.setMoney(gv.getMoney()+(plus*gp.getPrice())); //money설정가 음수인지 양수인지 체크
		gv.getMoneyText().setText("수익금 : "+gv.getMoney()); 
		GameUtill.randomSelectHamNum();
		gp.nextPreViewSeting(gp, JindoController.selectHamNum, gp.getComFoods());
		gp.repaint();
		gv.clearUserFood(gv.getUserfoods());
		cgImagPan(gv.getNpcCh());
	}
	
	public static void cgImagPan(JLabel lb) //손님 랜덤으로 나오게 설정하는 메소드
	{
		int num=GameUtill.randomNum(1,11); //1~에서11까지
		ImageIcon ic=new ImageIcon("Image/People/"+num+".png"); //이미지아이콘 객체 생성
		lb.setIcon(ic); //이미지아이콘 설정
		lb.repaint(); //갱신
		
	}
	
	public static void moneyIcre(MemberVO vo,int money)//DB에 돈 늘어난 것을 적용시켜 주는 메소드
	{
		vo.setMoney(vo.getMoney()+money); //기존 돈에서 번 돈을 추가한 돈을 vo에 설정
		MemberDAO dao=new MemberDAO(); //memberDAO 회원 정보에 대한 객체 생성
		dao.updateMember(vo); //UPDATE 쿼리가 들어있는 함수 실행
		System.out.println(vo.getName()+"너의 돈: "+vo.getMoney());
	}
}
