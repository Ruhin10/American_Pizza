package Frames;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class LoginF extends JFrame implements MouseListener, ActionListener{
	JPanel Panel;
	JLabel loginL,userL ,passL,emp,imgL,askL;
	JTextField userTF;
	JPasswordField passTF;
	JButton lginBtn,signBtn;
	Font myFont,myFont1,myFont2,myFont3;
	Color mycolor1,mycolor2,mycolor3,mycolor4,mycolor5,mycolor6;
	ImageIcon logo,icon;
	user u = null;
	users us = null;

	public LoginF(users us){

		super("American Pizza  -   LOG IN");	
		this.setSize(800,530);

	
		icon = new ImageIcon("images\\icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);
			this.us = us;
		mycolor1=new Color(0,0,0);
		mycolor2=new Color(227, 124,44);
		mycolor3=new Color(0, 92, 103);
		mycolor4 =new Color(172, 219, 206);
		mycolor5 =new Color(255,255,255);
		mycolor6 =new Color(47, 48, 60);

		myFont=new Font("serif",Font.PLAIN,24);
		myFont1=new Font("Titillium Web",Font.ITALIC,16);
		myFont2=new Font("Titillium Web",Font.BOLD,36);
		myFont3=new Font("serif",Font.BOLD,30);


		Panel=new JPanel();

		Panel.setLayout(null);
		Panel.setBackground(mycolor4);

		logo= new ImageIcon("images\\logo.png");
				imgL = new JLabel(logo);
				imgL.setBounds(0,0,380,480);
				Panel.add(imgL);

		loginL = new JLabel("LOG IN");
		loginL.setBounds(530,70,150,35);
		loginL.setBackground(mycolor4);
		loginL.setFont(myFont2);
		Panel.add(loginL);

		userL = new JLabel("Username: ");
		userL.setBounds(430,150,120,30);
		userL.setFont(myFont);
		userL.setBackground(null);
		userL.setOpaque(true);
		Panel.add(userL);
		
		passL = new JLabel("Password: ");
		passL.setBounds(430,230,120,30);
		passL.setFont(myFont);
		passL.setBackground(mycolor4);
		passL.setForeground(mycolor1);
		passL.setOpaque(true);
		Panel.add(passL);
		
		userTF = new JTextField();
		userTF.setBounds(430,190,300,30);
		userTF.setBackground(mycolor4);
		userTF.setFont(myFont);
		userTF.setBorder(BorderFactory.createLineBorder(mycolor1,2));
		Panel.add(userTF);
		
		passTF = new JPasswordField();
		passTF.setBounds(430,270,300,30);
		passTF.setEchoChar('*');
		passTF.setBackground(null);
		passTF.setFont(myFont);
		passTF.setBorder(BorderFactory.createLineBorder(mycolor1,2));
		Panel.add(passTF);
		
		lginBtn = new JButton("Login");
		lginBtn.setFont(myFont);
		lginBtn.setBounds(430,320,110,33);
		lginBtn.setBackground(mycolor3);
		lginBtn.setForeground(mycolor5);
		lginBtn.setBorder(null);
		lginBtn.addActionListener(this);
		lginBtn.addMouseListener(this);
		
		Panel.add(lginBtn);
		
		signBtn = new JButton("SignUp");
		signBtn.setBounds(615,380,65,23);
		signBtn.setBorder(null);
		signBtn.setFont(myFont1);
		signBtn.setBackground(null);
		signBtn.setForeground(mycolor3);
		signBtn.addActionListener(this);
			
		Panel.add(signBtn);


		emp = new JLabel();
		emp.setBounds(0,0,400,500);
		emp.setBackground(mycolor5);
		emp.setOpaque(true);
		Panel.add(emp);


		askL= new JLabel("Don't have any account?");
		askL.setBounds(435,380,180,20);
		askL.setFont(myFont1);
		askL.setForeground(mycolor1);
		askL.setBackground(null);
		Panel.add(askL);
		this.add(Panel);
	}
	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == lginBtn){
			lginBtn.setBackground(mycolor6);
			lginBtn.setForeground(mycolor4);
			lginBtn.setFont(myFont3);
			lginBtn.setBounds(420,310,130,39);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == lginBtn){
			lginBtn.setBackground(mycolor3);
			lginBtn.setForeground(mycolor5);
			lginBtn.setFont(myFont);
			lginBtn.setBounds(430,320,110,33);
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
			String name = userTF.getText();
			String pass = passTF.getText();

			try{
				FileReader fr= new FileReader("Files/userdata.txt");
				Scanner reader =new Scanner(fr);

				while(reader.hasNext())
				{

					String un=reader.next();
					String pw=reader.next();
					if(name.equals(un.trim()) && pass.equals(pw.trim()))
					{
						reader.close();
						Location ls =new Location();
						ls.setVisible(true);
						this.setVisible(false);

					}
				}
				JOptionPane.showMessageDialog(null,"Username or Password incorrect..");
			}catch(Exception e){

			}
			
		}
	}

}