package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {
    JButton deposite,withdraw,fastcash,balanceEnq,pinchange,ministatement,exit;
    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215,330,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        //we wanted the text above the image so called add with image otherwise it would just add on the frame.
        image.add(text);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(170,450,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(355,450,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,485,150,30);
        image.add(fastcash);
        fastcash.addActionListener(this);
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,485,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,520,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceEnq = new JButton("Balance Enquiry");
        balanceEnq.setBounds(355,520,150,30);
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);
        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposite){
             setVisible(false);
            new Deposite(pinNumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }else if (ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource()==balanceEnq){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
