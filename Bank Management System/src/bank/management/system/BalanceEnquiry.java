package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinNumber;
    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;
        Conn con = new Conn();
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        back = new JButton("Back");
        back.setBounds(355,555,150,30);
        back.addActionListener(this);
        image.add(back);
        
        int balance =0;
        try{  ResultSet rs = con.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
                while(rs.next()){
                 if(rs.getString("type").equals("Deposite")){
                     balance+=Integer.parseInt(rs.getString("amount"));

                 }else if(rs.getString("type").equals("Withdrawl")){
                     balance-=Integer.parseInt(rs.getString("amount"));
                 }   
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JLabel bal = new JLabel("your current balance is :"+balance);
        bal.setForeground(Color.WHITE);
        bal.setFont(new Font("Raleway",Font.BOLD,18));
        bal.setBounds(200,310,700,35);
        image.add(bal);
        
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
