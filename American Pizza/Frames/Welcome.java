package Frames;
import Classes.*;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Welcome extends JFrame implements MouseListener, ActionListener{
	JPanel Panel;
	JLabel weL1,weL2,wel3,emp,imgL;
	JButton lginBtn,signBtn;
	Font myFont,myFont1,myFont2,myFont3;
	Color mycolor1,mycolor2,mycolor3,mycolor4,mycolor5,mycolor6;
	ImageIcon logo,icon;
	user u ;
	users us;

	public Welcome(){

		super("American Pizza");	
		this.setSize(800,530);
			this.us = us;
		icon = new ImageIcon("images\\icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);

		mycolor1=new Color(0,0,0);
		mycolor2=new Color(227, 124,44);
		mycolor3=new Color(0, 92, 103);
		mycolor4 =new Color(172, 219, 206);
		mycolor5 =new Color(255,255,255);
		mycolor6 =new Color(47, 48, 60);

		myFont=new Font("serif",Font.PLAIN,24);
		myFont1=new Font("Titillium Web",Font.BOLD,43);
		myFont2=new Font("Titillium Web",Font.BOLD,36);
		myFont3=new Font("serif",Font.BOLD,30);

		Panel=new JPanel();

		Panel.setLayout(null);
		Panel.setBackground(mycolor4);

		logo= new ImageIcon("images\\logo.png");
				imgL = new JLabel(logo);
				imgL.setBounds(405,0,400,480);
				Panel.add(imgL);

		weL1 = new JLabel("Welcome");
		weL1.setBounds(85,100,300,35);
		weL1.setBackground(mycolor4);
		weL1.setFont(myFont1);
		Panel.add(weL1);

		weL2 = new JLabel("TO");
		weL2.setBounds(150,143,80,35);
		weL2.setBackground(mycolor4);
		weL2.setFont(myFont2);
		Panel.add(weL2);

		wel3 = new JLabel("American Pizza");
		wel3.setBounds(60,180,350,35);
		wel3.setBackground(mycolor4);
		wel3.setFont(myFont2);
		Panel.add(wel3);

	
		emp = new JLabel();
		emp.setBounds(405,0,400,500);
		emp.setBackground(mycolor5);
		emp.setOpaque(true);
		Panel.add(emp);

		this.add(Panel);

		
		lginBtn = new JButton("Login");
		lginBtn.setFont(myFont);
		lginBtn.setBorder(null);
		lginBtn.setBounds(50,260,100,33);
		lginBtn.setBackground(mycolor3);
		lginBtn.setForeground(mycolor5);
		lginBtn.addActionListener(this);
		lginBtn.addMouseListener(this);
	

		Panel.add(lginBtn);
		
		signBtn = new JButton("SignUp");
		signBtn.setBounds(200,260,110,33);
		signBtn.setBorder(null);
		signBtn.setFont(myFont);
		signBtn.setBackground(mycolor3);
		signBtn.setForeground(mycolor5);
		signBtn.addActionListener(this);
		signBtn.addMouseListener(this);
		Panel.add(signBtn);
		this.setVisible(true);
}	
	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == signBtn){
			signBtn.setBackground(mycolor6);
			signBtn.setForeground(mycolor4);
			signBtn.setFont(myFont3);
			signBtn.setBounds(190,255,135,39);
		}else if(me.getSource() == lginBtn){
			lginBtn.setBackground(mycolor6);
			lginBtn.setForeground(mycolor4);
			lginBtn.setFont(myFont3);
			lginBtn.setBounds(40,255,125,39);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == signBtn){
			signBtn.setBackground(mycolor3);
			signBtn.setForeground(mycolor5);
			signBtn.setFont(myFont);
			signBtn.setBounds(200,260,110,33);
		}else if(me.getSource() == lginBtn){
			lginBtn.setBackground(mycolor3);
			lginBtn.setForeground(mycolor5);
			lginBtn.setFont(myFont);
			lginBtn.setBounds(50,260,100,33);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 
		public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
			if(signBtn.getText().equals(command)){
			SignUP si = new SignUP(us);
			si.setVisible(true);
			this.setVisible(false);
			
			}else if(lginBtn.getText().equals(command)){
			
			LoginF lg = new LoginF(us);
			lg.setVisible(true);
			this.setVisible(false);
		}

	}
}

