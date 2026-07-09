package Frames;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUP extends JFrame implements  ActionListener {
	JPanel Panel;
	JLabel signL,userL ,passL,emp,imgL,askL,phoneL;
	JTextField userTF,phoneTF;
	JPasswordField passTF;
	JButton lginBtn,signBtn;
	Font myFont,myFont1,myFont2;
	Color mycolor1,mycolor2,mycolor3,mycolor4,mycolor5;
	ImageIcon logo,icon;
	user u = null;
	users us = null;

	public SignUP(users us){

		super("  American Pizza  -   SIGN UP");	
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

		myFont=new Font("serif",Font.PLAIN,24);
		myFont1=new Font("Titillium Web",Font.ITALIC,16);
		myFont2=new Font("Titillium Web",Font.BOLD,36);


		Panel=new JPanel();

		Panel.setLayout(null);
		Panel.setBackground(mycolor4);

		logo= new ImageIcon("images\\logo.png");
				imgL = new JLabel(logo);
				imgL.setBounds(0,0,380,480);
				Panel.add(imgL);

		signL = new JLabel("SIGN UP");
		signL.setBounds(520,80,150,35);
		signL.setBackground(mycolor4);
		signL.setFont(myFont2);
		Panel.add(signL);


		userL = new JLabel("Username: ");
		userL.setBounds(430,140,120,25);
		userL.setFont(myFont);
		userL.setBackground(null);
		userL.setOpaque(true);
		Panel.add(userL);

		userTF = new JTextField();
		userTF.setBounds(430,170,300,33);
		userTF.setBackground(null);
		userTF.setFont(myFont);
		userTF.setBorder(BorderFactory.createLineBorder(mycolor1,2));
		Panel.add(userTF);


		
		phoneL =new JLabel("Phone: ");
		phoneL.setBounds(430,276,120,25);
		phoneL.setFont(myFont);
		phoneL.setBackground(null);
		phoneL.setOpaque(true);
		Panel.add(phoneL);

		phoneTF =new JTextField();
		phoneTF.setBounds(430,307,300,33);
		phoneTF.setFont(myFont);
		phoneTF.setBackground(null);
		phoneTF.setBorder(BorderFactory.createLineBorder(mycolor1,2));
		Panel.add(phoneTF);		


		passL = new JLabel("Password: ");
		passL.setBounds(430,208,120,25);
		passL.setFont(myFont);
		passL.setBackground(mycolor4);
		passL.setForeground(mycolor1);
		passL.setOpaque(true);
		Panel.add(passL);
		
		
		passTF = new JPasswordField();
		passTF.setBounds(430,238,300,33);
		passTF.setEchoChar('*');
		passTF.setBackground(null);
		passTF.setFont(myFont);
		passTF.setBorder(BorderFactory.createLineBorder(mycolor1,2));
		Panel.add(passTF);
		



		lginBtn = new JButton("Login");
		lginBtn.setFont(myFont1);
		lginBtn.setBounds(610,400,60,23);
		lginBtn.setBackground(null);
		lginBtn.setForeground(mycolor3);
		lginBtn.setBorder(null);
		lginBtn.addActionListener(this);
		Panel.add(lginBtn);
		
		signBtn = new JButton("SignUp");
		signBtn.setBounds(430,348,110,33);
		signBtn.setBorder(null);
		signBtn.setFont(myFont);
		signBtn.setBackground(mycolor3);
		signBtn.setForeground(mycolor5);
		signBtn.addActionListener(this);
		Panel.add(signBtn);


		emp = new JLabel();
		emp.setBounds(0,0,400,500);
		emp.setBackground(mycolor5);
		emp.setOpaque(true);
		Panel.add(emp);


		askL= new JLabel("Don't have any account?");
		askL.setBounds(435,400,180,20);
		askL.setFont(myFont1);
		askL.setForeground(mycolor1);
		askL.setBackground(null);
		Panel.add(askL);
		this.add(Panel);
	}
		public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(lginBtn.getText().equals(command)){
			LoginF lg = new LoginF(us);
			lg.setVisible(true);
			this.setVisible(false);
		}
		if(signBtn.getText().equals(command)){
			String name = "",phone = "",pass="";
			
			name = userTF.getText();
			phone = phoneTF.getText();
			pass = passTF.getText();
			
			if(!name.isEmpty() && !pass.isEmpty() && !phone.isEmpty() ){
					
					user u = new user(name,pass,phone);
					users us =new users();
					us.addUser(u);
					
					JOptionPane.showMessageDialog(this, "Sign up successful. Please login to continue.");
					LoginF lg = new LoginF(us);
					lg.setVisible(true);
					this.setVisible(false);
			
			}else{
				JOptionPane.showMessageDialog(this, "Information missing");
			}
			
		}
	}
	
}