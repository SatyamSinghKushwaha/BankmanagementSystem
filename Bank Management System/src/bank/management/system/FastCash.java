package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;//specify Date class as its present in sql package too.
public class FastCash extends JFrame implements ActionListener {
    JButton deposite,withdraw,fastcash,balanceEnq,pinchange,ministatement,exit;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select FastCash Amount");
        text.setBounds(215,330,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        //we wanted the text above the image so called add with image otherwise it would just add on the frame.
        image.add(text);
        
        deposite = new JButton("Rs 100");
        deposite.setBounds(170,450,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        withdraw = new JButton("Rs 200");
        withdraw.setBounds(355,450,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        fastcash = new JButton("Rs 500");
        fastcash.setBounds(170,485,150,30);
        image.add(fastcash);
        fastcash.addActionListener(this);
        ministatement = new JButton("rs 1000");
        ministatement.setBounds(355,485,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,520,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceEnq = new JButton("Rs 10000");
        balanceEnq.setBounds(355,520,150,30);
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);
        exit = new JButton("Back");
        exit.setBounds(355,555,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);//remove windows title bar and borders
        setVisible(true);//must be the last line
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            //we will take the text written on the button name
            //ae.getSource() returns object we convert it JButton and get its text
            String amount = ((JButton)ae.getSource()).getText().substring(3);//(3)removes starting 3 char (ie. rs_100)
            System.err.println(amount);
             Conn con = new Conn();
             Date date = new Date();

               try{
                ResultSet rs = con.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
                int balance =0;
                while(rs.next()){
                 if(rs.getString("type").equals("Deposite")){
                     balance=Integer.parseInt(rs.getString("amount"));

                 }else if(rs.getString("type").equals("Withdrawl")){
                     balance-=Integer.parseInt(rs.getString("amount"));
                 }   
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+amount+" deducted from your account.");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
               }catch(Exception e){
                   System.out.println(e);
               }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
