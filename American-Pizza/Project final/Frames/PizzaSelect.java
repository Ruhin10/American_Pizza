package Frames;
import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PizzaSelect extends JFrame implements MouseListener{
	
	JCheckBox classicPizza,chickenPizza,vegPizza,beefPizza,bbq,peparoni,chefs,chilli;
	JPanel Panel;
	Font myFont,myFont1,myFont2,myFont3;
    Color mycolor1,mycolor2,mycolor3,mycolor4,mycolor6;
    ImageIcon icon;
    JLabel title,available,emp,imgL;
    JButton next,back;
    user u = null;
	users us = null;

    public PizzaSelect(){
    	super("Pizza Selection");
    	this.setSize(800,530);
		this.us = us;
		icon = new ImageIcon("images\\icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		mycolor1=new Color(0,0,0);
		mycolor2=new Color(227, 124,44);
		mycolor3=new Color(0, 92, 103);
		mycolor4 =new Color(172, 219, 206);
		mycolor6 =new Color(47, 48, 60);

		myFont=new Font("serif",Font.PLAIN,24);
		myFont1=new Font("Titillium Web",Font.ITALIC,16);
		myFont2=new Font("Titillium Web",Font.BOLD,32);
		myFont3=new Font("serif",Font.BOLD,30);

		Panel=new JPanel();

		Panel.setLayout(null);
		Panel.setBackground(mycolor4);

	

		title = new JLabel("Select Your Pizza");
		title.setBounds(265,30,400,35);
		title.setBackground(mycolor4);
		title.setFont(myFont2);
		Panel.add(title);

		available=new JLabel("Available Pizzas");
		available.setBounds(20,75,350,35);
		available.setBackground(mycolor4);
		available.setFont(myFont2);
		Panel.add(available);

		classicPizza = new JCheckBox("Classic Pizza                                              $10");
		classicPizza.setBounds(30,120,500,25);
		classicPizza.setBackground(null);
		classicPizza.setFont(myFont);

        chickenPizza = new JCheckBox("Chicken Pizza                                            $13");
        chickenPizza.setBounds(30,155,500,25);
       	chickenPizza.setBackground(null);
		chickenPizza.setFont(myFont);
 
        vegPizza = new JCheckBox("Vegetable Pizza                                         $11");
        vegPizza.setBounds(30,190,500,25);
        vegPizza.setBackground(null);
		vegPizza.setFont(myFont);
 
        chefs = new JCheckBox("Chefs's Special Pizza                                 $18");
        chefs.setBounds(30,225,600,25);  
        chefs.setBackground(null);
		chefs.setFont(myFont);

		bbq = new JCheckBox("BBQ Pizza                                                $17");
        bbq.setBounds(30,260,500,25);
        bbq.setBackground(null);
		bbq.setFont(myFont);

		peparoni = new JCheckBox("Peparoni Pizza                                           $15");
        peparoni.setBounds(30,295,500,25); 
        peparoni.setBackground(null);
		peparoni.setFont(myFont);


		beefPizza = new JCheckBox("Beef Pizza                                                 $13");
        beefPizza.setBounds(30,330,500,25);	
        beefPizza.setBackground(null);
		beefPizza.setFont(myFont);

		chilli = new JCheckBox("Chilli Pizza                                                $14");
        chilli.setBounds(30,365,500,25);
        chilli.setBackground(null);
		chilli.setFont(myFont);

		Panel.add(chickenPizza);
		Panel.add(classicPizza);
		Panel.add(vegPizza);
		Panel.add(chefs);
		Panel.add(beefPizza);
		Panel.add(bbq);
		Panel.add(peparoni);
		Panel.add(chilli);


		back = new JButton("Back");
		back.setFont(myFont);
		back.setBorder(null);
		back.setBounds(200,420,100,33);
		back.setBackground(mycolor3);
		back.setForeground(Color.WHITE);
		back.addMouseListener(this);
		back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   	Welcome wel=new Welcome();
                   setVisible(false);
                  
                }
            }
        );

		Panel.add(back);
		
		next = new JButton("Next");
		next.setBounds(350,420,110,33);
		next.setBorder(null);
		next.setFont(myFont);
		next.setBackground(mycolor3);
		next.setForeground(Color.WHITE);
		next.addMouseListener(this);
		next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean[] selectedPizzas = getSelectedPizzas();
                    new BillWindow(selectedPizzas).setVisible(true);
                }
            });
		 Panel.add(next);
		 this.add(Panel);


}

	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == next){
			next.setBackground(mycolor6);
			next.setForeground(mycolor4);
			next.setFont(myFont2);
			next.setBounds(340,410,130,39);
		}else if(me.getSource() == back){
			back.setBackground(mycolor6);
			back.setForeground(mycolor4);
			back.setFont(myFont2);
			back.setBounds(190,410,120,39);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == next){
			next.setBackground(mycolor3);
			next.setForeground(Color.WHITE);
			next.setFont(myFont);
			next.setBounds(350,420,110,33);
		}else if(me.getSource() == back){
			back.setBackground(mycolor3);
			back.setForeground(Color.WHITE);
			back.setFont(myFont);
			back.setBounds(200,420,100,33);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

		public boolean[] getSelectedPizzas() {
            boolean[] selectedItems = new boolean[8];
            selectedItems[0] = classicPizza.isSelected();
            selectedItems[1] = chickenPizza.isSelected();
            selectedItems[2] = vegPizza.isSelected();
            selectedItems[3] = chefs.isSelected();
            selectedItems[4] = bbq.isSelected();
            selectedItems[5] = peparoni.isSelected();
            selectedItems[6] = beefPizza.isSelected();
            selectedItems[7] = chilli.isSelected();
            return selectedItems;
        }



     public class BillWindow extends JFrame{

     	JPanel buttonPanel;
		JButton addButton;
		JButton removeButton;
		JButton paymentButton;
		JLabel totalLabel;
        double[] pizzaPrices = {10, 13, 11, 18, 17, 15, 13, 14};



            BillWindow(boolean[] selectedPizzas) {
                setTitle("Your Bill");
             	setBackground(mycolor4);
              
                JPanel billPanel = new JPanel();
                billPanel.setBackground(mycolor4);
                billPanel.setLayout(new BoxLayout(billPanel, BoxLayout.Y_AXIS));
              	billPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel billLabel = new JLabel("Bill", SwingConstants.CENTER);
                billLabel.setFont(myFont2);
                billLabel.setBackground(mycolor4);
           		add(billLabel, BorderLayout.NORTH);
    
                String[] pizzaTypes = {"Classic Pizza - $10", "Chicken Pizza - $13", "Veg Pizza - $11", "Chefs's Special Pizza - $18","BBQ Pizza - $17","Peparoni Pizza - $15","Beef Pizza - $13","Chilli Pizza - $14"};
                double totalAmount = calculateTotal(selectedPizzas);
                for (int i = 0; i < selectedPizzas.length; i++) {
                    if (selectedPizzas[i]) {
                        JLabel pizzaLabel = new JLabel(pizzaTypes[i], JLabel.CENTER);
                        pizzaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);                 
                        pizzaLabel.setFont(myFont);
                        pizzaLabel.setBackground(null);
                        billPanel.add(pizzaLabel);
                    }
                }

                    totalLabel = new JLabel("Total: $" + totalAmount);
		            totalLabel.setFont(myFont);
		            totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		            totalLabel.setBackground(null);
		            billPanel.add(totalLabel);
    
                add(new JScrollPane(billPanel), BorderLayout.CENTER);
    
                 buttonPanel = new JPanel();
                 addButton = new JButton("  Add  ");
                 removeButton = new JButton("  Remove  ");
                 paymentButton = new JButton("  Payment  ");

         
				addButton.setFont(myFont);
				addButton.setBorder(null);
				addButton.setBackground(mycolor3);
				addButton.setForeground(Color.WHITE);

				removeButton.setFont(myFont);
				removeButton.setBorder(null);
				removeButton.setBackground(mycolor3);
				removeButton.setForeground(Color.WHITE);

				paymentButton.setFont(myFont);
				paymentButton.setBorder(null);
				paymentButton.setBackground(mycolor3);
				paymentButton.setForeground(Color.WHITE);

               paymentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   payment pay = new payment();
				pay.setVisible(true);
			setVisible(false);                  }
              }

          );

                addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
                  removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
					setVisible(false);
                }
            });

         
                buttonPanel.setBounds(0,320,500,60);
                buttonPanel.add(addButton);
                buttonPanel.add(removeButton);
                buttonPanel.add(paymentButton);
    
               add(buttonPanel, BorderLayout.SOUTH);
    
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setSize(500,380);
                setLocationRelativeTo(null);
        }
         private double calculateTotal(boolean[] selectedPizzas) {
            double total = 0;
            for (int i = 0; i < selectedPizzas.length; i++) {
                if (selectedPizzas[i]) {
                    total += pizzaPrices[i];
                }
            }
            return total;

}
}}