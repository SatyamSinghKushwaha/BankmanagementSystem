package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener{
    JButton save,back;
    JPasswordField newPin ,rePin;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Do You Really Want To change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(200,310,700,35);
        image.add(text);
        JLabel text2 = new JLabel("New Pin:");
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Raleway",Font.BOLD,16));
        text2.setBounds(170,360,100,25);
        image.add(text2);
        newPin = new JPasswordField();
        newPin.setFont(new Font("Raleway",Font.BOLD,14));
        newPin.setBounds(280,360,200,25);
        add(newPin);
        JLabel text3 = new JLabel("Re Enter Pin:");
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("Raleway",Font.BOLD,16));
        text3.setBounds(170,390,150,25);
        image.add(text3);
        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway",Font.BOLD,14));
        rePin.setBounds(280,390,200,25);
        add(rePin);
        save = new JButton("Save");
        save.setBounds(355,520,150,30);
        save.addActionListener(this);
        image.add(save);
        back= new JButton("Back");
        back.setBounds(355,555,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==save){
        try{
            String npin= newPin.getText();
            String rpin = rePin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "password confirmation mismatched");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the new pin.");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter the new pin");
                return;
            }
            Conn con = new Conn();
            //we have to change the pin number in all the tables so querey for all
            String query1 = "update bank set pin ='"+rpin+"'where pin = '"+pinNumber+"'";
            String query2 = "update login set pin ='"+rpin+"'where pin = '"+pinNumber+"'";
            String query3 = "update signupthree set PinNumber ='"+rpin+"'where PinNumber = '"+pinNumber+"'";
            
            con.s.executeUpdate(query1);
            con.s.executeUpdate(query2);
            con.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
                    System.out.println(e);
        }
        }else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
