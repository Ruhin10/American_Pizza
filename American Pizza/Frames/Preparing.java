package Frames;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Preparing extends JFrame  implements MouseListener, ActionListener {
	JPanel panel;
	JLabel prepareLabel,p2,p3,deliv;
	JButton homeBtn;
	Font myFont,myFont1,myFont2;
	Color mycolor1,mycolor2,mycolor4;
	ImageIcon icon,deli;

	
	public Preparing (){
		super("Order status");
		this.setSize(800,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);

		icon = new ImageIcon("images\\icon.png");
		this.setIconImage(icon.getImage());


		mycolor1=new Color(0, 92, 103);
		mycolor2 =new Color(172, 219, 206);
		mycolor4=new Color(47, 48, 60);

		myFont=new Font("serif",Font.PLAIN,38);
		myFont1=new Font("Titillium Web",Font.ITALIC,27);
		myFont2=new Font("serif",Font.BOLD,30);


		panel = new JPanel();
		panel.setBackground(mycolor2);
		panel.setLayout(null);
		deli= new ImageIcon("images\\delivery.jpg");
				deliv = new JLabel(deli);
				deliv.setBounds(0,0,480,550);
				panel.add(deliv);
		
		prepareLabel = new JLabel("Thank You");
		prepareLabel.setBounds(520,130,280,40);
		prepareLabel.setFont(myFont);
		panel.add(prepareLabel);

		p2 = new JLabel("Your food is");
		p2.setBounds(520,180,280,40);
		p2.setFont(myFont);
		panel.add(p2);

		p3 = new JLabel(" preparing......");
		p3.setBounds(520,230,280,50);
		p3.setFont(myFont);
		panel.add(p3);


		
		homeBtn = new JButton("Home");
		homeBtn.setBounds(550,300,90,32);
		homeBtn.setBorder(null);
		homeBtn.setFont(myFont1);
		homeBtn.setBackground(mycolor1);
		homeBtn.setForeground(Color.WHITE);
		homeBtn.addMouseListener(this);
		homeBtn.addActionListener(this);
		panel.add(homeBtn);
	    this.add(panel);
		}
			public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == homeBtn){
			homeBtn.setBackground(mycolor4);
			homeBtn.setForeground(mycolor2);
			homeBtn.setFont(myFont2);
			homeBtn.setBounds(540,290,120,50);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == homeBtn){
			homeBtn.setBackground(mycolor1);
			homeBtn.setForeground(Color.WHITE);
			homeBtn.setFont(myFont1);
			homeBtn.setBounds(550,300,90,30);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		if(homeBtn.getText().equals(command)){
			System.exit(0);}
}
		
}