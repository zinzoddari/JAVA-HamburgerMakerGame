/*package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;



import domain.JindoVO;
import game.util.GameUtill;
import jjcompoent.JJLabel;
import persistence.JindoDAO;

public class RankingView extends JFrame
{
	public List<String> nameString = new ArrayList<String>();
	public JJLabel labStr, lab, lab1Id, lab2Id, lab3Id;
	public RankingView() 
	{
		setLayout(null);
		
		JPanel panel = new JPanel();
		rankingPen(panel);
		
		add(panel);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int sw = d.width;
		int sh = d.height;
		
		int w = 310;
		int h = 400;
		
		int x = (int)(0.5*(sw-w));
		int y = (sh-h)/2;
		
		setTitle("로그인");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(x, y, w, h);
		setVisible(true);
	}
	
	public void rankingPen(JPanel panel) 
	{
		JindoDAO dao = new JindoDAO();
		JindoVO vo = new JindoVO();
		labStr = new JJLabel(this, 300, 20, -5, 20, "===== 최고의 부자 랭킹 =====");
		labStr.setHorizontalAlignment(labStr.CENTER);
		
		for(int i=0; i<3; i++)
		{
			lab = new JJLabel(this, 300, 30, -5, 50+(50*i), i+1 + "등");
			lab.setHorizontalAlignment(lab.CENTER);
		}
		
		dao.rankCheck();
		
		
		
		lab1Id = new JJLabel(this, 300, 20, -5, 76, nameString.get(0));
		lab1Id.setHorizontalAlignment(labStr.CENTER);
		
		lab2Id = new JJLabel(this, 300, 20, -5, 126, nameString.get(1));
		lab2Id.setHorizontalAlignment(labStr.CENTER);
		
		lab3Id = new JJLabel(this, 300, 20, -5, 176, nameString.get(2));
		lab3Id.setHorizontalAlignment(labStr.CENTER);
	}
	public static void main(String[] args) {
		new RankingView();
	}
}
*/