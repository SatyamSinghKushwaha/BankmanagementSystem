package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//contains interface ActionListener
import java.sql.*;

//jframe helps in creating frames
public class Login extends JFrame implements ActionListener{
    JButton login ,clear , signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
       setTitle("AUTOMATIC TELLER MACHINE");
       
       setLayout(null);//as bydefault layout is border
       //class-ClassLoader static method -getSystemResource
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       //scale image
       Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);//as Jlabel don't take Image class obj as input
       JLabel label = new JLabel(i3);
       label.setBounds(70,10,100,100);  //custom layout built (distance from LHS,above distance,component width,height)
       add(label);//used to stick items in frame
       JLabel text =new JLabel("Welcome to ATM");
       text.setFont(new Font("Oswald",Font.BOLD,38));
       text.setBounds(200, 40, 400, 40);
       add(text);
       
       JLabel cardNo =new JLabel("Card no :");
       cardNo.setFont(new Font("Raleway",Font.BOLD,28));
       cardNo.setBounds(120, 120, 150, 40);
       add(cardNo);
       
       cardTextField = new JTextField();
       cardTextField.setBounds(280,120,250,30);
       cardTextField.setFont(new Font("Arial",Font.BOLD,14));
       add(cardTextField);
       
       JLabel pin =new JLabel("Pin :");
       pin.setFont(new Font("Raleway",Font.BOLD,28));
       pin.setBounds(120, 180, 250, 30);
       add(pin);
       
       pinTextField = new JPasswordField();
       pinTextField.setBounds(280,180,250,30);
       pinTextField.setFont(new Font("Arial",Font.BOLD,14));
       add(pinTextField);
       
       login = new JButton("SIGN IN");
       login.setBounds(280,250,100,30);
       login.setBackground(Color.black);
       login.setForeground(Color.white);
       login.addActionListener(this);
       add(login);
       
       clear = new JButton("CLEAR");
       clear.setBounds(430,250,100,30);
       clear.setBackground(Color.black);
       clear.setForeground(Color.white);
       clear.addActionListener(this);
       add(clear);
       
       signup = new JButton("SIGN UP");
       signup.setBounds(280,310,250,30);
       signup.setBackground(Color.black);
       signup.setForeground(Color.white);
       signup.addActionListener(this);
       add(signup);
       
       //getContentPane() selects the whole frame
       getContentPane().setBackground(Color.white);
       setSize(800,400);
       setVisible(true);
       setLocation(400,200);//from where frame opens
    }
    //overriden method of interface ActionListener
    public void actionPerformed(ActionEvent ae){
        //what do onclick of button is in this fun 
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){
            Conn con = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where CardNumber = '"+cardNumber+"' and Pin = '"+pinNumber+"'";
            try{
               ResultSet rs = con.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinNumber).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pin.");
               }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }
    public static void main(String[] args) {
       new Login();  
    }
   
    
}

/*
image class is within awt
*/

