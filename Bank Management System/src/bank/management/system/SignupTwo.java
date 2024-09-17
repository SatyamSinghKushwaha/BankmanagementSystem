package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton eno,eyes,syes,sno;
    JComboBox religionOption,categoryOption,incomeOption,educationOption,occupationOption;
    String formNo;
    
    SignupTwo(String formNo){ 
        this.formNo=formNo;
        setTitle("NEW ACCOUNT APPLICATION PAGE:2");
        JLabel additionalDetails = new JLabel("Page 02: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,40);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        //JComboBox gives a dropdown box
        religionOption = new JComboBox(valReligion);
        religionOption.setBounds(300,140,400,30);
        religionOption.setBackground(Color.WHITE);
        add(religionOption);

        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        String valCategory[]={"General","OBC","SC/ST"};
        categoryOption = new JComboBox(valCategory);
        categoryOption.setBounds(300,190,400,30);
        categoryOption.setBackground(Color.WHITE);
        add(categoryOption);
     
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,235,200,30);
        add(income);
        String valIncome[]={"Null","<1,50,000","<2,50,000","<5,50,000","<10,00,000","10,00,000+"};
        incomeOption = new JComboBox(valIncome);
        incomeOption.setBounds(300,240,400,30);
        incomeOption.setBackground(Color.WHITE);
        add(incomeOption);
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,275,200,30);
        add(education);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,300,200,30);
        add(qualification);
        String valEducation[]={"UnEducated","Diploma/12","Graduate","Post Graduate","Doctrate","Others"};
        educationOption = new JComboBox(valEducation);
        educationOption.setBounds(300,290,400,30);
        educationOption.setBackground(Color.WHITE);
        add(educationOption);
        
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,340,200,30);
        add(occupation);
        String valOccupation[]={"Salaried","Self-Employed","Bussiness","Retired","Student","Others"};
        occupationOption = new JComboBox(valOccupation);
        occupationOption.setBounds(300,340,400,30);
        occupationOption.setBackground(Color.WHITE);
        add(occupationOption);
        
        JLabel panNO = new JLabel("PAN number:");
        panNO.setFont(new Font("Raleway",Font.BOLD,20));
        panNO.setBounds(100,390,200,30);
        add(panNO);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,390,400,30);
        add(panTextField);
        
        JLabel aadharNo = new JLabel("Aadhar Number:");
        aadharNo.setFont(new Font("Raleway",Font.BOLD,20));
        aadharNo.setBounds(100,440,200,30);
        add(aadharNo);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,440,400,30);
        add(aadharTextField);
                
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,490,200,30);
        add(senior);
        syes = new JRadioButton("Yes");
        syes.setBounds(300,490,150,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(500,490,150,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        //to select any one at a time we have to grp both the radio buttons 
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel existingAcc = new JLabel("Existing Account:");
        existingAcc.setFont(new Font("Raleway",Font.BOLD,20));
        existingAcc.setBounds(100,540,200,30);
        add(existingAcc);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,540,150,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(500,540,150,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        //to select any one at a time we have to grp both the radio buttons 
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        next = new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,100,30);
        next.addActionListener(this);
        add(next);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);  
    }
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionOption.getSelectedItem();
        String category = (String)categoryOption.getSelectedItem();
        String income = (String)incomeOption.getSelectedItem();
        String education = (String)educationOption.getSelectedItem();
        String occupation = (String)occupationOption.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen ="Yes";
        }else if(sno.isSelected()){
            seniorCitizen = "No";
        }
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount ="Yes";
        }else if(eno.isSelected()){
            existingAccount = "No";
        }
        try{
            if(religion.equals("")||category.equals("")||income.equals("")||education.equals("")||occupation.equals("")||seniorCitizen.equals("")||pan.equals("")||aadhar.equals("")){
                //popup window
               JOptionPane.showMessageDialog(null,"Inputs cann't be empty!"); 
            }
            else{
                Conn con = new Conn();
                String query = "insert into signuptwo values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                con.s.executeUpdate(query);
                
                //signup3 object
                setVisible(false);
                new SignupThree(formNo).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
       new SignupTwo(""); 
    }
    
}
