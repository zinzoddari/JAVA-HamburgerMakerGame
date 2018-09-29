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

public class GameUtill //���������� ���ӿ� �ʿ��� �޼ҵ��
{
	public static Food habergerImg(int num, Container con, Vector<Food> foods) //foods�� num�� �´� ��ü�� �����ϰ�, ��ü�� �־��ش�. 
	{							//�ܹ��� ��� ��ȣ									
		Food food=null;
		//Food�� ��ӹ޾ұ� ������ food�� ���� �ٸ� �̸����� �־� ��ü���� �ϳ��� �����־���.
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
		
		con.add(food); //�����̳ʿ� food�� ����
		
		foods.add(food); //food�� Vector�� ����
		return food;
	}
										//�������� ���� ����		//������ ���� ������ ���	//����
	public static Boolean bugerCheck(Vector<Food> comHam,Vector<Food> userBuger,int index)
	{//�̸� ����γ��� ������ ��� ��ġ�� ���� ���� ���Ű� �����Ѱ� ���� üũ
		Boolean ck=false; 
		if(comHam.get(index).getNum()==userBuger.get(index).getNum())
		{
			System.out.println("�¾�");
			ck=true;
		}
		else
		{
			System.out.println("Ʋ��");
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
	{//������ ��ü ��Ḧ �˻�
		Boolean ck=true;
		if(comHam.size()!=userBuger.size()) //����� Ʋ���� false
		{
			return false;
		}
		for (int i = 0; i < comHam.size(); i++) 
		{
			if(comHam.get(i).getNum()!=userBuger.get(i).getNum()) //����� ������, ����� ��ġ�� Ʋ���� false
			{
				return false;
			}
		}
		return ck;
	}
								//�ּҰ�  	~	�ִ밪
	public static int randomNum(int minNum,int maxNum) //�����μ�
	{
		return (int)(Math.random()*(maxNum-minNum+1))+minNum;
	}
	
	public static void randomSelectHamNum() //�����μ��� ���� �ܹ��� ��ȣ�� �������� �����ϴ� ��
	{
		JindoController.selectHamNum=GameUtill.randomNum(JindoController.hamStartNum, JindoController.hamlastNum);
	}
	
	public static void resetHam(GameView gv,GameHamPreView gp,int plus) 
	{//������ ��������, �ٽ� ������ �����Ҷ� �ʱ�ȭ �ϱ� ���� �޼ҵ�
		gv.setMoney(gv.getMoney()+(plus*gp.getPrice())); //money������ �������� ������� üũ
		gv.getMoneyText().setText("���ͱ� : "+gv.getMoney()); 
		GameUtill.randomSelectHamNum();
		gp.nextPreViewSeting(gp, JindoController.selectHamNum, gp.getComFoods());
		gp.repaint();
		gv.clearUserFood(gv.getUserfoods());
		cgImagPan(gv.getNpcCh());
	}
	
	public static void cgImagPan(JLabel lb) //�մ� �������� ������ �����ϴ� �޼ҵ�
	{
		int num=GameUtill.randomNum(1,11); //1~����11����
		ImageIcon ic=new ImageIcon("Image/People/"+num+".png"); //�̹��������� ��ü ����
		lb.setIcon(ic); //�̹��������� ����
		lb.repaint(); //����
		
	}
	
	public static void moneyIcre(MemberVO vo,int money)//DB�� �� �þ ���� ������� �ִ� �޼ҵ�
	{
		vo.setMoney(vo.getMoney()+money); //���� ������ �� ���� �߰��� ���� vo�� ����
		MemberDAO dao=new MemberDAO(); //memberDAO ȸ�� ������ ���� ��ü ����
		dao.updateMember(vo); //UPDATE ������ ����ִ� �Լ� ����
		System.out.println(vo.getName()+"���� ��: "+vo.getMoney());
	}
}
