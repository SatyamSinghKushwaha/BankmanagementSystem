package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton saving , current ,fd,recurring;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo;
    SignupThree(String formNo){
        this.formNo=formNo;
        setTitle("Page 03: Account Details");
        setLayout(null);
        JLabel l1 = new JLabel("Page 03: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,25));
        l1.setBounds(280,60,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,40);
        add(type);
        saving = new JRadioButton("Savings Account");
        saving.setBounds(100,180,200,40);
        saving.setBackground(Color.WHITE);
        saving.setFont(new Font("Raleway",Font.BOLD,14));
        add(saving);
        current = new JRadioButton("Current Account");
        current.setBounds(400,180,200,40);
        current.setBackground(Color.WHITE);
        current.setFont(new Font("Raleway",Font.BOLD,14));
        add(current);
        fd = new JRadioButton("Fixed Deposite Account");
        fd.setBounds(100,230,200,40);
        fd.setBackground(Color.WHITE);
        fd.setFont(new Font("Raleway",Font.BOLD,14));
        add(fd);
        recurring = new JRadioButton("Recurring Deposite Account");
        recurring.setBounds(400,230,300,40);
        recurring.setBackground(Color.WHITE);
        recurring.setFont(new Font("Raleway",Font.BOLD,14));
        add(recurring);
        ButtonGroup acc = new ButtonGroup();
        acc.add(saving);
        acc.add(current);
        acc.add(fd);
        acc.add(recurring);
        
        JLabel card = new JLabel("Card Number  :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,290,200,40);
        add(card);
        JLabel cardN = new JLabel("XXX-XXX-XXX-1234");
        cardN.setFont(new Font("Raleway",Font.BOLD,22));
        cardN.setBounds(350,290,300,40);
        add(cardN);
        JLabel cardInfo = new JLabel("*your 16 digit card number is:");
        cardInfo.setFont(new Font("Raleway",Font.BOLD,10));
        cardInfo.setForeground(Color.BLUE);
        cardInfo.setBounds(100,320,200,20);
        add(cardInfo);
        JLabel pin = new JLabel("PIN  :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,340,200,40);
        add(pin);
        JLabel pinN = new JLabel("XXX");
        pinN.setFont(new Font("Raleway",Font.BOLD,22));
        pinN.setBounds(350,340,200,40);
        add(pinN);
        JLabel pinInfo = new JLabel("*your 4 digit pin is:");
        pinInfo.setFont(new Font("Raleway",Font.BOLD,10));
        pinInfo.setForeground(Color.BLUE);
        pinInfo.setBounds(100,370,200,20);
        add(pinInfo);
        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,400,200,40);
        add(service);
        c1 = new JCheckBox("Debit Card");
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,440,200,40);
        add(c1);
        c6 = new JCheckBox("Internet Banking");
        c6.setFont(new Font("Raleway",Font.BOLD,14));
        c6.setBackground(Color.WHITE);
        c6.setBounds(400,440,200,40);
        add(c6);
        c2 = new JCheckBox("Mobile Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBackground(Color.WHITE);
        c2.setBounds(100,490,200,40);
        add(c2);
        c3 = new JCheckBox("E-Mail & SMS Alerts");
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBackground(Color.WHITE);
        c3.setBounds(400,490,200,40);
        add(c3);
        c4 = new JCheckBox("CheckBook");
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBackground(Color.WHITE);
        c4.setBounds(100,540,200,40);
        add(c4);
        c5 = new JCheckBox("E-Statement");
        c5.setFont(new Font("Raleway",Font.BOLD,14));
        c5.setBackground(Color.WHITE);
        c5.setBounds(400,540,200,40);
        add(c5);
        c7 = new JCheckBox("I hereby by declare that all the above information are correct to my knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,600,600,40);
        add(c7);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,650,100,40);
        cancel.addActionListener(this);
        add(cancel);
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(450,650,100,40);
        submit.addActionListener(this);
        add(submit);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,830);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = null;
            if(saving.isSelected()){
                accountType ="Saving Account";
            } 
            else if(current.isSelected()){
                accountType ="Current Account";
            }
            else if(fd.isSelected()){
                accountType ="Fixed Deposite Account";
            }
            else if(recurring.isSelected()){
                accountType ="Recurring Deposite Account";
            }
            
            long CardNo = (long)(Math.random() * 10000000000L)+6922690000000000L;
            int pinNo = (int)(Math.random()*9000)+1000;
            
            String facility ="";
            if(c1.isSelected()){
                facility =facility +" Debit Card";
            }else if(c2.isSelected()){
                facility =facility+" Internet Banking";
            }else if(c3.isSelected()){
                facility = facility+" Mobile Banking";
            }else if(c4.isSelected()){
                facility=facility+" Email & SMS services";
            }else if(c5.isSelected()){
                facility=facility+" CheckBook";
            }else if(c6.isSelected()){
                facility=facility+" E-Statement";
            }
            try{
                //validate
                if(accountType==null || accountType==""){
                    JOptionPane.showMessageDialog(null,"Account type can't be empty");
                }else if(!(c7.isSelected())){
                    JOptionPane.showMessageDialog(null, "please check acknowledgement ");
                }else{
                    Conn con = new Conn();
                    String query1 =  "insert into signupthree values('"+formNo+"','"+accountType+"','"+CardNo+"','"+pinNo+"','"+facility+"')";
                    con.s.executeUpdate(query1);
                    String query2 =  "insert into login values('"+formNo+"','"+CardNo+"','"+pinNo+"')";
                    con.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card NO:"+CardNo+"\n Pin:"+pinNo);
                    //we want to open the deposite screen as account cant be emty initialy
                    setVisible(false);
                    //we need to convert the pin from int to string
                    new Deposite(""+pinNo).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new SignupThree("");
    }
}
