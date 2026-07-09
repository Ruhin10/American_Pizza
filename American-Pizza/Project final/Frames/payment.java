package Frames;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class payment extends JFrame  implements MouseListener, ActionListener {
	JPanel Panel;
	JLabel imgL;
	JTextField phoneTF;
	JPasswordField pinTF;
	ImageIcon frame,icon;
	JButton confirmBtn,back;
	Font myFont,myFont2;
	Color cl;	

	public payment(){
		super("payment");
		this.setSize(640,498);
		icon = new ImageIcon("images\\icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);

		cl = new Color(169, 23, 75);
	
		myFont=new Font("serif",Font.PLAIN,24);
		myFont2=new Font("serif",Font.BOLD,30);
		

		Panel=new JPanel();
		Panel.setBackground(cl);

		Panel.setLayout(null);

		phoneTF = new JTextField("");
		phoneTF.setBounds(180,230,260,35);
		phoneTF.setFont(myFont);
		phoneTF.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		Panel.add(phoneTF);
		
		pinTF = new JPasswordField();
		pinTF.setBounds(240,330,120,35);
		pinTF.setEchoChar('*');
		pinTF.setFont(myFont);
		pinTF.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		Panel.add(pinTF);


		confirmBtn = new JButton("Confirm");
		confirmBtn.setFont(myFont);
		confirmBtn.setBorder(null);
		confirmBtn.setBounds(320,380,110,33);
		confirmBtn.setBackground(Color.WHITE);
		confirmBtn.setForeground(Color.BLACK);
		confirmBtn.addActionListener(this);
		confirmBtn.addMouseListener(this);
	

		Panel.add(confirmBtn);
		
		back = new JButton("Back");
		back.setBounds(180,380,70,33);
		back.setBorder(null);
		back.setFont(myFont);
		back.setBackground(Color.WHITE);
		back.setForeground(Color.BLACK);
		back.addActionListener(this);
		back.addMouseListener(this);
		Panel.add(back);

		frame= new ImageIcon("images\\BkashPayment.png");
				imgL = new JLabel(frame);
				imgL.setBounds(0,0,625,487);
				Panel.add(imgL);
		this.add(Panel);}

	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == confirmBtn){
			confirmBtn.setBackground(Color.WHITE);
			confirmBtn.setForeground(Color.BLACK);
			confirmBtn.setFont(myFont2);
			confirmBtn.setBounds(315,382,120,35);
		}else if(me.getSource() == back){
			back.setBackground(Color.WHITE);
			back.setForeground(Color.BLACK);
			back.setFont(myFont2);
			back.setBounds(175,382,80,35);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == confirmBtn){
			confirmBtn.setBackground(Color.WHITE);
			confirmBtn.setForeground(Color.BLACK);
			confirmBtn.setFont(myFont);
			confirmBtn.setBounds(320,380,110,33);
		}else if(me.getSource() == back){
			back.setBackground(Color.WHITE);
			back.setForeground(Color.BLACK);
			back.setFont(myFont);
			back.setBounds(180,380,70,33);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
			if(back.getText().equals(command)){
				PizzaSelect sel = new PizzaSelect();
				sel.setVisible(true);
				this.setVisible(false);}
				
			else if(confirmBtn.getText().equals(command)){
			String phone = phoneTF.getText();
			String pin = pinTF.getText();

			try{
				FileReader fr= new FileReader("Files/Bkash.txt");
				Scanner reader =new Scanner(fr);

				while(reader.hasNext())
				{

					String ph=reader.next();
					String pn=reader.next();
					if(phone.equals(ph.trim()) && pin.equals(pn.trim()))
					{
						reader.close();
						Preparing mg = new Preparing();
						mg.setVisible(true);
						this.setVisible(false);

					}
				}
				JOptionPane.showMessageDialog(null,"Mobile number or Pin incorrect..");
			}catch(Exception e){

			}
			
		}}
				
}