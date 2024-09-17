package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener{
    String pinNumber;
    JButton back;
    MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;
        setTitle("Mini Statement");
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel bal = new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from login where Pin ='"+pinNumber+"'");
            while(rs.next()){
                //setText() is used to assign values to the labels
                card.setText("Card number :"+rs.getString("CardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("CardNumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
         try{
            Conn con = new Conn();
            int bala =0;
            ResultSet rs = con.s.executeQuery("select * from bank where Pin ='"+pinNumber+"'");
            while(rs.next()){
               //setText overrides the data so in order to append the we need to do...
               mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br>");
                if(rs.getString("type").equals("Deposite")){
                     bala=Integer.parseInt(rs.getString("amount"));

                 }else if(rs.getString("type").equals("Withdrawl")){
                     bala-=Integer.parseInt(rs.getString("amount"));
                 } 
            }
            bal.setText("your current balance is :"+bala);
         }
         catch(Exception e){
            System.out.println(e);
        }
        
        setLayout(null);
        setLocation(20,20);
        setSize(400,600);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
