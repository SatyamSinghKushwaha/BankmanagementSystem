package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;//date class in it
public class Withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw , back;
    String pinNumber; 
    
    Withdraw(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw.");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(170,330,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,390,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(365,525,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(365,560,150,30);
        back.addActionListener(this);
        image.add(back);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
           String amountNo = amount.getText();
           Date date = new Date();
           if(amountNo.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter the amount ");
           }else{
               Conn con = new Conn();
               String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amountNo+"')";
               try{
                  con.s.executeUpdate(query); 
                  JOptionPane.showMessageDialog(null,"Rs "+amountNo+" Withdrow Successfully");
                  setVisible(false);
                  new Transactions(pinNumber).setVisible(true);
               }catch(Exception e){
                   System.out.println(e);
               }
               
           }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    
    public static void main(String[] args) {
        new Withdraw("");
    }
}
