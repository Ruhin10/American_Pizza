package Frames;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Location extends JFrame implements MouseListener, ActionListener {
	JPanel panel;
	JLabel locationLabel,emp,imgL,locationL;
	JTextField locationTF;
	JButton backBtn,nextBtn;
	Font myFont,myFont1,myFont2;
	Color mycolor1,mycolor2,mycolor4;
	ImageIcon logo,icon;
	
	public Location(){
		super("Location");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);
		icon = new ImageIcon("images\\icon.png");
		this.setIconImage(icon.getImage());

		mycolor1=new Color(0, 92, 103);
		mycolor2 =new Color(172, 219, 206);
		mycolor4=new Color(47, 48, 60);

		myFont=new Font("serif",Font.PLAIN,25);
		myFont2=new Font("serif",Font.BOLD,30);
		myFont1=new Font("serif",Font.BOLD,50);
		

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(mycolor2);

		logo= new ImageIcon("images\\Map.PNG");
				imgL = new JLabel(logo);
				imgL.setBounds(360,0,450,455);
				panel.add(imgL);


		locationL = new JLabel("Location");
		locationL.setBounds(40,50,300,80);
		locationL.setFont(myFont1);
		locationL.setBackground(mycolor2);
		locationL.setOpaque(true);
		panel.add(locationL);


		locationLabel = new JLabel("Enter your location: ");
		locationLabel.setBounds(40,170,300,33);
		locationLabel.setFont(myFont);
		locationLabel.setBackground(mycolor2);
		
		locationLabel.setOpaque(true);
		panel.add(locationLabel);
		
		locationTF = new JTextField();
		locationTF.setBounds(40,210,280,33);
		locationTF.setBackground(mycolor2);
		locationTF.setFont(myFont);
		locationTF.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		panel.add(locationTF);
		

		backBtn = new JButton("Back");
		backBtn.setFont(myFont);
		backBtn.setBounds(50,255,100,33);
		backBtn.setBackground(mycolor1);
		backBtn.setForeground(Color.WHITE);
		backBtn.setBorder(null);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);



		nextBtn = new JButton("Next");
		nextBtn.setFont(myFont);
		nextBtn.setBounds(200,255,100,33);
		nextBtn.setBackground(mycolor1);
		nextBtn.setForeground(Color.WHITE);
		nextBtn.setBorder(null);
		nextBtn.addMouseListener(this);
		nextBtn.addActionListener(this);
		panel.add(nextBtn);

		emp = new JLabel();
		emp.setBounds(360,0,440,500);
		emp.setBackground(Color.WHITE);
		emp.setOpaque(true);
		panel.add(emp);


		this.add(panel);
	}

	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == nextBtn){
			nextBtn.setBackground(mycolor4);
			nextBtn.setForeground(mycolor2);
			nextBtn.setFont(myFont2);
			nextBtn.setBounds(180,250,140,39);
		}else if(me.getSource() == backBtn){
			backBtn.setBackground(mycolor4);
			backBtn.setForeground(mycolor2);
			backBtn.setFont(myFont2);
			backBtn.setBounds(30,250,140,39);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == nextBtn){
			nextBtn.setBackground(mycolor1);
			nextBtn.setForeground(Color.WHITE);
			nextBtn.setFont(myFont);
			nextBtn.setBounds(200,255,100,33);
		}else if(me.getSource() == backBtn){
			backBtn.setBackground(mycolor1);
			backBtn.setForeground(Color.WHITE);
			backBtn.setFont(myFont);
			backBtn.setBounds(50,255,100,33);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
			if(nextBtn.getText().equals(command)){
				String loca = locationTF.getText();
			if( loca.isEmpty()){
				JOptionPane.showMessageDialog(this, "Location is empty...");
			}else{
			PizzaSelect sel = new PizzaSelect();
			sel.setVisible(true);
			this.setVisible(false);}
		}else if(backBtn.getText().equals(command)){
			Welcome wel=new Welcome();
			wel.setVisible(true);
			this.setVisible(false);
		}
}

}