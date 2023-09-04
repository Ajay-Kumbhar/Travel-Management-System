import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgotPassword extends JFrame implements ActionListener{
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;
    ForgotPassword(){
        setBounds(300, 200, 850, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(580, 70, 200, 200);
        add(l6);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(30, 30, 500, 300);
        add(p);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(25, 20, 150, 25);
        l1.setFont(new Font("Tahoma",Font.BOLD, 14));
        p.add(l1);

        t1 = new JTextField();
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setBounds(225, 20, 150, 25);
        p.add(t1);

        b1 = new JButton("Search");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(390, 20, 90, 25);
        p.add(b1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(25, 60, 150, 25);
        l2.setFont(new Font("Tahoma",Font.BOLD, 14));
        p.add(l2);

        t2 = new JTextField();
        t2.setBounds(225, 60, 150, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p.add(t2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setBounds(25, 100, 180, 25);
        l3.setFont(new Font("Tahoma",Font.BOLD, 14));
        p.add(l3);

        t3 = new JTextField();
        t3.setBounds(225, 100, 250, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p.add(t3);

        JLabel l4 = new JLabel("Answer");
        l4.setBounds(25, 140, 180, 25);
        l4.setFont(new Font("Tahoma",Font.BOLD, 14));
        p.add(l4);

        t4 = new JTextField();
        t4.setBounds(225, 140, 150, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p.add(t4);

        b2 = new JButton("Retrieve");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(390, 140, 90, 25);
        p.add(b2);

        JLabel l5 = new JLabel("Password");
        l5.setBounds(25, 180, 180, 25);
        l5.setFont(new Font("Tahoma",Font.BOLD, 14));
        p.add(l5);

        t5 = new JTextField();
        t5.setBounds(225, 180, 150, 25);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p.add(t5);

        b3 = new JButton("Back");
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
        b3.setBounds(225, 220, 75, 25);
        b3.addActionListener(this);
        p.add(b3);
    }

    public void actionPerformed(ActionEvent ae){
        conn c = new conn();
        if(ae.getSource() == b1){

            try{

                String sql = "select * from account where username = '"+t1.getText()+"'";
                ResultSet rs = c.s.executeQuery(sql);
                while(rs.next()){
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("security"));
                }

            }catch(Exception e){}


        }else if(ae.getSource() == b2){

            try{

                String sql = "select password from account where answer = '"+t4.getText()+"' AND username = '"+t1.getText()+"'";
                ResultSet rs = c.s.executeQuery(sql);
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Incorrect answer");
                    t5.setText("");
                }else{
                    t5.setText(rs.getString("password"));
                }
            }catch(Exception e){}

        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args){
        new ForgotPassword().setVisible(true);
    }
    
}
